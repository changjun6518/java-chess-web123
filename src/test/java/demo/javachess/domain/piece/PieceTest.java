package demo.javachess.domain.piece;

import demo.javachess.domain.util.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @DisplayName("체스 말 표식")
    @ParameterizedTest
    @MethodSource("getCasesForPieceRepresentation")
    void representationTest(Piece piece, String expectedRepresentation) {
        assertThat(piece.toString()).isEqualTo(expectedRepresentation);
    }

    private static Stream<Arguments> getCasesForPieceInitialPosition() {
        return Stream.of(
                Arguments.of(Pawn.createWhite(new Position(1, 2)), new Position(1, 2)),
                Arguments.of(Pawn.createBlack(new Position(1, 7)), new Position(1, 7)),
                Arguments.of(Rook.createWhite(new Position(1, 1)), new Position(1, 1)),
                Arguments.of(Rook.createBlack(new Position(1, 8)), new Position(1, 8)),
                Arguments.of(Knight.createWhite(new Position(2, 1)), new Position(2, 1)),
                Arguments.of(Knight.createBlack(new Position(2, 8)), new Position(2, 8)),
                Arguments.of(Bishop.createWhite(new Position(3, 1)), new Position(3, 1)),
                Arguments.of(Bishop.createBlack(new Position(3, 8)), new Position(3, 8)),
                Arguments.of(Queen.createWhite(new Position(4, 1)), new Position(4, 1)),
                Arguments.of(Queen.createBlack(new Position(4, 8)), new Position(4, 8)),
                Arguments.of(King.createWhite(new Position(5, 1)), new Position(5, 1)),
                Arguments.of(King.createBlack(new Position(5, 8)), new Position(5, 8)));
    }
}