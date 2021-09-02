package demo.javachess.domain;

public enum Team {
    WHITE,
    BLACK,
    NONE;

    public Team getOpposingState() {
        if (this == WHITE) {
            return BLACK;
        }
        if (this == BLACK) {
            return WHITE;
        }
        return NONE;
    }

}
