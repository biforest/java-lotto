package domain.exception;

public class NotValidLottoLengthException extends RuntimeException {
    private static final String MESSAGE = "번호는 6개를 입력해야 합니다.";

    public NotValidLottoLengthException() {
        super(MESSAGE);
    }
}