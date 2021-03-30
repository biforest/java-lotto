package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryStore {
    private List<Integer> numbers = new ArrayList<>();

    public LotteryStore() {
        initNumbers();
    }

    private void initNumbers() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
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
        Collections.shuffle(numbers);
        Numbers numbers1 = new Numbers(numbers.stream().limit(6).collect(Collectors.toList()));
        return new Lottery(numbers1);
    }
}
