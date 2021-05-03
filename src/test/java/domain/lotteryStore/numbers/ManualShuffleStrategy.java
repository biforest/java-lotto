package domain.lotteryStore.numbers;

import java.util.Collections;
import java.util.List;

public class ManualShuffleStrategy implements ShuffleStrategy {
    private ManualShuffleStrategy() {
    }

    public static ManualShuffleStrategy getInstance() {
        return new ManualShuffleStrategy();
    }

    @Override
    public void shuffle(List<Integer> numbers) {
        Collections.swap(numbers, 0, 14);
        Collections.swap(numbers, 1, 41);
        Collections.swap(numbers, 2, 4);
        Collections.swap(numbers, 3, 20);
        Collections.swap(numbers, 4, 0);
        Collections.swap(numbers, 5, 29);
    }
}
