package domain.winningStatistics;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComparisonResultTest {
    @Test
    void 랭킹을_확인한다() {
        WinningStatistics winningStatistics = new WinningStatistics();
        int matchingCount = 5;
        boolean havingBonusNumber = false;
        ComparisonResult comparisonResult = new ComparisonResult(matchingCount, havingBonusNumber);

        comparisonResult.rank(winningStatistics);
        Map<PrizeMoney, Integer> rankings = winningStatistics.getWinningStatistics();

        Assertions.assertThat(rankings.get(PrizeMoney.THREE)).isEqualTo(0);
        Assertions.assertThat(rankings.get(PrizeMoney.FOUR)).isEqualTo(0);
        Assertions.assertThat(rankings.get(PrizeMoney.FIVE)).isEqualTo(1);
        Assertions.assertThat(rankings.get(PrizeMoney.FIVE_BONUS)).isEqualTo(0);
        Assertions.assertThat(rankings.get(PrizeMoney.SIX)).isEqualTo(0);
    }
}
