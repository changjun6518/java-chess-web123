package demo.javachess.domain.strategy;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.piece.Piece;
import demo.javachess.domain.util.Position;

import java.util.List;

public class BlankStrategy implements MoveStrategy {

    @Override
    public List<Position> possiblePositions(Board board, Piece piece) {
        throw new IllegalArgumentException("빈칸은 움직일 수 없습니다!");
    }
}
