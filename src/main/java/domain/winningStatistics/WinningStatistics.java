package domain.winningStatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rankings {
    private final List<Integer> rankings;

    public Rankings() {
        this.rankings = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    }

    public void increase(int index) {
        rankings.set(index, rankings.get(index) + 1);
    }

    public List<Integer> getRankings() {
        return rankings;
    }
}
