package demo.javachess.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
                        Square.of(Position.from("a1"), Team.WHITE, Piece.ROOK),
                        Square.of(Position.from("b1"), Team.WHITE, Piece.KNIGHT),
                        Square.of(Position.from("c1"), Team.WHITE, Piece.BISHOP),
                        Square.of(Position.from("d1"), Team.WHITE, Piece.QUEEN),
                        Square.of(Position.from("e1"), Team.WHITE, Piece.KING),
                        Square.of(Position.from("f1"), Team.WHITE, Piece.BISHOP),
                        Square.of(Position.from("g1"), Team.WHITE, Piece.KNIGHT),
                        Square.of(Position.from("h1"), Team.WHITE, Piece.ROOK),

                        Square.of(Position.from("a2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("b2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("c2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("d2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("e2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("f2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("g2"), Team.WHITE, Piece.PAWN),
                        Square.of(Position.from("h2"), Team.WHITE, Piece.PAWN)
                )
        );
    }

    private static List<Square> insertBlankSquare() {
        return new ArrayList<>(
                Arrays.asList(
                        Square.of(Position.from("a3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("b3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("c3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("d3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("e3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("f3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("g3"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("h3"), Team.NONE, Piece.NONE),

                        Square.of(Position.from("a4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("b4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("c4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("d4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("e4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("f4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("g4"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("h4"), Team.NONE, Piece.NONE),

                        Square.of(Position.from("a5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("b5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("c5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("d5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("e5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("f5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("g5"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("h5"), Team.NONE, Piece.NONE),

                        Square.of(Position.from("a6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("b6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("c6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("d6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("e6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("f6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("g6"), Team.NONE, Piece.NONE),
                        Square.of(Position.from("h6"), Team.NONE, Piece.NONE)
                )
        );
    }

    private static List<Square> insertBlackSquare() {
        return new ArrayList<>(
                Arrays.asList(
                        Square.of(Position.from("a7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("b7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("c7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("d7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("e7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("f7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("g7"), Team.BLACK, Piece.PAWN),
                        Square.of(Position.from("h7"), Team.BLACK, Piece.PAWN),

                        Square.of(Position.from("a8"), Team.BLACK, Piece.ROOK),
                        Square.of(Position.from("b8"), Team.BLACK, Piece.KNIGHT),
                        Square.of(Position.from("c8"), Team.BLACK, Piece.BISHOP),
                        Square.of(Position.from("d8"), Team.BLACK, Piece.QUEEN),
                        Square.of(Position.from("e8"), Team.BLACK, Piece.KING),
                        Square.of(Position.from("f8"), Team.BLACK, Piece.BISHOP),
                        Square.of(Position.from("g8"), Team.BLACK, Piece.KNIGHT),
                        Square.of(Position.from("h8"), Team.BLACK, Piece.ROOK)
                )
        );
    }

    public static Board createEmpty() {
        final List<Square> squares = new ArrayList<>();
        IntStream.rangeClosed(1, 8)
                .forEach(i -> IntStream.rangeClosed(1, 8)
                        .forEach(j -> squares.add(Square.of(Position.of(i, j), Team.NONE, Piece.NONE)))
                );
        return new Board(squares);
    }
}
