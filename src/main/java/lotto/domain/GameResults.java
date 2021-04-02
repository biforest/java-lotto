package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> results;

    public GameResults(List<GameResult> results) {
        this.results = new ArrayList<>(results);
    }
}
