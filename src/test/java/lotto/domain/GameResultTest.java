package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {
    @DisplayName("일치 결과에 따른 GameResult 생성 테스트")
    @MethodSource(value = "provideEvaluate")
    @ParameterizedTest(name = "matchCount = {0}, isBonusMatch = {1}, expected = {2}")
    void evaluate(int count, boolean isBonusMatch, GameResult expected) {
        //given
        MatchCount matchCount = new MatchCount(count, isBonusMatch);
        //when
        GameResult gameResult = GameResult.evaluate(matchCount);
        //then
        assertThat(gameResult).isEqualTo(expected);
    }
    private static Stream<Arguments> provideEvaluate() {
        return Stream.of(
                Arguments.of(0, true, GameResult.UNDER_THREE_MATCHED),
                Arguments.of(0, false, GameResult.UNDER_THREE_MATCHED),
                Arguments.of(1, true, GameResult.UNDER_THREE_MATCHED),
                Arguments.of(1, false, GameResult.UNDER_THREE_MATCHED),
                Arguments.of(2, true, GameResult.UNDER_THREE_MATCHED),
                Arguments.of(2, false, GameResult.UNDER_THREE_MATCHED),
                Arguments.of(3, true, GameResult.THREE_MATCHED),
                Arguments.of(3, false, GameResult.THREE_MATCHED),
                Arguments.of(4, true, GameResult.FOUR_MATCHED),
                Arguments.of(4, false, GameResult.FOUR_MATCHED),
                Arguments.of(5, true, GameResult.FIVE_MATCHED_WITH_BONUS),
                Arguments.of(5, false, GameResult.FIVE_MATCHED_WITHOUT_BONUS),
                Arguments.of(6, false, GameResult.ALL_MATCHED)
        );
    }
    @DisplayName("비정상적인 일치 결과에 따른 예외 발생")
    @Test
    void evaluateException() {
        //given
        MatchCount matchCount = new MatchCount(7, true);
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> GameResult.evaluate(matchCount))
                .withMessage("일치하는 게임 결과가 없습니다.");
    }
    @DisplayName("description getter 테스트")
    @Test
    void getDescription() {
        //given
        GameResult gameResult = GameResult.ALL_MATCHED;
        //when then
        assertThat(gameResult.getDescription()).isEqualTo("6개 일치");
    }
}