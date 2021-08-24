package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class Queen extends Piece{
    public Queen(PieceType pieceType, ColorCase colorCase, Position position, char representation) {
        super(pieceType, colorCase, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new Queen(pieceType, colorCase, toPosition, representation);
    }

    public static Queen createWhite(Position position) {
        return new Queen(PieceType.QUEEN, ColorCase.WHITE, position, 'q');
    }
    public static Queen createBlack(Position position) {
        return new Queen(PieceType.QUEEN, ColorCase.BLACK, position, 'Q');
    }

}
