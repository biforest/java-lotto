package lotto.domain.exception;

public class NotDuplicatedNumberException extends RuntimeException{
    private static final String MESSAGE = "중복되는 로또 숫자를 입력하실 수 없습니다.";

    public NotDuplicatedNumberException() {
        super(MESSAGE);
    }
}
