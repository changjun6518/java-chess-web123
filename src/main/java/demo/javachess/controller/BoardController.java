package demo.javachess.controller;

import demo.javachess.Service.BoardService;
import demo.javachess.Service.Dto.BoardRes;
import demo.javachess.Service.Dto.MoveReq;
import demo.javachess.Service.Dto.StateRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<Void> create() {
        BoardRes boardRes = boardService.createBoard();
        return ResponseEntity.created(URI.create("/boards/" + boardRes.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<BoardRes>> getAll() {
        final List<BoardRes> boardResponses = boardService.findAllBoards();
        return ResponseEntity.ok().body(boardResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardRes> get(@PathVariable("id") Long id) {
        final BoardRes boardResponse = boardService.findBoard(id);
        return ResponseEntity.ok().body(boardResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/move")
    public ResponseEntity<StateRes> move(
            @PathVariable("id") Long id,
            @Validated MoveReq request) {
        StateRes stateRes = boardService.movePiece(id, request.getFrom(), request.getTo());
        return ResponseEntity.ok().body(stateRes);
    }

}
