package domain.winningStatistics;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComparisonResultTest {
    @Test
    void 랭킹을_확인한다() {
        WinningStatistics winningStatistics = WinningStatistics.getInstance();
        int matchingCount = 5;
        boolean havingBonusNumber = false;
        ComparisonResult comparisonResult = ComparisonResult.of(matchingCount, havingBonusNumber);

        comparisonResult.rank(winningStatistics);
        Map<Ranking, Integer> rankings = winningStatistics.getWinningStatistics();

        Assertions.assertThat(rankings.get(Ranking.THREE)).isEqualTo(0);
        Assertions.assertThat(rankings.get(Ranking.FOUR)).isEqualTo(0);
        Assertions.assertThat(rankings.get(Ranking.FIVE)).isEqualTo(1);
        Assertions.assertThat(rankings.get(Ranking.FIVE_BONUS)).isEqualTo(0);
        Assertions.assertThat(rankings.get(Ranking.SIX)).isEqualTo(0);
    }
}
