package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class Bishop extends Piece {

    public Bishop(PieceType pieceType, ColorCase colorCase, Position position, char representation) {
        super(pieceType, colorCase, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new Bishop(pieceType, colorCase, toPosition, representation);
    }

    public static Bishop createWhite(Position position) {
        return new Bishop(PieceType.BISHOP, ColorCase.WHITE, position, 'b');
    }
    public static Bishop createBlack(Position position) {
        return new Bishop(PieceType.BISHOP, ColorCase.BLACK, position, 'B');
    }
}
