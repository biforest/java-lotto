package lotto.domain;

import lotto.domain.validation.LottoTicketOfNumberValidation;

public class NumberOfLottoTicket {
    private final static int LOTTO_TICKET_PRICE = 1000;

    private final int totalNumberOfLottoTicket;
    private final int numberOfManualLottoTicket;
    private final int automaticLottoTicketOfNumber;

    public NumberOfLottoTicket(int purchaseAmount, int purchaseManualLottoOfNumber) {
        LottoTicketOfNumberValidation lottoTicketOfNumberValidation = new LottoTicketOfNumberValidation();
        this.totalNumberOfLottoTicket = calculateLottoTicketOfNumber(purchaseAmount);
        this.numberOfManualLottoTicket = purchaseManualLottoOfNumber;
        this.automaticLottoTicketOfNumber = calculateAutomaticLottoTicketOfNumber(totalNumberOfLottoTicket, numberOfManualLottoTicket);
        lottoTicketOfNumberValidation.checkLottoTicketOfNumber(this.totalNumberOfLottoTicket);
    }

    private int calculateLottoTicketOfNumber(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    private int calculateAutomaticLottoTicketOfNumber(int lottoTicketOfTotalNumber, int manualLottoTicketOfNumber) {
        return lottoTicketOfTotalNumber - manualLottoTicketOfNumber;
    }

    public int getNumberOfManualLottoTicket(){
        return numberOfManualLottoTicket;
    }

    public int getAutomaticLottoTicketOfNumber() {
        return automaticLottoTicketOfNumber;
    }

    public int getTotalNumberOfLottoTicket() {
        return totalNumberOfLottoTicket;
    }

}
