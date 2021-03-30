package domain.lotteryStore;

public class Lottery {
    private final Numbers numbers;

    public Lottery(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
