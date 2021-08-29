package demo.javachess.domain.Exception;

public class InvalidBoardSizeException extends RuntimeException {
    public InvalidBoardSizeException() {
        super("보드 크기가 적합하지 않습니다!");
    }
}
