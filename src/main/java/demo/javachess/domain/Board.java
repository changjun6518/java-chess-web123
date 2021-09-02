package demo.javachess.domain;

import demo.javachess.domain.Exception.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Board {
    private static final int BOARD_SIZE = 64;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOARD_ID")
    private List<Square> squares;

    private Team turn;

    public Board(List<Square> squares) {
        if (squares.size() != BOARD_SIZE) {
            throw new InvalidBoardSizeException();
        }
        this.squares = squares;
        this.turn = Team.WHITE;
    }


    public Board() {

    }

    public Square findSquareBy(final Position position) {
        return squares.stream()
                .filter(square -> Objects.equals(square.getPosition(), position))
                .findFirst()
                .orElseThrow(NoSuchSquareException::new);
    }

    public State move(final String fromValue, final String toValue) {
        Position from = Position.from(fromValue);
        Position to = Position.from(toValue);

        Square fromSquare = findSquareBy(from);

        if (fromSquare.isBlank()) {
            throw new StartFromBlankException();
        }
        if (fromSquare.getTeam() != turn) {
            throw new NotProperTurnException();
        }

        if (fromSquare.movable(this, to)) {
            Piece toPiece = findSquareBy(to).getPiece();
            Team movedTurn = fromSquare.getTeam();
            updateSquareBy(to, fromSquare.getPiece(), fromSquare.getTeam());
            updateSquareBy(from, Piece.NONE, Team.NONE);
            return getNextState(toPiece, movedTurn);
        }

        throw new InvalidMoveException();


    }

    private State getNextState(final Piece toPiece, final Team movedTurn) {
        if (toPiece.isKing()) {
            return new Finished(movedTurn);
        }
        return new Playing(movedTurn);
    }

    public void updateSquareBy(final Position position, final Piece piece, final Team team) {
        squares.forEach(square -> {
            if (Objects.equals(square.getPosition(), position)) {
                square.update(piece, team);
            }
        });
    }

    public List<Square> getSquares() {
        return squares;
    }

    public Long getId() {
        return id;
    }

    public String getTurn() {
        return turn.name();
    }

    public void updateTurn(final Team nextTurn) {
        this.turn = nextTurn;
    }
}
