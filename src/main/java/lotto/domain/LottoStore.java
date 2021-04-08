package lotto.domain;

import lotto.domain.lotto.LastWeekWinningLotto;
import lotto.domain.lotto.LottoAutomaticTickets;
import lotto.domain.lotto.LottoManualTicket;
import lotto.domain.lotto.LottoManualTickets;
import lotto.ui.Printer;
import lotto.ui.Receiver;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final LottoMachine lottoMachine = new LottoMachine();

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
        return new LottoManualTickets(lottoManualTicketDummy);
    }

    public LottoAutomaticTickets informLottoAutomaticTickets(LottoManualTickets lottoManualTickets, NumberOfLottoTicket numberOfLottoTicket) {
        printer.printLottoManualTickets(lottoManualTickets);
        LottoAutomaticTickets lottoAutomaticTickets = lottoMachine.generateLottoAutomaticTicket(numberOfLottoTicket);
        printer.printLottoAutomaticTickets(lottoAutomaticTickets);
        return lottoAutomaticTickets;
    }

    public NumberOfLottoTicket informNumberOfLottoTicket(PurchaseAmount purchaseAmount, int lottoManualTicketNumber) {
        NumberOfLottoTicket numberOfLottoTicket = new NumberOfLottoTicket(purchaseAmount, lottoManualTicketNumber);
        printer.printNumberOfEachLottoTicket(numberOfLottoTicket);
        return numberOfLottoTicket;
    }

    public LastWeekWinningLotto inputLastWeekWinningLotto() {
        printer.requestLastWeekLottoWinningNumber();
        List<Integer> LastWeekLottoWinningNumbers = receiver.receiveLastWeekLottoWinningNumbers();
        return new LastWeekWinningLotto(LastWeekLottoWinningNumbers);
    }
}
