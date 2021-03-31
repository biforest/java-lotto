package domain.lotteryStore;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryStoreTest {

    private LotteryStore lotteryStore;

    @BeforeEach
    void setUp() {
        lotteryStore = new LotteryStore(new TargetNumbers());
    }

    @Test
    public void 공_6개를_뽑는다() throws Exception {
        //given
        int sizeOfLottery = 6;

        //when
        Lotteries lotteries = lotteryStore.createLotteries(1);

        //then
        assertThat(lotteries.getLotteries().get(0).getNumbers().getNumbers().size()).isEqualTo(sizeOfLottery);
    }
}