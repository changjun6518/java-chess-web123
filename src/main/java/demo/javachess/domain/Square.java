package demo.javachess.domain;

import lombok.Getter;

@Getter
public class Square {
    private Position position;
    private State state;
    private Piece piece;

    public Square(Position position, State state, Piece piece) {
        this.position = position;
        this.state = state;
        this.piece = piece;
    }

    public static Square of(Position position, State state, Piece piece) {
        return new Square(position, state, piece);
    }

}
