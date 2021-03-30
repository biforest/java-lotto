package domain.lotteryStore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryStore {
    private final TargetNumbers targetNumbers;

    public LotteryStore(TargetNumbers targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public Lotteries createLotteries(int count) {
        List<Lottery> lotteries = new ArrayList<>();
        while (count-- > 0) {
            lotteries.add(createLottery());
        }
        return new Lotteries(lotteries);
    }

    private Lottery createLottery() {
        targetNumbers.shuffle();
        Numbers numbers = new Numbers(
            targetNumbers.getTargetNumbers()
                .stream()
                .limit(6)
                .collect(Collectors.toList()));
        return new Lottery(numbers);
    }
}
