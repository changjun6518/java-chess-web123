package demo.javachess.domain.moveStrategy;

import demo.javachess.domain.Board;
import demo.javachess.domain.Direction;
import demo.javachess.domain.Exception.InvalidPositionException;
import demo.javachess.domain.Position;
import demo.javachess.domain.Square;

import java.util.ArrayList;
import java.util.List;

public class PawnMoveStrategy implements MoveStrategy {

    private final List<Direction> directions;

    public PawnMoveStrategy(List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public List<Position> findPossiblePaths(Board board, Position position) {
        Square square = board.findSquareBy(position);

        if (square.isWhite()) {
            if (square.isFirstTurn()) {
                findPathWith(Direction.firstWhitePawnDirections(), square, board, position);
            }
            return findPathWith(directions, square, board, position);
        }

        if (square.isFirstTurn()) {
            return findPathWith(Direction.firstBlackPawnDirections(), square, board, position);
        }
        return findPathWith(directions, square, board, position);
    }

    private List<Position> findPathWith(List<Direction> directions, Square square, Board board, Position position) {
        List<Position> paths = new ArrayList<>();

        directions.forEach(direction -> {
            try {
                Position nextPosition = position.updateWith(direction);
                Square nextSquare = board.findSquareBy(nextPosition);

                if (direction.isStraight() && nextSquare.isBlank()) {
                    paths.add(nextPosition);
                }

                if (direction.isDiagonal() && square.isOtherTeam(nextSquare)) {
                    paths.add(nextPosition);
                }
            } catch (InvalidPositionException ignored) {
            }
        });
        return paths;
    }
}
