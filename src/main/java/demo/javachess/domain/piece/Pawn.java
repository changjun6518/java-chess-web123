package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;

public class Pawn extends Piece {
    public Pawn(PieceType pieceType, ColorCase colorCase, Position position, char representation) {
        super(pieceType, colorCase, position, representation);
    }

    @Override
    public Piece moveTo(Position toPosition) {
        return new Pawn(pieceType.notFirstStepPawn(), colorCase, toPosition, representation);
    }

    public static Pawn createWhite(Position position) {
        return new Pawn(PieceType.FIRST_WHITE_PAWN, ColorCase.WHITE, position, 'p');
    }
    public static Pawn createBlack(Position position) {
        return new Pawn(PieceType.FIRST_BLACK_PAWN, ColorCase.BLACK, position, 'P');
    }
}
