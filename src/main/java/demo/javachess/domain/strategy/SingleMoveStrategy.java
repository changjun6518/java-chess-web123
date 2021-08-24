package demo.javachess.domain.strategy;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.piece.Piece;
import demo.javachess.domain.util.Direction;
import demo.javachess.domain.util.Position;

import java.util.ArrayList;
import java.util.List;

public class SingleMoveStrategy implements MoveStrategy {

    @Override
    public List<Position> possiblePositions(Board board, Piece piece) {
        List<Position> possiblePositions = new ArrayList<>();

        for (Direction direction : piece.directions()) {
            if (piece.isNextPositionValid(direction)) {
                Position nextPosition = piece.getPosition().moveBy(direction);
                Piece nextPiece = board.findPieceByPosition(nextPosition);

                if (nextPiece.isBlank()) {
                    possiblePositions.add(nextPosition);
                }

                else if (nextPiece.isOtherPiece(piece)) {
                    possiblePositions.add(nextPosition);
                }
            }
        }

        return possiblePositions;
    }
}
