package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class Blank extends Piece {
    public Blank(PieceType pieceType, ColorCase colorCase, Position position, char representation) {
        super(pieceType, colorCase, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new Blank(pieceType, colorCase, toPosition, representation);
    }

    public static Blank createBlank(Position position) {
        return new Blank(PieceType.BLANK, ColorCase.BLANK, position, '.');
    }
}
