import domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void 당첨번호가_로또번호_6개랑_같을_때_예외_메시지_출력() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumber = LottoNumber.of(1);

        assertThatThrownBy(() -> new WinningLotto(lotto, lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
