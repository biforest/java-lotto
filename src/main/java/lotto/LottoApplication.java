package lotto;

import lotto.domain.*;
import lotto.domain.factory.Issuer;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.result.GameResults;
import lotto.ui.Printer;
import lotto.ui.Receiver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    private static final String WINNING_NUMBER_INPUT_DELIMITER = ", ";

    private final Printer printer;
    private final Receiver receiver;

    public LottoApplication(Printer printer, Receiver receiver) {
        this.printer = printer;
        this.receiver = receiver;
    }

    public void run() {
        int purchaseAmount = receivePurchaseAmount();
        LottoTickets lottoTickets = Issuer.issueLottoTickets(purchaseAmount);
        printer.printIssuedTickets(lottoTickets);

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

    private List<Integer> receiveWinningNumber() {
        printer.requestWinningNumber();
        String winningNumber = receiver.receiveLine();

        return Arrays.stream(winningNumber.split(WINNING_NUMBER_INPUT_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private int receiveBonusNumber() {
        printer.requestBonusNumber();
        String bonusNumber = receiver.receiveLine();
        return Integer.parseInt(bonusNumber);
    }

    public static void main(String[] args) {
        LottoApplication app = new LottoApplication(new Printer(), new Receiver(System.in));
        app.run();
    }
}
