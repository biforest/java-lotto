package domain.lotteryStore;

import domain.lotteryStore.numbers.Numbers;

public class Lottery {
    private final Numbers numbers;

    public Lottery(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
