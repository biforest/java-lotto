package domain.winningStatistics;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 각_등수의_당첨자_수를_확인한다() {
        // given
        List<ComparisonResult> results = new ArrayList<>(Arrays.asList(
            new ComparisonResult(3, false),
            new ComparisonResult(5, false),
            new ComparisonResult(4, false),
            new ComparisonResult(0, false),
            new ComparisonResult(2, true),
            new ComparisonResult(5, true),
            new ComparisonResult(1, false),
            new ComparisonResult(3, true)
        ));

        // when
        WinningStatistics winningStatistics = new WinningStatistics();

        for (ComparisonResult result : results) {
            winningStatistics.checkRanking(result);
        }

        List<Integer> rankings = winningStatistics.getRankings();

        // then
        assertThat(rankings.get(0)).isEqualTo(2);
        assertThat(rankings.get(1)).isEqualTo(1);
        assertThat(rankings.get(2)).isEqualTo(1);
        assertThat(rankings.get(3)).isEqualTo(1);
        assertThat(rankings.get(4)).isEqualTo(0);
    }
}