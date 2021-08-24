package demo.javachess.domain.strategy;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.piece.Piece;
import demo.javachess.domain.util.Position;

import java.util.List;

public interface MoveStrategy {
    List<Position> possiblePositions(Board board, Piece piece);
}
