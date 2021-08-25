package demo.javachess.domain.moveStrategy;

import demo.javachess.domain.Board;
import demo.javachess.domain.Piece;
import demo.javachess.domain.Position;

import java.util.List;

public interface MoveStrategy {
    public List<Position> possiblePositions(Board board, Piece piece);
}
