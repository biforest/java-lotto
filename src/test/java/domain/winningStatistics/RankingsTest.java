package domain.winningStatistics;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RankingsTest {

    private Rankings rankings;

    @BeforeEach
    void setUp() {
        rankings = new Rankings();
    }

    @Test
    void 당첨자_수를_증가시킨다() {
        rankings.increase(1);
        List<Integer> sizeOfWinners = rankings.getRankings();

        assertThat(sizeOfWinners.get(0)).isEqualTo(0);
        assertThat(sizeOfWinners.get(1)).isEqualTo(1);
        assertThat(sizeOfWinners.get(0)).isEqualTo(0);
        assertThat(sizeOfWinners.get(0)).isEqualTo(0);
        assertThat(sizeOfWinners.get(0)).isEqualTo(0);
    }
}