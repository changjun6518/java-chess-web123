package demo.javachess.domain.moveStrategy;

import demo.javachess.domain.Board;
import demo.javachess.domain.Direction;
import demo.javachess.domain.Exception.InvalidPositionException;
import demo.javachess.domain.Position;
import demo.javachess.domain.Square;

import java.util.ArrayList;
import java.util.List;

public class MultiMoveStrategy implements MoveStrategy {
    List<Direction> directions;

    public MultiMoveStrategy(List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public List<Position> findPossiblePaths(Board board, Position position) {
        List<Position> paths = new ArrayList<>();
        directions.forEach(direction -> {
            try {
                Square square = board.findSquareBy(position);
                Position currentPosition = position;

                while (true) {
                    Position nextPosition = currentPosition.updateWith(direction);
                    Square nextSquare = board.findSquareBy(nextPosition);

                    if (nextSquare.isSameTeam(square)) {
                        break;
                    }
                    paths.add(nextPosition);
                    currentPosition = nextPosition;
                }


            } catch (InvalidPositionException e) {
            }
        });
        return paths;
    }
}
