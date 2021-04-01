package domain.lotteryService;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.lotteryStore.Numbers;

class LotteryMachineTest {

    private final Lotteries lotteries = new Lotteries(Arrays.asList(
        new Lottery(new Numbers(Arrays.asList(8, 2, 23, 41, 4, 5))),
        new Lottery(new Numbers(Arrays.asList(3, 5, 29, 6, 2, 38))),
        new Lottery(new Numbers(Arrays.asList(4, 31, 5, 40, 2, 1))),
        new Lottery(new Numbers(Arrays.asList(4, 1, 3, 45, 5, 2))),
        new Lottery(new Numbers(Arrays.asList(7, 1, 2, 3, 4, 5))),
        new Lottery(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
    ));

    @Test
    public void 각_티켓의_당첨_번호와_일치한_개수와_보너스_숫자를_확인한다() throws Exception {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        LotteryMachine lotteryMachine = new LotteryMachine(winningNumbers, bonusNumber);

        //when
        int purchasedCount = 6;
        List<Result> results = lotteryMachine.compareNumbers(lotteries, purchasedCount).getResults();

        //then
        assertThat(results.get(0).getMatchingCount()).isEqualTo(3);
        assertThat(results.get(0).isHavingBonusNumber()).isEqualTo(false);
        assertThat(results.get(1).getMatchingCount()).isEqualTo(4);
        assertThat(results.get(1).isHavingBonusNumber()).isEqualTo(false);
        assertThat(results.get(2).getMatchingCount()).isEqualTo(4);
        assertThat(results.get(2).isHavingBonusNumber()).isEqualTo(false);
        assertThat(results.get(3).getMatchingCount()).isEqualTo(5);
        assertThat(results.get(3).isHavingBonusNumber()).isEqualTo(false);
        assertThat(results.get(4).getMatchingCount()).isEqualTo(5);
        assertThat(results.get(4).isHavingBonusNumber()).isEqualTo(true);
        assertThat(results.get(5).getMatchingCount()).isEqualTo(6);
        assertThat(results.get(5).isHavingBonusNumber()).isEqualTo(false);
    }
}