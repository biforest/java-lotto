package lotto.domain;

import lotto.domain.lotto.LottoManualTicket;
import lotto.domain.lotto.LottoManualTickets;
import lotto.ui.Printer;
import lotto.ui.Receiver;

import java.util.ArrayList;

public class LottoStore {
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();

    public PurchaseAmount inputLottoPurchaseAmount() {
        printer.requestPurchaseAmount();
        int lottoPurchaseAmount = receiver.receiveLottoPurchaseAmount();

        return new PurchaseAmount(lottoPurchaseAmount);
    }

    public int inputLottoManualTicketNumber() {
        printer.requestLottoManualTicketNumber();
        return receiver.receiverLottoManualTicketNumber();
    }

    public LottoManualTickets inputLottoManualTickets(int lottoManualTicketNumber) {
        ArrayList<LottoManualTicket> lottoManualTicketDummy = new ArrayList<>();
        printer.requestLottoManualTicket();
        for (int lottoTicket = 0; lottoTicket < lottoManualTicketNumber; lottoTicket++) {
            LottoManualTicket lottoManualTicket = new LottoManualTicket(receiver.receiverLottoManualTicket());
            lottoManualTicketDummy.add(lottoManualTicket);
        }
        LottoManualTickets lottoManualTickets = new LottoManualTickets(lottoManualTicketDummy);
        return lottoManualTickets;
    }
}
