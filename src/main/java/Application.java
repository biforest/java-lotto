import domain.lotteryService.LotteryMachine;
import domain.lotteryStore.Lotteries;
import domain.lotteryStore.LotteryStore;
import ui.Printer;
import ui.receiver.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Printer printer = new Printer();
        int purchasedCount = printer.printPurchasedCount(receiver.receivePurchasePrice());

        LotteryStore lotteryStore = new LotteryStore();
        Lotteries lotteries = lotteryStore.createLotteries(purchasedCount);
        printer.printPurchasedLotteries(lotteries);

        LotteryMachine lotteryMachine = new LotteryMachine(receiver.receiveWinningNumbers(),
            receiver.receiveBonusNumber());
    }
}
