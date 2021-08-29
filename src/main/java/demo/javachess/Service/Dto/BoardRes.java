package demo.javachess.Service.Dto;

import demo.javachess.domain.Board;

import java.util.HashMap;
import java.util.Map;

public class BoardRes {
    private Long id;
    private Map<String, String> squares;
    private String turn;

    public BoardRes(Long id, Map<String, String> squares, String turn) {
        this.id = id;
        this.squares = squares;
        this.turn = turn;
    }

    public static BoardRes from(Board board) {
        HashMap<String, String> squares = new HashMap<>();
        board.getSquares().forEach(square -> {
            squares.put(square.getPositionValue(), square.getPieceTeam());
        });
        return new BoardRes(board.getId(), squares, board.getTurn());
    }

    public Long getId() {
        return id;
    }
}
