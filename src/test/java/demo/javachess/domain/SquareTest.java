package demo.javachess.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class SquareTest {
    @DisplayName("Square insert 체크")
    @ParameterizedTest
    @MethodSource("getCasesForPiece")
    void insertTest(Square square, Piece piece) {
        assertThat(square.getPiece().equals(piece));
    }

    private static Stream<Arguments> getCasesForPiece() {
        return Stream.of(
                Arguments.of(new Square(new Position('a', 1), State.WHITE, Piece.ROOK),Piece.ROOK)
        );
    }

}