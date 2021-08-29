package demo.javachess.domain;

import demo.javachess.domain.Exception.InvalidPositionException;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Embeddable
@Getter
public class Position {
    static final int ASCII_GAP = 96;

    private int file;
    private int rank;

    private static final Map<String, Position> BOARD_POSITIONS = new HashMap<>();

    static {
    }


    public Position() {

    }

    public Position(int file, int rank) {
        super();
        this.file = file;
        this.rank = rank;
    }

    public static Position from(final String position) {
        if (BOARD_POSITIONS.containsKey(position)) {
            return BOARD_POSITIONS.get(position);
        }
        throw new InvalidPositionException();
    }


    public static Position of(final char file, final int rank) {
        return new Position((file - ASCII_GAP), rank);
    }

    public Position updateWith(final Direction direction) {
        return Position.from((char) (file + direction.getToFile())
                + String.valueOf(rank + direction.getToRank()));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return file == position.file &&
                rank == position.rank;
    }
}
