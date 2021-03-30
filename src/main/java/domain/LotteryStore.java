package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryStore {
    private final List<Integer> targetNumbers = new ArrayList<>();

    public LotteryStore() {
        initNumbers();
    }

    private void initNumbers() {
        for (int i = 1; i <= 45; i++) {
            targetNumbers.add(i);
        }
    }

    public Lotteries createLotteries(int count) {
        List<Lottery> lotteries = new ArrayList<>();
        while (count-- > 0) {
            lotteries.add(createLottery());
        }
        return new Lotteries(lotteries);
    }

    private Lottery createLottery() {
        Collections.shuffle(targetNumbers);
        Numbers numbers = new Numbers(
            targetNumbers.stream()
                .limit(6)
                .collect(Collectors.toList()));
        return new Lottery(numbers);
    }
}
