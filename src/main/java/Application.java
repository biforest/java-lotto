import java.util.List;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.LotteryStore;
import domain.value.BonusNumber;
import domain.value.ManualNumbersGenerator;
import domain.value.PurchasePrice;
import domain.winningStatistics.LotteryComparator;
import domain.winningStatistics.PrizeMoney;
import domain.winningStatistics.WinningStatistics;
import ui.Printer;
import ui.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Printer printer = new Printer();

        PurchasePrice purchasePrice = new PurchasePrice(receiver.receivePurchasePrice());
        int purchasedCount = purchasePrice.getPurchasedCount();
        int manualCount = receiver.receiveManualCount();
        List<String> manualNumbers = receiver.receiveManualNumbers(manualCount);
        printer.printPurchasedCount(manualCount, purchasedCount);

        LotteryStore lotteryStore = new LotteryStore();
        Lotteries lotteries = lotteryStore.createLotteries(purchasedCount, manualCount, manualNumbers);
        printer.printPurchasedLotteries(lotteries);

        ManualNumbersGenerator winningNumbers = new ManualNumbersGenerator(receiver.receiveWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(receiver.receiveBonusNumber(), winningNumbers);

        LotteryComparator lotteryComparator = new LotteryComparator();
        lotteryComparator.compareNumbers(winningNumbers, bonusNumber, lotteries);
        WinningStatistics winningStatistics = lotteryComparator.getWinningStatistics();

        printer.printWinningStatistics(winningStatistics);
        printer.printTotalEarningsRate(PrizeMoney.calculateEarningsRate(winningStatistics, purchasedCount));
    }
}
