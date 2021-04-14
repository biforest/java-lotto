import java.util.List;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.LotteryStore;
import domain.lotteryStore.PurchasePrice;
import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.winningStatistics.PrizeMoney;
import domain.winningStatistics.WinningStatistics;
import ui.Printer;
import ui.Receiver;

public class Application {
    private final Receiver receiver;
    private final Printer printer;

    public Application() {
        receiver = new Receiver();
        printer = new Printer();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        PurchasePrice purchasePrice = new PurchasePrice(receiver.receivePurchasePrice());
        int purchasedCount = purchasePrice.getPurchasedCount();
        int manualCount = receiver.receiveManualCount();
        List<String> manualNumbers = receiver.receiveManualNumbers(manualCount);
        printer.printPurchasedCount(manualCount, purchasedCount);

        Lotteries lotteries = LotteryStore.createLotteries(purchasedCount, manualCount, manualNumbers);
        printer.printPurchasedLotteries(lotteries);

        ManualNumbersGenerator winningNumbers = new ManualNumbersGenerator(receiver.receiveWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(receiver.receiveBonusNumber(), winningNumbers);

        WinningStatistics winningStatistics = lotteries.compareWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        printer.printWinningStatistics(winningStatistics);
        printer.printTotalEarningsRate(PrizeMoney.calculateEarningsRate(winningStatistics, purchasedCount));
    }
}
