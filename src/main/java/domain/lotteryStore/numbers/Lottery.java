package domain.lotteryStore.numbers;

import java.util.List;

import domain.winningStatistics.ComparisonResult;

public class Lottery {
    private final List<Integer> numbers;

    private Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lottery from(List<Integer> numbers) {
        return new Lottery(numbers);
    }

    public ComparisonResult compareOneTicketNumbers(Lottery winningNumbers, BonusNumber bonusNumber) {
        int countOfMatchingNumbers = countMatchingNumbers(winningNumbers);
        boolean hasBonusNumber = contains(bonusNumber.getBonusNumber());
        return ComparisonResult.of(countOfMatchingNumbers, hasBonusNumber);
    }

    private int countMatchingNumbers(Lottery winningNumbers) {
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
