package domain.prize;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 각_티켓들의_결과들로부터_당첨된_티켓을_골라낸다() {
        // given
        List<Result> results = new ArrayList<>(Arrays.asList(
            new Result(3, false),
            new Result(4, false),
            new Result(0, false),
            new Result(2, true),
            new Result(5, true),
            new Result(1, false),
            new Result(3, true)
        ));

        // when
        WinningStatistics winningStatistics = new WinningStatistics(new Results(results));
        List<Integer> rankings = winningStatistics.getRankings();

        // then
        assertThat(rankings.get(0)).isEqualTo(2);
        assertThat(rankings.get(1)).isEqualTo(1);
        assertThat(rankings.get(2)).isEqualTo(0);
        assertThat(rankings.get(3)).isEqualTo(1);
        assertThat(rankings.get(4)).isEqualTo(0);
    }
}