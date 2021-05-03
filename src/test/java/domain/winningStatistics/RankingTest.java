package domain.winningStatistics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankingTest {
    @Test
    void 총수익률을_계산한다() {
        // given
        WinningStatistics winningStatistics = WinningStatistics.getInstance();
        winningStatistics.getWinningStatistics().put(Ranking.THREE, 3);
        winningStatistics.getWinningStatistics().put(Ranking.FOUR, 1);
        winningStatistics.getWinningStatistics().put(Ranking.FIVE, 3);
        winningStatistics.getWinningStatistics().put(Ranking.FIVE_BONUS, 1);
        winningStatistics.getWinningStatistics().put(Ranking.SIX, 1);

        int purchasedCount = 20;

        // when
        double earningsRate = Ranking.calculateEarningsRate(winningStatistics, purchasedCount);
        Ranking[] values = Ranking.values();

        // then
        assertThat(earningsRate).isEqualTo(
            (double)(winningStatistics.get(values[0]) * values[0].getPrizeMoney()
                + winningStatistics.get(values[1]) * values[1].getPrizeMoney()
                + winningStatistics.get(values[2]) * values[2].getPrizeMoney()
                + winningStatistics.get(values[3]) * values[3].getPrizeMoney()
                + winningStatistics.get(values[4]) * values[4].getPrizeMoney()) / (purchasedCount * 1000));
    }
}
