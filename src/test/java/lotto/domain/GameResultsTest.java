package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    @DisplayName("모든 상금 더하기")
    @Test
    void calculatePrize() {
        //given
        List<GameResult> results = Arrays.asList(GameResult.UNDER_THREE_MATCHED, GameResult.THREE_MATCHED,
                GameResult.FOUR_MATCHED, GameResult.FIVE_MATCHED_WITH_BONUS, GameResult.FIVE_MATCHED_WITHOUT_BONUS, GameResult.ALL_MATCHED);
        GameResults gameResults = new GameResults(results);
        double expected = 2_031_555_000;
        //when
        double totalPrize = gameResults.calculatePrize();
        //then
        assertThat(totalPrize).isEqualTo(expected);
    }

    @DisplayName("모든 GameResult 경우에 대해 count")
    @Test
    void count() {
        //given
        List<GameResult> results = Arrays.asList(GameResult.UNDER_THREE_MATCHED, GameResult.THREE_MATCHED,
                GameResult.FOUR_MATCHED, GameResult.FIVE_MATCHED_WITH_BONUS, GameResult.FIVE_MATCHED_WITHOUT_BONUS, GameResult.ALL_MATCHED);
        GameResults gameResults = new GameResults(results);
        //when
        //then
        assertThat(gameResults.count(GameResult.UNDER_THREE_MATCHED)).isEqualTo(1);
        assertThat(gameResults.count(GameResult.THREE_MATCHED)).isEqualTo(1);
        assertThat(gameResults.count(GameResult.FOUR_MATCHED)).isEqualTo(1);
        assertThat(gameResults.count(GameResult.FIVE_MATCHED_WITHOUT_BONUS)).isEqualTo(1);
        assertThat(gameResults.count(GameResult.FIVE_MATCHED_WITH_BONUS)).isEqualTo(1);
        assertThat(gameResults.count(GameResult.ALL_MATCHED)).isEqualTo(1);
    }
}