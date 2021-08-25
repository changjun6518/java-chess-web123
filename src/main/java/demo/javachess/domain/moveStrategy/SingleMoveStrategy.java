package demo.javachess.domain.moveStrategy;

import demo.javachess.domain.Board;
import demo.javachess.domain.Direction;
import demo.javachess.domain.Piece;
import demo.javachess.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class SingleMoveStrategy implements MoveStrategy {
    private List<Direction> directions;

    public SingleMoveStrategy(List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public List<Position> possiblePositions(Board board, Piece piece) {
        List<Position> asd = new ArrayList<>();
        return asd;
    }
}
