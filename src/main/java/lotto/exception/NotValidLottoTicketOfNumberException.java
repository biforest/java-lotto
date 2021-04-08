package lotto.exception;

public class NotValidLottoTicketOfNumberException extends RuntimeException{
    private static final String MESSAGE = "로또를 살 금액이 부족합니다.";

    public NotValidLottoTicketOfNumberException(){
        super(MESSAGE);
    }
}
