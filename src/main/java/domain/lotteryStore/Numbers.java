package domain.lotteryStore;

import java.util.Collections;
import java.util.List;

import domain.value.WinningNumbers;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int countMatchingNumbers(WinningNumbers winningNumbers) {
        return (int)winningNumbers.getWinningNumbers()
            .stream()
            .filter(this::contains)
            .count();
    }

    public boolean contains(int compareToNumber) {
        return numbers.contains(compareToNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
