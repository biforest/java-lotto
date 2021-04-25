import java.util.List;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.LotteryStore;
import domain.lotteryStore.PurchasePrice;
import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.Lottery;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.winningStatistics.Ranking;
import domain.winningStatistics.WinningStatistics;
import ui.Printer;
import ui.Receiver;

public class LottoController {
    public void run() {
        PurchasePrice purchasePrice = PurchasePrice.from(Receiver.receivePurchasePrice());
        int purchasedCount = purchasePrice.getPurchasedCount();
        int manualCount = Receiver.receiveManualCount();
        List<String> manualNumbers = Receiver.receiveManualNumbers(manualCount);
        Printer.printPurchasedCount(manualCount, purchasedCount);

        Lotteries lotteries = LotteryStore.createLotteries(purchasedCount, manualCount, manualNumbers);
        Printer.printPurchasedLotteries(lotteries);

        Lottery winningNumbers = ManualNumbersGenerator.createWinningNumbers(Receiver.receiveWinningNumbers());
        BonusNumber bonusNumber = BonusNumber.of(Receiver.receiveBonusNumber(), winningNumbers);

        WinningStatistics winningStatistics = lotteries.compareWithWinningNumbersAndBonusNumber(winningNumbers,
            bonusNumber);
        Printer.printWinningStatistics(winningStatistics);
        Printer.printTotalEarningsRate(Ranking.calculateEarningsRate(winningStatistics, purchasedCount));
    }
}
