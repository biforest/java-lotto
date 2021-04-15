package domain.lotteryStore.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.winningStatistics.ComparisonResult;

class LotteryTest {
    private Lottery winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = ManualNumbersGenerator.createWinningNumbers("1, 2, 3, 4, 5, 6");
        bonusNumber = BonusNumber.of(7, winningNumbers);
    }

    @Test
    public void 로또_티켓_하나의_비교_결과를_확인한다() {
        Lottery lottery1 = Lottery.from(Arrays.asList(24, 5, 1, 44, 4, 3));
        Lottery lottery2 = Lottery.from(Arrays.asList(3, 4, 2, 7, 1, 6));

        //when
        ComparisonResult result1 = lottery1.compareOneTicketNumbers(winningNumbers, bonusNumber);
        ComparisonResult result2 = lottery2.compareOneTicketNumbers(winningNumbers, bonusNumber);

        //then
        assertThat(result1.getMatchingCount()).isEqualTo(4);
        assertThat(result1.isHavingBonusNumber()).isEqualTo(false);
        assertThat(result2.getMatchingCount()).isEqualTo(5);
        assertThat(result2.isHavingBonusNumber()).isEqualTo(true);
    }
}