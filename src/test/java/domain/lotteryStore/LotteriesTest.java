package domain.lotteryStore;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.Lottery;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.winningStatistics.Ranking;
import domain.winningStatistics.WinningStatistics;

class LotteriesTest {
    private Lottery winningNumbers;
    private BonusNumber bonusNumber;
    private Lotteries lotteries;

    @BeforeEach
    void setUp() {
        winningNumbers = ManualNumbersGenerator.createWinningNumbers("1, 2, 3, 4, 5, 6");
        bonusNumber = BonusNumber.of(7, winningNumbers);
        lotteries = Lotteries.from(Arrays.asList(
            Lottery.from(Arrays.asList(8, 2, 23, 41, 4, 5)),
            Lottery.from(Arrays.asList(3, 5, 29, 6, 2, 38)),
            Lottery.from(Arrays.asList(4, 31, 5, 40, 2, 1)),
            Lottery.from(Arrays.asList(4, 1, 3, 45, 5, 2)),
            Lottery.from(Arrays.asList(7, 1, 2, 3, 4, 5)),
            Lottery.from(Arrays.asList(1, 2, 3, 4, 5, 6))
        ));
    }

    @Test
    public void 당첨_통계를_확인한다() throws Exception {
        //when
        lotteries.compareWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        WinningStatistics winningStatistics = lotteries.compareWithWinningNumbersAndBonusNumber(winningNumbers,
            bonusNumber);
        Ranking[] prizeMonies = Ranking.values();

        //then
        assertThat(winningStatistics.get(prizeMonies[0])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[1])).isEqualTo(2);
        assertThat(winningStatistics.get(prizeMonies[2])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[3])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[4])).isEqualTo(1);
    }
}
