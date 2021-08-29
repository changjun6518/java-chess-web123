package demo.javachess.Service;

import demo.javachess.Service.Dto.BoardRes;
import demo.javachess.domain.Board;
import demo.javachess.domain.BoardFactory;
import demo.javachess.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void movePiece() {

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
}
