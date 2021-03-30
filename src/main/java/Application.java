import domain.Lotteries;
import domain.LotteryStore;
import ui.Printer;
import ui.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Printer printer = new Printer();
        int purchasedCount = printer.printPurchasedCount(receiver.receivePurchasePrice());

        LotteryStore lotteryStore = new LotteryStore();
        Lotteries lotteries = lotteryStore.createLotteries(purchasedCount);
        printer.printPurchasedLotteries(lotteries);
    }
}
