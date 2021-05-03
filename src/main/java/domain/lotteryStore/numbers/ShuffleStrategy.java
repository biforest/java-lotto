package domain.lotteryStore.numbers;

import java.util.List;

public interface ShuffleStrategy {
    void shuffle(List<Integer> numbers);
}
