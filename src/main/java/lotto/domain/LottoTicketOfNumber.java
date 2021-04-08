package lotto.domain;

import lotto.domain.validation.LottoTicketOfNumberValidation;

public class LottoTicketOfNumber {
    private final static int LOTTO_TICKET_PRICE = 1000;

    private final int lottoTicketOfTotalNumber;
    private final int manualLottoTicketOfNumber;
    private final int automaticLottoTicketOfNumber;

    public LottoTicketOfNumber(int purchaseAmount, int purchaseManualLottoOfNumber) {
        LottoTicketOfNumberValidation lottoTicketOfNumberValidation = new LottoTicketOfNumberValidation();
        this.lottoTicketOfTotalNumber = calculateLottoTicketOfNumber(purchaseAmount);
        this.manualLottoTicketOfNumber = purchaseManualLottoOfNumber;
        this.automaticLottoTicketOfNumber = calculateAutomaticLottoTicketOfNumber(lottoTicketOfTotalNumber, manualLottoTicketOfNumber);
        lottoTicketOfNumberValidation.checkLottoTicketOfNumber(this.lottoTicketOfTotalNumber);
    }

    private int calculateLottoTicketOfNumber(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    private int calculateAutomaticLottoTicketOfNumber(int lottoTicketOfTotalNumber, int manualLottoTicketOfNumber) {
        return lottoTicketOfTotalNumber - manualLottoTicketOfNumber;
    }

    public int getManualLottoTicketOfNumber(){
        return manualLottoTicketOfNumber;
    }

    public int getAutomaticLottoTicketOfNumber() {
        return automaticLottoTicketOfNumber;
    }

    public int getLottoTicketOfNumber() {
        return lottoTicketOfTotalNumber;
    }

}
