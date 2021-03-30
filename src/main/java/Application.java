import domain.lotteryService.LotteryMachine;
import domain.lotteryStore.Lotteries;
import domain.lotteryStore.LotteryStore;
import domain.lotteryStore.TargetNumbers;
import ui.Printer;
import ui.receiver.InputValidator;
import ui.receiver.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Printer printer = new Printer();

        int purchasePrice = receiver.receivePurchasePrice();
        InputValidator.validatePurchasePrice(purchasePrice);
        int purchasedCount = printer.printPurchasedCount(purchasePrice);

        LotteryStore lotteryStore = new LotteryStore(new TargetNumbers());
        Lotteries lotteries = lotteryStore.createLotteries(purchasedCount);
        printer.printPurchasedLotteries(lotteries);

        LotteryMachine lotteryMachine = new LotteryMachine(receiver.receiveWinningNumbers(),
            receiver.receiveBonusNumber());
    }
}
