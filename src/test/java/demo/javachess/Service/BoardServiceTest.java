package demo.javachess.Service;

import demo.javachess.Service.Dto.BoardRes;
import demo.javachess.domain.Board;
import demo.javachess.domain.BoardFactory;
import demo.javachess.domain.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class BoardServiceTest {

    private BoardService boardService;

    @Mock
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        boardService = new BoardService(boardRepository);
    }

    @DisplayName("보드 생성")
    @Test
    void createBoard() {
        Board board = BoardFactory.createBoard();
        given(boardRepository.save(any())).willReturn(board);

        boardService.createBoard();

        System.out.println(board.getTurn());

        verify(boardRepository).save(any());
    }
}