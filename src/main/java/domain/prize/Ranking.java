package domain.prize;

import java.util.List;

public class Ranking {
    private final List<Integer> sizeOfRanks;

    public Ranking(List<Integer> sizeOfRanks) {
        this.sizeOfRanks = sizeOfRanks;
    }

    public void increase(int index) {
        sizeOfRanks.set(index, sizeOfRanks.get(index) + 1);
    }

    public List<Integer> getSizeOfRanks() {
        return sizeOfRanks;
    }
}
