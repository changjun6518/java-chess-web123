package demo.javachess.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SQUARE_ID")
    private Long id;

    @Embedded
    private Position position;

    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Piece piece;


    public Square(Position position, State state, Piece piece) {
        this.position = position;
        this.state = state;
        this.piece = piece;
    }

    protected Square() {

    }

    public static Square of(Position position, State state, Piece piece) {
        return new Square(position, state, piece);
    }

    public boolean isBlank() {
        return state.equals(State.NONE) && piece == Piece.NONE;
    }

    public boolean isSameTeam(Square targetSquare) {
        return state == targetSquare.getState();
    }

    public boolean isOtherTeam(Square targetSquare) {
        return state != targetSquare.getState();
    }

    public boolean isWhite() {
        return state == State.WHITE;
    }

    private boolean isBlack() {
        return state == State.BLACK;
    }
    public boolean isFirstTurn() {
        return (isWhite() && position.getRank() == 2) |
                (isBlack() && position.getRank() == 7);
    }


}
