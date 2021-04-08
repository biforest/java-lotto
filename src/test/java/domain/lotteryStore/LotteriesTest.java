package domain.lotteryStore;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import domain.winningStatistics.PrizeMoney;
import org.junit.jupiter.api.Test;

import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.lotteryStore.numbers.Numbers;
import domain.winningStatistics.ComparisonResult;
import domain.winningStatistics.WinningStatistics;

class LotteriesTest {
    private final ManualNumbersGenerator winningNumbers = new ManualNumbersGenerator("1, 2, 3, 4, 5, 6");
    private final BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
    private final Lotteries lotteries = new Lotteries(Arrays.asList(
        new Lottery(new Numbers(Arrays.asList(8, 2, 23, 41, 4, 5))),
        new Lottery(new Numbers(Arrays.asList(3, 5, 29, 6, 2, 38))),
        new Lottery(new Numbers(Arrays.asList(4, 31, 5, 40, 2, 1))),
        new Lottery(new Numbers(Arrays.asList(4, 1, 3, 45, 5, 2))),
        new Lottery(new Numbers(Arrays.asList(7, 1, 2, 3, 4, 5))),
        new Lottery(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
    ));

    @Test
    public void 로또_티켓_하나의_비교_결과를_확인한다() {
        //when
        ComparisonResult result1 = lotteries.compareOneTicketNumbers(winningNumbers, bonusNumber, lotteries.get(1));
        ComparisonResult result2 = lotteries.compareOneTicketNumbers(winningNumbers, bonusNumber, lotteries.get(4));

        //then
        assertThat(result1.getMatchingCount()).isEqualTo(4);
        assertThat(result1.isHavingBonusNumber()).isEqualTo(false);
        assertThat(result2.getMatchingCount()).isEqualTo(5);
        assertThat(result2.isHavingBonusNumber()).isEqualTo(true);
    }

    @Test
    public void 당첨_통계를_확인한다() throws Exception {
        //when
        lotteries.compareWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        WinningStatistics winningStatistics = lotteries.compareWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        PrizeMoney[] prizeMonies = PrizeMoney.values();

        //then
        assertThat(winningStatistics.get(prizeMonies[0])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[1])).isEqualTo(2);
        assertThat(winningStatistics.get(prizeMonies[2])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[3])).isEqualTo(1);
        assertThat(winningStatistics.get(prizeMonies[4])).isEqualTo(1);
    }
}
