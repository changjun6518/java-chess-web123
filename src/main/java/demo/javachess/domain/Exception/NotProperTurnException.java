package demo.javachess.domain.Exception;

public class NotProperTurnException extends RuntimeException {
    public NotProperTurnException() {
        super("해당 색의 턴이 아닙니다!");
    }
}
