package domain.winningStatistics;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PrizeMoneyTest {

    @Test
    void 총수익률을_계산한다() {
        // given
        List<ComparisonResult> results = new ArrayList<>(Arrays.asList(
            new ComparisonResult(3, false),
            new ComparisonResult(4, false),
            new ComparisonResult(0, false),
            new ComparisonResult(2, true),
            new ComparisonResult(5, true),
            new ComparisonResult(1, false),
            new ComparisonResult(3, true)
        ));
        int purchasedCount = 7;

        WinningStatistics winningStatistics = new WinningStatistics();

        for (ComparisonResult result : results) {
            winningStatistics.checkRanking(result);
        }

        PrizeMoney[] values = PrizeMoney.values();

        // when
        float earningsRate = PrizeMoney.calculateEarningsRate(winningStatistics, purchasedCount);
        List<Integer> rankings = winningStatistics.getRankings();

        // then
        assertThat(earningsRate).isEqualTo(
            (float)(rankings.get(0) * values[0].getPrizeMoney() + rankings.get(1) * values[1].getPrizeMoney()
                + rankings.get(2) * values[2].getPrizeMoney() + rankings.get(3) * values[3].getPrizeMoney()
                + rankings.get(4) * values[4].getPrizeMoney()) / (purchasedCount * 1000));
    }
}