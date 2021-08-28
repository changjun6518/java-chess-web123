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
        return state.equals(State.NONE);
    }
}
