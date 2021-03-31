package domain.lotteryStore;

import java.util.List;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public Lottery get(int index) {
        return lotteries.get(index);
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }
}
