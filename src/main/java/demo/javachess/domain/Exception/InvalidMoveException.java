package demo.javachess.domain.Exception;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException() {
        super("해당 기물은 현재 움직일 수 없습니다!");
    }
}
