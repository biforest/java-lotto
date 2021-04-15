package domain.lotteryStore.numbers;

import java.util.List;

public class Lottery {
    private final List<Integer> numbers;

    private Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lottery from(List<Integer> numbers) {
        return new Lottery(numbers);
    }

    public int countMatchingNumbers(Lottery winningNumbers) {
        return (int)winningNumbers.getNumbers()
            .stream()
            .filter(this::contains)
            .count();
    }

    public boolean contains(int numberToCompare) {
        return numbers.contains(numberToCompare);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
