package demo.javachess.controller;

import demo.javachess.Service.BoardService;
import demo.javachess.Service.Dto.BoardRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping
    public ResponseEntity<Void> create() {
        BoardRes boardRes = boardService.createBoard();
        return ResponseEntity.created(URI.create("/boards/" + boardRes.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardRes> get(@PathVariable("id") Long id) {
        final BoardRes boardResponse = boardService.findBoard(id);
        return ResponseEntity.ok().body(boardResponse);
    }

}
