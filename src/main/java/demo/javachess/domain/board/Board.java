package demo.javachess.domain.board;

import demo.javachess.domain.piece.Blank;
import demo.javachess.domain.piece.ColorCase;
import demo.javachess.domain.piece.Piece;
import demo.javachess.domain.util.Position;

import java.util.List;

public class Board {
    private final List<Piece> board;
    private boolean isFinished = false;

    public Board(List<Piece> board) {
        this.board = board;
    }

    // move b2 b4
    public void move(String source, String target, ColorCase currentTurn) {
        Piece sourcePiece = findPieceByPosition(Position.of(source));
        Piece targetPiece = findPieceByPosition(Position.of(target));

        if (sourcePiece.isBlank()) {
            throw new IllegalArgumentException("빈 칸은 이동할 수 없습니다!");
        }
        if (!sourcePiece.isSameColor(currentTurn)) {
            throw new IllegalArgumentException("순서가 아닙니다!");
        }

        if (sourcePiece.isMovable(this, targetPiece)) {
            board.set(boardIndexOf(targetPiece.getPosition()), sourcePiece.moveTo(targetPiece.getPosition()));
            board.set(boardIndexOf(sourcePiece.getPosition()), Blank.createBlank(sourcePiece.getPosition()));
        }
        changeFlagWhenKingCaptured(targetPiece);
    }

    public void changeFlagWhenKingCaptured(Piece targetPiece) {
        if (targetPiece.isKing()) {
            isFinished = true;
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Piece findPieceByPosition(Position position) {
        return board.get(getBoardIndex(position.getCol(), position.getRow()));
    }
    public Piece findPieceByPosition(int index) {
        return board.get(index);
    }

    public int getBoardIndex(int col, int row) {
        return (row - 1) * 8 + col - 1;
    }

    public int boardIndexOf(Position position) {
        return getBoardIndex(position.getCol(), position.getRow());
    }

    public List<Piece> getBoard() {
        return board;
    }
}
