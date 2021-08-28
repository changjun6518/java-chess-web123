package demo.javachess.domain.Exception;

public class StartFromBlankException extends RuntimeException {
    public StartFromBlankException() {
        super("빈칸은 움직일 수 없습니다!");
    }

}
