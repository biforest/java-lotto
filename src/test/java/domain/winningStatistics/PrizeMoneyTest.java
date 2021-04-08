package domain.winningStatistics;

import static javax.swing.UIManager.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeMoneyTest {
    @Test
    void 총수익률을_계산한다() {
        // given
        WinningStatistics winningStatistics = new WinningStatistics() {{
            put(PrizeMoney.THREE, 3);
            put(PrizeMoney.FOUR, 1);
            put(PrizeMoney.FIVE, 3);
            put(PrizeMoney.FIVE_BONUS, 1);
            put(PrizeMoney.SIX, 1);
        }};
        int purchasedCount = 20;

        // when
        float earningsRate = PrizeMoney.calculateEarningsRate(winningStatistics, purchasedCount);
        PrizeMoney[] values = PrizeMoney.values();

        // then
        assertThat(earningsRate).isEqualTo(
            (float)(winningStatistics.get(values[0]) * values[0].getPrizeMoney()
                + winningStatistics.get(values[1]) * values[1].getPrizeMoney()
                + winningStatistics.get(values[2]) * values[2].getPrizeMoney()
                + winningStatistics.get(values[3]) * values[3].getPrizeMoney()
                + winningStatistics.get(values[4]) * values[4].getPrizeMoney()) / (purchasedCount * 1000));
    }
}
