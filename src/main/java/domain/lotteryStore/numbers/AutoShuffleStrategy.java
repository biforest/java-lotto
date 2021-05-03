package domain.lotteryStore.numbers;

import java.util.Collections;
import java.util.List;

public class AutoShuffleStrategy implements ShuffleStrategy {
    private AutoShuffleStrategy() {
    }

    public static AutoShuffleStrategy getInstance() {
        return new AutoShuffleStrategy();
    }

    @Override
    public void shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}
