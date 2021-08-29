package demo.javachess.domain.moveStrategy;

import demo.javachess.domain.*;
import demo.javachess.domain.Exception.InvalidPositionException;

import java.util.ArrayList;
import java.util.List;

public class SingleMoveStrategy implements MoveStrategy {
    private List<Direction> directions;

    public SingleMoveStrategy(List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public List<Position> findPossiblePaths(Board board, Position position) {
        List<Position> paths = new ArrayList<>();

        directions.forEach(direction -> {
            try {
                Square square = board.findSquareBy(position);
                Position nextPosition = position.updateWith(direction);
                Square nextSquare = board.findSquareBy(nextPosition);

                if (nextSquare.isSameTeam(square)) {
                    return;
                }

                paths.add(nextPosition);
            } catch (InvalidPositionException e) {
            }
        });
        return paths;
    }
}
