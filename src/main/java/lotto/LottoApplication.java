  package lotto;

import lotto.domain.Statistics;
import lotto.domain.factory.Issuer;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.result.GameResults;
import lotto.ui.Printer;
import lotto.ui.Receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    private static final String LOTTO_NUMBER_INPUT_DELIMITER = ", ";
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String LOTTO_TICKET_PRICE_RANGE_EXCEPTION_MESSAGE =
            "수동 구매 티켓의 갯수가 구입 금액을 초과했습니다.";

    private final Printer printer;
    private final Receiver receiver;

    public LottoApplication(Printer printer, Receiver receiver) {
        this.printer = printer;
        this.receiver = receiver;
    }

    public static void main(String[] args) {
        LottoApplication app = new LottoApplication(new Printer(), new Receiver(System.in));
        app.run();
    }

    public void run() {
        int purchaseAmount = receivePurchaseAmount();
        int manualTicketCount = receiveManualTicketCount(purchaseAmount);
        LottoTickets lottoTickets = Issuer.issueManualLottoTickets(manualTicketCount, receiveManualTicketNumber(manualTicketCount));
        lottoTickets.addTickets(Issuer.issueLottoTickets(purchaseAmount, manualTicketCount));
        printer.printIssuedTickets(lottoTickets, manualTicketCount);

        WinningNumber winningNumber = new WinningNumber(receiveWinningNumber(), receiveBonusNumber());
        GameResults gameResults = lottoTickets.matchNumbers(winningNumber);
        Statistics statistics = new Statistics(gameResults, purchaseAmount);
        printer.printStatistics(statistics);
    }

    private int receivePurchaseAmount() {
        printer.requestPurchaseAmount();
        String purchaseAmount = receiver.receiveLine();
        return Integer.parseInt(purchaseAmount);
    }

    private int receiveManualTicketCount(int purchaseAmount) {
        printer.requestManualTicketCount();
        int manualTicketCount = Integer.parseInt(receiver.receiveLine());
        if(manualTicketCount > purchaseAmount/LOTTO_TICKET_PRICE){
            throw new IllegalArgumentException(LOTTO_TICKET_PRICE_RANGE_EXCEPTION_MESSAGE);
        }
        return manualTicketCount;
    }

    private List<List<Integer>> receiveManualTicketNumber(int manualTicketCount) {
        printer.requestManualTicketNumber();
        List<List<Integer>> manualTickets = new ArrayList<>();
        for(int count = 0; count <manualTicketCount; count++) {
            String manualNumber = receiver.receiveLine();

             manualTickets.add(Arrays.stream(manualNumber.split(LOTTO_NUMBER_INPUT_DELIMITER))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));
        }
        return manualTickets;
    }

    private List<Integer> receiveWinningNumber() {
        printer.requestWinningNumber();
        String winningNumber = receiver.receiveLine();

        return Arrays.stream(winningNumber.split(LOTTO_NUMBER_INPUT_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private int receiveBonusNumber() {
        printer.requestBonusNumber();
        String bonusNumber = receiver.receiveLine();
        return Integer.parseInt(bonusNumber);
    }
}
