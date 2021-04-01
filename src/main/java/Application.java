import domain.lotteryStore.Lotteries;
import domain.lotteryStore.LotteryStore;
import domain.value.BonusNumber;
import domain.value.PurchasePrice;
import domain.value.WinningNumbers;
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
        int purchasedCount = printer.printPurchasedCount(purchasePrice);

        LotteryStore lotteryStore = new LotteryStore();
        Lotteries lotteries = lotteryStore.createLotteries(purchasedCount);
        printer.printPurchasedLotteries(lotteries);

        WinningNumbers winningNumbers = new WinningNumbers(receiver.receiveWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(receiver.receiveBonusNumber(), winningNumbers);

        LotteryComparator lotteryComparator = new LotteryComparator();
        lotteryComparator.compareNumbers(winningNumbers, bonusNumber, lotteries, purchasedCount);
        WinningStatistics winningStatistics = lotteryComparator.getWinningStatistics();

        printer.printWinningStatistics(winningStatistics);
        printer.printTotalEarningsRate(PrizeMoney.calculateEarningsRate(winningStatistics, purchasedCount));
    }
}
