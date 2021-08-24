package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class Knight extends Piece{
    public Knight(PieceType pieceType, ColorCase colorCase, Position position, char representation) {
        super(pieceType, colorCase, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new Knight(pieceType, colorCase, toPosition, representation);
    }

    public static Knight createWhite(Position position) {
        return new Knight(PieceType.KNIGHT, ColorCase.WHITE, position, 'n');
    }
    public static Knight createBlack(Position position) {
        return new Knight(PieceType.KNIGHT, ColorCase.BLACK, position, 'N');
    }
}
