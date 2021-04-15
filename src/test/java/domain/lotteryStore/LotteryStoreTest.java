package domain.lotteryStore;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LotteryStoreTest {
    @Test
    public void 공_6개를_뽑는다() throws Exception {
        //given
        int sizeOfLottery = 6;

        //when
        Lotteries lotteries = LotteryStore.createLotteries(1, 0, new ArrayList<>());

        //then
        assertThat(lotteries.getLotteries().get(0).getNumbers().size()).isEqualTo(sizeOfLottery);
    }
}
