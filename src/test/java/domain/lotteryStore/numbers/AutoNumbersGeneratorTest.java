package domain.lotteryStore.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class AutoNumbersGeneratorTest {
    @Test
    public void 자동_로또를_생성한다() throws Exception {
        //when
        List<LotteryNumber> autoLotteryNumbers = AutoNumbersGenerator.createAutoLotteryNumbers(
            ManualShuffleStrategy.getInstance());

        //then
        assertThat(autoLotteryNumbers.size()).isEqualTo(6);
        assertThat(autoLotteryNumbers.get(0).getNumber()).isEqualTo(3);
        assertThat(autoLotteryNumbers.get(1).getNumber()).isEqualTo(42);
        assertThat(autoLotteryNumbers.get(2).getNumber()).isEqualTo(5);
        assertThat(autoLotteryNumbers.get(3).getNumber()).isEqualTo(21);
        assertThat(autoLotteryNumbers.get(4).getNumber()).isEqualTo(15);
        assertThat(autoLotteryNumbers.get(5).getNumber()).isEqualTo(30);
    }
}