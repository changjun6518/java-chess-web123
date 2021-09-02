package demo.javachess.Service;

import demo.javachess.Service.Dto.BoardRes;
import demo.javachess.Service.Dto.StateRes;
import demo.javachess.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    //    @Autowired
//    BoardRepository boardRepository;
    private BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardRes createBoard() {
        Board board = BoardFactory.createBoard();
        boardRepository.save(board);
        return BoardRes.from(board);
    }

    @Transactional
    public StateRes movePiece(final Long boardId, final String from, final String to) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(NotExistBoardException::new);
        State state = board.move(from, to);
        board.updateTurn(state.getNextTurn());
        return StateRes.from(state);
    }

    public BoardRes findBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(NotExistBoardException::new);
        return BoardRes.from(board);
    }

    public List<BoardRes> findAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return BoardRes.fromList(boards);
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
