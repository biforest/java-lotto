package lotto.domain;

import lotto.domain.dto.WinningResult;
import lotto.domain.result.GameResult;
import lotto.domain.result.GameResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    private final Statistics statistics;

    public StatisticsTest() {
        List<GameResult> results = Arrays.asList(GameResult.THREE_MATCHED, GameResult.UNDER_THREE_MATCHED, GameResult.THREE_MATCHED, GameResult.ALL_MATCHED,
                GameResult.THREE_MATCHED, GameResult.FOUR_MATCHED, GameResult.UNDER_THREE_MATCHED);

        GameResults gameResults = new GameResults(results);
        statistics = new Statistics(gameResults, 7000);
    }

    @DisplayName("출력용 WinningResult dto 테스트")
    @Test
    void winningResults() {
        //given
        //when
        List<WinningResult> winningResults = statistics.winningResults();

        //then
        assertThat(winningResults.get(0).getGameResult()).isEqualTo(GameResult.THREE_MATCHED);
        assertThat(winningResults.get(0).getNumberOfWinners()).isEqualTo(3);

        assertThat(winningResults.get(1).getGameResult()).isEqualTo(GameResult.FOUR_MATCHED);
        assertThat(winningResults.get(1).getNumberOfWinners()).isEqualTo(1);

        assertThat(winningResults.get(2).getGameResult()).isEqualTo(GameResult.FIVE_MATCHED_WITHOUT_BONUS);
        assertThat(winningResults.get(2).getNumberOfWinners()).isEqualTo(0);

        assertThat(winningResults.get(3).getGameResult()).isEqualTo(GameResult.FIVE_MATCHED_WITH_BONUS);
        assertThat(winningResults.get(3).getNumberOfWinners()).isEqualTo(0);

        assertThat(winningResults.get(4).getGameResult()).isEqualTo(GameResult.ALL_MATCHED);
        assertThat(winningResults.get(4).getNumberOfWinners()).isEqualTo(1);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        //given
        double expected = (double) 2_000_065_000 / 7000;

        //when
        double actual = statistics.calculateEarningRate();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이득인 경우 검증")
    @Test
    void isProfit() {
        //given when then
        assertThat(statistics.isProfit(statistics.calculateEarningRate())).isTrue();
    }

    @DisplayName("손해인 경우 검증")
    @Test
    void isLoss() {
        //given
        List<GameResult> results = Arrays.asList(GameResult.THREE_MATCHED, GameResult.UNDER_THREE_MATCHED, GameResult.UNDER_THREE_MATCHED,
                GameResult.UNDER_THREE_MATCHED, GameResult.UNDER_THREE_MATCHED, GameResult.UNDER_THREE_MATCHED, GameResult.UNDER_THREE_MATCHED);

        GameResults gameResults = new GameResults(results);
        Statistics lossStatistics = new Statistics(gameResults, 7000);

        //when then
        assertThat(lossStatistics.isProfit(lossStatistics.calculateEarningRate())).isFalse();
     }
}
