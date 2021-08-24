package demo.javachess.exception;

public class InvalidPositionException extends IllegalArgumentException {
    public InvalidPositionException(String position) {
        super(String.format("좌표를 올바르게 입력해 주세요! 입력 : %s", position));
    }

    public InvalidPositionException(char col, char raw) {
        super(String.format("좌표를 올바르게 입력해 주세요! 입력 : %c%c", col, raw));
    }}
