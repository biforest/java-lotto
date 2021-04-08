package lotto.validation;

import lotto.exception.NotValidLottoTicketOfNumberException;


public class LottoTicketOfNumberValidation {
    private final static int LOTTO_TICKET_OF_NUMBER_MINIMUM_THRESHOLD = 1;

    public void checkLottoTicketOfNumber(int lottoTicketOfNumber) {
        if (lottoTicketOfNumber < LOTTO_TICKET_OF_NUMBER_MINIMUM_THRESHOLD)
            throw new NotValidLottoTicketOfNumberException();
    }
}
