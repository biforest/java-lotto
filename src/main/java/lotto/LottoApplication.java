package lotto;

import lotto.domain.*;
import lotto.domain.lotto.*;
import lotto.domain.result.GameResults;
import lotto.ui.Printer;
import lotto.ui.Receiver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoApplication {
    private static final String LOTTO_NUMBER_INPUT_DELIMITER = ",";

    private final Printer printer;
    private final Receiver receiver;

    public LottoApplication(Printer printer, Receiver receiver) {
        this.printer = printer;
        this.receiver = receiver;
    }

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        LottoTickets manualLottoTickets = createManualLottoTickets(purchaseAmount);
        LottoTickets autoLottoTickets = Issuer.issueLottoTickets(new AutoIssueStrategy(purchaseAmount.getNumberOfAutos()));
        LottoTickets totalTickets = manualLottoTickets.merge(autoLottoTickets);
        printer.printIssuedTickets(purchaseAmount, totalTickets);

        WinningNumber winningNumber = new WinningNumber(receiveWinningNumber(), receiveBonusNumber());
        GameResults gameResults = totalTickets.matchNumbers(winningNumber);
        Statistics statistics = new Statistics(gameResults, purchaseAmount);
        printer.printStatistics(statistics);
    }

    private PurchaseAmount createPurchaseAmount() {
        printer.requestPurchaseAmount();
        String purchaseAmount = receiver.receiveLine();
        printer.requestNumberOfManuals();
        String numberOfManuals = receiver.receiveLine();
        return new PurchaseAmount(Integer.parseInt(purchaseAmount), Integer.parseInt(numberOfManuals));
    }

    private LottoTickets createManualLottoTickets(PurchaseAmount purchaseAmount) {
        printer.requestManualLottoNumbers();
        List<LottoNumbers> lottoNumbers = IntStream.range(0, purchaseAmount.getNumberOfManuals())
                .mapToObj(__ -> createManualLottoNumbers())
                .collect(Collectors.toList());
        return Issuer.issueLottoTickets(new ManualIssueStrategy(lottoNumbers));
    }

    private LottoNumbers createManualLottoNumbers() {
        return new LottoNumbers(
                Arrays.stream(receiver.receiveLine().split(LOTTO_NUMBER_INPUT_DELIMITER))
                        .map(String::trim)
                        .map(Integer::valueOf)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    private List<Integer> receiveWinningNumber() {
        printer.requestWinningNumber();
        String winningNumber = receiver.receiveLine();

        return Arrays.stream(winningNumber.split(LOTTO_NUMBER_INPUT_DELIMITER))
                .map(String::trim)
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
