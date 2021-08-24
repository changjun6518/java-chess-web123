package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class King extends Piece{
    public King(PieceType pieceType, ColorCase colorCase, Position position, char representation) {
        super(pieceType, colorCase, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new King(pieceType, colorCase, toPosition, representation);
    }

    public static Piece createWhite(Position position) {
        return new King(PieceType.KING, ColorCase.WHITE, position, 'k');
    }

    public static Piece createBlack(Position position) {
        return new King(PieceType.KING, ColorCase.BLACK, position, 'K');
    }
}
