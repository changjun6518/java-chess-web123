package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class Rook extends Piece {

    public Rook(PieceType pieceType, ColorCase color, Position position, char representation) {
        super(pieceType, color, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new Rook(pieceType, colorCase, toPosition, representation);
    }

    public static Rook createWhite(Position position) {
        return new Rook(PieceType.ROOK, ColorCase.WHITE, position, 'r');
    }
    public static Rook createBlack(Position position) {
        return new Rook(PieceType.ROOK, ColorCase.BLACK, position, 'R');
    }
}
