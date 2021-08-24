package demo.javachess.domain.calculator;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.piece.ColorCase;
import demo.javachess.domain.piece.Piece;
import demo.javachess.domain.util.Position;

public class Calculator {
    private static final int PAWN_CRITICAL_COUNT = 2;
    private static final int DIVIDEND_WHEN_MULTIPLE_PAWN_IN_COLUMN = 2;

    public double calculatePoint(Board board, ColorCase color) {
        double totalPoint = 0;

        for (int col = Position.START_INDEX; col <= Position.END_INDEX; col++) {
            int pawnCount = 0;
            double pawnScore = 0;

            for (int row = Position.START_INDEX; row <= Position.END_INDEX; row++) {
                Piece piece = board.findPieceByPosition(board.getBoardIndex(col, row));

                if (piece.isSameColor(color) && piece.isPawn()) {
                    pawnCount++;
                    pawnScore += piece.getPoint();
                }
                if (piece.isSameColor(color) && !piece.isPawn()) {
                    totalPoint += piece.getPoint();
                }
            }

            if (pawnCount >= PAWN_CRITICAL_COUNT) {
                totalPoint += pawnCount / DIVIDEND_WHEN_MULTIPLE_PAWN_IN_COLUMN;
                continue;
            }
            totalPoint += pawnScore;
        }
        return totalPoint;
    }
}
