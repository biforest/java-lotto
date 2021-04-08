package lotto.domain;

import lotto.domain.lotto.*;
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

    public LastWeekWinningBonusBall inputLastWeekWinningBonusBall() {
        printer.requestLottoBonusBallNumber();
        int BonusBall = receiver.receiveLottoBonusBallNumber();
        return new LastWeekWinningBonusBall(BonusBall);
    }

    public void informLottoStatistics(
            NumberOfLottoTicket numberOfLottoTicket,
            LottoManualTickets lottoManualTickets,
            LottoAutomaticTickets lottoAutomaticTickets,
            LastWeekWinningLotto lastWeekWinningLotto,
            LastWeekWinningBonusBall lastWeekWinningBonusBall) {

        List<LottoMatchStatus> lottoAllTicketMatchStatuses = new ArrayList<>();
        List<LottoMatchStatus> lottoManualTicketMatchStatuses = lottoMachine.lottoManualTicketsDiscriminator(lottoManualTickets, lastWeekWinningLotto, lastWeekWinningBonusBall);
        List<LottoMatchStatus> lottoAutomaticTicketMatchStatuses = lottoMachine.lottoAutomaticTicketsDiscriminator(lottoAutomaticTickets, lastWeekWinningLotto, lastWeekWinningBonusBall);
        lottoAllTicketMatchStatuses.addAll(lottoManualTicketMatchStatuses);
        lottoAllTicketMatchStatuses.addAll(lottoAutomaticTicketMatchStatuses);
        List<WinningStatus> lottoStatistics = lottoMachine.getStatistics(lottoAllTicketMatchStatuses);
        printer.printAllMatchedLottoResults(lottoMachine.getMappingLottoWithBonusBall());
        Profit profit = lottoMachine.getProfitInformation(lottoStatistics, numberOfLottoTicket);
        printer.printLottoProfit(profit.getProfit());
        printer.printIsLottoProfit(profit.isProfit());
    }
}
