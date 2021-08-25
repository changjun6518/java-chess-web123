package demo.javachess.domain.piece;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.util.Direction;
import demo.javachess.domain.util.Position;

import java.util.List;

public abstract class Piece {
    protected PieceType pieceType;
    protected ColorCase colorCase;
    protected Position position;
    protected char representation;

    public Piece(PieceType piecetype, ColorCase colorCase, Position position, char representation) {
        this.pieceType = piecetype;
        this.colorCase = colorCase;
        this.position = position;
        this.representation = representation;
    }

    public abstract Piece moveTo(Position position);

    public boolean isKing() {
        return pieceType.equals(PieceType.KING);
    }

    public Position getPosition() {
        return position;
    }
    public boolean isPawn() {
        return pieceType.equals(PieceType.BLACK_PAWN) || pieceType.equals(PieceType.WHITE_PAWN) ||
                pieceType.equals(PieceType.FIRST_BLACK_PAWN) || pieceType.equals(PieceType.FIRST_WHITE_PAWN);
    }

    public boolean isBlank() {
        return colorCase.equals(ColorCase.BLANK);
    }

    public boolean isSameColor(Piece piece){
        return colorCase.isSame(piece.colorCase);
    }

    public boolean isSameColor(ColorCase color){
        return this.colorCase == color;
    }

    public boolean isMovable(final Board board, final Piece targetPiece) {
        if (pieceType.possiblePositions(board, this).contains(targetPiece.getPosition())) {
            return true;
        }
        throw new IllegalArgumentException("해당 포지션으로 이동할 수 없습니다!");
    }

    public List<Direction> directions() {
        return pieceType.directions();
    }

    public boolean isNextPositionValid(Direction direction){
        return Position.isInBoardRange(position.getCol() + direction.getCol(),
                position.getRow() + direction.getRow());
    }

    public boolean isOtherPiece(Piece piece) {
        return colorCase.isNotSame(piece.colorCase);
    }


    public double getPoint() {
        return pieceType.getPoint();
    }

    public char getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return String.valueOf(representation);
    }
}
