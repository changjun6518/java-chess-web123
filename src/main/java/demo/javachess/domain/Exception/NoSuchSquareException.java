package demo.javachess.domain.Exception;

public class NoSuchSquareException extends RuntimeException {
    public NoSuchSquareException() {
        super("보드에 해당 정보가 없습니다!");
    }
}
