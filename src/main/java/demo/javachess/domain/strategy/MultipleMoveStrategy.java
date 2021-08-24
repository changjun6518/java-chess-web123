package demo.javachess.domain.strategy;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.piece.Piece;
import demo.javachess.domain.util.Direction;
import demo.javachess.domain.util.Position;

import java.util.ArrayList;
import java.util.List;

public class MultipleMoveStrategy implements MoveStrategy{
    @Override
    public List<Position> possiblePositions(Board board, Piece piece) {
        List<Position> possiblePositions = new ArrayList<>();

        for (Direction direction : piece.directions()) {
            Piece nextPiece = piece;
            while (nextPiece.isNextPositionValid(direction)) {
                Position nextPosition = nextPiece.getPosition().moveBy(direction);
                nextPiece = board.findPieceByPosition(nextPosition);

                if (nextPiece.isBlank()) {
                    possiblePositions.add(nextPosition);
                    nextPiece = board.findPieceByPosition(nextPosition);
                }

                else if (nextPiece.isOtherPiece(piece)) {
                    possiblePositions.add(nextPosition);
                    break;
                }

                else if (nextPiece.isSameColor(piece)) {
                    break;
                }
            }
        }
        return possiblePositions;
    }
}
