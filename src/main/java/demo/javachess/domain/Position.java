package demo.javachess.domain;

import demo.javachess.domain.Exception.InvalidPositionException;

import java.util.HashMap;
import java.util.Map;

public class Position {
    static final int ASCII_GAP = 96;

    private int file;
    private int rank;

    private static final Map<String, Position> BOARD_POSITIONS = new HashMap<>();

    public Position(int file, int rank) {
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
}
