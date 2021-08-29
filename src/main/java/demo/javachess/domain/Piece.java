package demo.javachess.domain;

import demo.javachess.domain.moveStrategy.MoveStrategy;
import demo.javachess.domain.moveStrategy.MultiMoveStrategy;
import demo.javachess.domain.moveStrategy.PawnMoveStrategy;
import demo.javachess.domain.moveStrategy.SingleMoveStrategy;

import java.util.List;

public enum Piece {
    KING(0, new SingleMoveStrategy(Direction.getKingDirections())),
    QUEEN(9, new MultiMoveStrategy(Direction.getQueenDirections())),
    ROOK(5, new MultiMoveStrategy(Direction.getRookDirections())),
    BISHOP(3, new MultiMoveStrategy(Direction.getBishopDirections())),
    KNIGHT(2.5, new SingleMoveStrategy(Direction.getKnightDirections())),
    PAWN(1, new PawnMoveStrategy(Direction.getPawnDirections())),
    NONE(-1, null);

    private double score;
    private MoveStrategy moveStrategy;

    Piece(final double score, final MoveStrategy moveStrategy) {
        this.score = score;
        this.moveStrategy = moveStrategy;
    }

    public List<Position> findPossiblePaths(Board board, Position position) {
        return moveStrategy.findPossiblePaths(board, position);
    }
}
