package lotto.domain;

import lotto.domain.validation.PurchaseAmountValidation;

public class LottoTicketOfNumber {
    private final int lottoTicketOfNumber;
    private final static int LottoTicketPrice = 1000;

    public LottoTicketOfNumber(int purchaseAmount) {
        this.lottoTicketOfNumber = calculateLottoTicketOfNumber(purchaseAmount);
    }

    private int calculateLottoTicketOfNumber(int purchaseAmount) {
        return purchaseAmount / LottoTicketPrice;
    }

    public int getLottoTicketOfNumber() {
        return lottoTicketOfNumber;
    }

}
