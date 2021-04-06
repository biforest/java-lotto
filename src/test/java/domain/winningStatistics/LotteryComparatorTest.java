package domain.winningStatistics;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.lotteryStore.Numbers;
import domain.value.BonusNumber;
import domain.value.ManualNumbersGenerator;

class LotteryComparatorTest {

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
        //given
        LotteryComparator lotteryComparator = new LotteryComparator();

        //when
        ComparisonResult result1 = lotteryComparator.compareOneTicketNumbers(winningNumbers, bonusNumber,
            lotteries.get(1));
        ComparisonResult result2 = lotteryComparator.compareOneTicketNumbers(winningNumbers, bonusNumber,
            lotteries.get(4));

        //then
        assertThat(result1.getMatchingCount()).isEqualTo(4);
        assertThat(result1.isHavingBonusNumber()).isEqualTo(false);
        assertThat(result2.getMatchingCount()).isEqualTo(5);
        assertThat(result2.isHavingBonusNumber()).isEqualTo(true);
    }

    @Test
    public void 당첨_통계를_확인한다() throws Exception {
        //given
        LotteryComparator lotteryComparator = new LotteryComparator();
        int purchasedCount = 6;

        //when
        lotteryComparator.compareNumbers(winningNumbers, bonusNumber, lotteries);
        WinningStatistics winningStatistics = lotteryComparator.getWinningStatistics();
        List<Integer> rankings = winningStatistics.getRankings();

        //then
        assertThat(rankings.get(0)).isEqualTo(1);
        assertThat(rankings.get(1)).isEqualTo(2);
        assertThat(rankings.get(2)).isEqualTo(1);
        assertThat(rankings.get(3)).isEqualTo(1);
        assertThat(rankings.get(4)).isEqualTo(1);
    }
}