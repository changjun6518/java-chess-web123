package demo.javachess.domain.piece;
import demo.javachess.domain.board.Board;
import demo.javachess.domain.strategy.*;
import demo.javachess.domain.util.Direction;
import demo.javachess.domain.util.Directions;
import demo.javachess.domain.util.Position;

import java.util.Collection;
import java.util.List;

public enum PieceType {
    FIRST_BLACK_PAWN(new PawnMoveStrategy(), Directions.FIRST_BLACK_PAWN_DIRECTION, 1),
    FIRST_WHITE_PAWN(new PawnMoveStrategy(), Directions.FIRST_WHITE_PAWN_DIRECTION, 1),
    WHITE_PAWN(new PawnMoveStrategy(), Directions.WHITE_PAWN_DIRECTION, 1),
    BLACK_PAWN(new PawnMoveStrategy(), Directions.BLACK_PAWN_DIRECTION, 1),


    KNIGHT(new SingleMoveStrategy(), Directions.KNIGHT_DIRECTION, 2.5),
    KING(new SingleMoveStrategy(), Directions.KING_DIRECTION, 0),

    ROOK(new MultipleMoveStrategy(), Directions.ROOK_DIRECTION, 5),
    BISHOP(new MultipleMoveStrategy(), Directions.BISHOP_DIRECTION, 3),
    QUEEN(new MultipleMoveStrategy(), Directions.QUEEN_DIRECTION, 9),

    BLANK(new BlankStrategy(), Directions.BLANK_DIRECTION, 0);
    ;


    private MoveStrategy moveStrategy;
    private Directions directions;
    private double point;

    PieceType(MoveStrategy moveStrategy, Directions directions, double point) {
        this.moveStrategy = moveStrategy;
        this.directions = directions;
        this.point = point;
    }

    public List<Position> possiblePositions(Board board, Piece piece) {
        return moveStrategy.possiblePositions(board, piece);
    }

    public PieceType notFirstStepPawn() {
        if (this == FIRST_WHITE_PAWN) {
            return WHITE_PAWN;
        }
        return BLACK_PAWN;
    }

    public List<Direction> directions() {
        return directions.directions();
    }

    public double getPoint() {
        return point;
    }
}
