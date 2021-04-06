package domain.lotteryStore;

import java.util.ArrayList;
import java.util.List;

public class LotteryStore {
    private final AutoNumbersGenerator autoNumbersGenerator = new AutoNumbersGenerator();

    public Lotteries createLotteries(int count) {
        List<Lottery> lotteries = new ArrayList<>();
        while (count-- > 0) {
            lotteries.add(createLottery());
        }
        return new Lotteries(lotteries);
    }

    private Lottery createLottery() {
        autoNumbersGenerator.shuffle();
        Numbers numbers = new Numbers(autoNumbersGenerator.getSixNumbersFromTheFront());
        return new Lottery(numbers);
    }
}
