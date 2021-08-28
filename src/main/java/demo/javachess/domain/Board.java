package demo.javachess.domain;

import demo.javachess.domain.Exception.NoSuchSquareException;
import demo.javachess.domain.Exception.NotProperTurnException;
import demo.javachess.domain.Exception.StartFromBlankException;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOARD_ID")
    private List<Square> squares;

    private State turn;

    public Board(List<Square> squares) {
        this.squares = squares;
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
        if (fromSquare.getState() != turn) {
            throw new NotProperTurnException();
        }

    }
}
