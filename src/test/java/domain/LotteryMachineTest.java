package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.lotteryService.LotteryMachine;
import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.lotteryStore.Numbers;
import domain.prize.Result;

class LotteryMachineTest {

    private LotteryMachine lotteryMachine;
    private int purchasedCount = 6;
    private Lotteries lotteries = new Lotteries(Arrays.asList(
        new Lottery(new Numbers(Arrays.asList(8, 2, 23, 41, 4, 5))),
        new Lottery(new Numbers(Arrays.asList(3, 5, 29, 6, 2, 38))),
        new Lottery(new Numbers(Arrays.asList(4, 31, 5, 40, 2, 1))),
        new Lottery(new Numbers(Arrays.asList(4, 1, 3, 45, 5, 2))),
        new Lottery(new Numbers(Arrays.asList(7, 1, 2, 3, 4, 5))),
        new Lottery(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
    ));

    @BeforeEach
    void setUp() {
    }

    @Test
    public void 당첨_번호를_확인한다() throws Exception {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        lotteryMachine = new LotteryMachine(winningNumbers, bonusNumber);

        //when
        Result result = lotteryMachine.compareNumbers(lotteries, purchasedCount);

        //then
        assertThat(result.getResult().get(0)).isEqualTo(1);
        assertThat(result.getResult().get(1)).isEqualTo(2);
        assertThat(result.getResult().get(2)).isEqualTo(1);
        assertThat(result.getResult().get(3)).isEqualTo(1);
        assertThat(result.getResult().get(4)).isEqualTo(1);
    }
}