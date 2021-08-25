package demo.javachess.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardFactory {

    public static Board createBoard() {
        final List<Square> squares = new ArrayList<>();
        squares.addAll(insertWhiteSquare());
        squares.addAll(insertBlankSquare());
        squares.addAll(insertBlackSquare());
        return new Board(squares);
    }

    private static List<Square> insertWhiteSquare() {
        return new ArrayList<>(
                Arrays.asList(
                        Square.of(Position.from("a1"), State.WHITE, Piece.ROOK),
                        Square.of(Position.from("b1"), State.WHITE, Piece.KNIGHT),
                        Square.of(Position.from("c1"), State.WHITE, Piece.BISHOP),
                        Square.of(Position.from("d1"), State.WHITE, Piece.QUEEN),
                        Square.of(Position.from("e1"), State.WHITE, Piece.KING),
                        Square.of(Position.from("f1"), State.WHITE, Piece.BISHOP),
                        Square.of(Position.from("g1"), State.WHITE, Piece.KNIGHT),
                        Square.of(Position.from("h1"), State.WHITE, Piece.ROOK),

                        Square.of(Position.from("a2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("b2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("c2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("d2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("e2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("f2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("g2"), State.WHITE, Piece.PAWN),
                        Square.of(Position.from("h2"), State.WHITE, Piece.PAWN)
                )
        );
    }

    private static List<Square> insertBlankSquare() {
        return new ArrayList<>(
                Arrays.asList(
                        Square.of(Position.from("a3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("b3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("c3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("d3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("e3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("f3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("g3"), State.NONE, Piece.NONE),
                        Square.of(Position.from("h3"), State.NONE, Piece.NONE),

                        Square.of(Position.from("a4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("b4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("c4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("d4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("e4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("f4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("g4"), State.NONE, Piece.NONE),
                        Square.of(Position.from("h4"), State.NONE, Piece.NONE),

                        Square.of(Position.from("a5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("b5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("c5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("d5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("e5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("f5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("g5"), State.NONE, Piece.NONE),
                        Square.of(Position.from("h5"), State.NONE, Piece.NONE),

                        Square.of(Position.from("a6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("b6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("c6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("d6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("e6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("f6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("g6"), State.NONE, Piece.NONE),
                        Square.of(Position.from("h6"), State.NONE, Piece.NONE)
                )
        );
    }

    private static List<Square> insertBlackSquare() {
        return new ArrayList<>(
                Arrays.asList(
                        Square.of(Position.from("a8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("b8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("c8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("d8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("e8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("f8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("g8"), State.BLACK, Piece.PAWN),
                        Square.of(Position.from("h8"), State.BLACK, Piece.PAWN),

                        Square.of(Position.from("a7"), State.BLACK, Piece.ROOK),
                        Square.of(Position.from("b7"), State.BLACK, Piece.KNIGHT),
                        Square.of(Position.from("c7"), State.BLACK, Piece.BISHOP),
                        Square.of(Position.from("d7"), State.BLACK, Piece.QUEEN),
                        Square.of(Position.from("e7"), State.BLACK, Piece.KING),
                        Square.of(Position.from("f7"), State.BLACK, Piece.BISHOP),
                        Square.of(Position.from("g7"), State.BLACK, Piece.KNIGHT),
                        Square.of(Position.from("h7"), State.BLACK, Piece.ROOK)
                )
        );
    }

}
