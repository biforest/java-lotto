package domain.prize;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.lotteryService.Result;
import domain.lotteryService.Results;

class PrizeMoneyTest {

    @Test
    void 총수익률을_계산한다() {
        // given
        int purchasedCount = 7;
        List<Result> results = new ArrayList<>(Arrays.asList(
            new Result(3, false),
            new Result(4, false),
            new Result(0, false),
            new Result(2, true),
            new Result(5, true),
            new Result(1, false),
            new Result(3, true)
        ));
        WinningStatistics winningStatistics = new WinningStatistics(new Results(results));

        // when
        float earningsRate = PrizeMoney.calculateEarningsRate(winningStatistics, purchasedCount);

        // then
        assertThat(earningsRate).isEqualTo(
            (float)(2 * 5000 + 1 * 50000 + 0 * 1500000 + 1 * 30000000 + 0 * 2000000000) / (purchasedCount * 1000));
    }
}