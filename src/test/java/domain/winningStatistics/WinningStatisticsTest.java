package domain.winningStatistics;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics();
    }

    @Test
    void 당첨자_수를_증가시킨다() {
        winningStatistics.increase(PrizeMoney.THREE);
        PrizeMoney[] prizeMonies = PrizeMoney.values();

        assertThat(winningStatistics.get(prizeMonies[0])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[1])).isEqualTo(0);
        assertThat(winningStatistics.get(prizeMonies[2])).isEqualTo(0);
        assertThat(winningStatistics.get(prizeMonies[3])).isEqualTo(0);
        assertThat(winningStatistics.get(prizeMonies[4])).isEqualTo(0);
    }
}