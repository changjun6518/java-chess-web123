package demo.javachess.domain.piece;

public enum ColorCase {
    WHITE,
    BLACK,
    BLANK,
    ;

    public boolean isNotSame(ColorCase colorCase) {
        return this != colorCase && this != BLANK && colorCase != BLANK;
    }

    public boolean isSame(ColorCase color) {
        return this == color;
    }
}
