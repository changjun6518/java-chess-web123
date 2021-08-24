package demo.javachess.domain.board;

import demo.javachess.domain.piece.*;
import demo.javachess.domain.util.Position;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {
    private static final List<Piece> INITIALIZED_BOARD = new ArrayList<>();
    private static final int BLANK_START_ROW = 3;
    private static final int BLANK_END_ROW = 6;

    //    public static void init() {
//        setupWhitePiece();
//        setupBlankPiece();
//        setupBlackPiece();
//    }
    static {
        setupWhitePiece();
        setupBlankPiece();
        setupBlackPiece();
    }


    private static void setupWhitePiece() {
        INITIALIZED_BOARD.add(Rook.createWhite(new Position(1, 1)));
        INITIALIZED_BOARD.add(Knight.createWhite(new Position(2, 1)));
        INITIALIZED_BOARD.add(Bishop.createWhite(new Position(3, 1)));
        INITIALIZED_BOARD.add(Queen.createWhite(new Position(4, 1)));
        INITIALIZED_BOARD.add(King.createWhite(new Position(5, 1)));
        INITIALIZED_BOARD.add(Bishop.createWhite(new Position(6, 1)));
        INITIALIZED_BOARD.add(Knight.createWhite(new Position(7, 1)));
        INITIALIZED_BOARD.add(Rook.createWhite(new Position(8, 1)));

        for (int i = 1; i <= 8; i++) {
            INITIALIZED_BOARD.add(Pawn.createWhite(new Position(i, 2)));
        }
    }

    private static void setupBlankPiece() {
        for (int row = BLANK_START_ROW; row <= BLANK_END_ROW; row++) {
            for (int col = 1; col <= 8; col++) {
                INITIALIZED_BOARD.add(Blank.createBlank(new Position(col, row)));
            }
        }
    }

    private static void setupBlackPiece() {
        for (int i = 1; i <= 8; i++) {
            INITIALIZED_BOARD.add(Pawn.createBlack(new Position(i, 7)));
        }

        INITIALIZED_BOARD.add(Rook.createBlack(new Position(1, 8)));
        INITIALIZED_BOARD.add(Knight.createBlack(new Position(2, 8)));
        INITIALIZED_BOARD.add(Bishop.createBlack(new Position(3, 8)));
        INITIALIZED_BOARD.add(Queen.createBlack(new Position(4, 8)));
        INITIALIZED_BOARD.add(King.createBlack(new Position(5, 8)));
        INITIALIZED_BOARD.add(Bishop.createBlack(new Position(6, 8)));
        INITIALIZED_BOARD.add(Knight.createBlack(new Position(7, 8)));
        INITIALIZED_BOARD.add(Rook.createBlack(new Position(8, 8)));
    }

    public static Board createBoard() {
        return new Board(new ArrayList<>(INITIALIZED_BOARD));
    }
}
