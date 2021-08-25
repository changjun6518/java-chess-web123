package demo.javachess.domain;

public enum Direction {
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0),

    NORTH_EAST(1, 1),
    NORTH_WEST(-1, 1),
    SOUTH_EAST(1, -1),
    SOUTH_WEST(-1, -1),

    SOUTH_SOUTH_EAST(1, -2),
    SOUTH_SOUTH_WEST(-1, -2),
    NORTH_NORTH_WEST(-1, 2),
    NORTH_NORTH_EAST(1, 2),
    EAST_EAST_SOUTH(2, -1),
    EAST_EAST_NORTH(2, 1),
    WEST_WEST_SOUTH(-2, -1),
    WEST_WEST_NORTH(-2, 1),

    NORTH_NORTH(0, 2),
    SOUTH_SOUTH(0, -2);

    private final int toFile;  // 가로(열)
    private final int toRank; //  세로(행)

    Direction(int toFile, int toRank) {
        this.toFile = toFile;
        this.toRank = toRank;
    }

}
