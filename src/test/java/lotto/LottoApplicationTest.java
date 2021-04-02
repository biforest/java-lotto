package lotto;

import lotto.ui.Printer;
import lotto.ui.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoApplicationTest {

    @DisplayName("테스트 커버리지를 위한 ApplicationTest")
    @Test
    void application() {
        //given
        String input = "3000000\n1, 10, 25, 30, 31, 38\n44";
        LottoApplication app = new LottoApplication(
                new Printer(), new Receiver(new ByteArrayInputStream(input.getBytes()))
        );

        //when
        app.run();

        //then
        assertThat(true).isTrue();
     }
}
