package ui;

import domain.Lotteries;
import domain.Message;

public class Printer {

    public int printPurchasedCount(int purchasePrice) {
        int purchasedCount = purchasePrice / 1000;
        System.out.println(purchasedCount + Message.PURCHASED_COUNT.getMessage());
        return purchasedCount;
    }

    public void printPurchasedLotteries(Lotteries lotteries) {
        lotteries.getLotteries()
            .stream()
            .map(lottery -> lottery.getNumbers().getNumbers())
            .forEach(System.out::println);
    }
}
