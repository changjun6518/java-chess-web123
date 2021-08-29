package demo.javachess.Service;

public class NotExistBoardException extends RuntimeException {
    public NotExistBoardException() {
        super("보드 정보가 존재하지 않습니다!");
    }
}
