package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import domain.prize.PrizeMoney;
import domain.prize.WinningStatistics;

class PrizeMoneyTest {

    @Test
    void 총수익률을_계산한다() {
        // given
        WinningStatistics winningStatistics = new WinningStatistics(Arrays.asList(3, 4, 0, 2, 1));
        int purchasePrice = 15000;

        // when
        float earningsRate = PrizeMoney.calculateEarningsRate(winningStatistics, purchasePrice);

        // then
        assertThat(earningsRate).isEqualTo(
            (float)(3 * 5000 + 4 * 50000 + 0 * 1500000 + 2 * 30000000 + 1 * 2000000000) / purchasePrice);
    }
}