package demo.javachess.domain.Exception;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException() {
        super("보드의 범위를 벗어났습니다!");
    }
}
