import domain.LottoCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCountTest {
    @Test
    void 자동로또의_수는_전체_수에서_수동로또의_수를_뺀_것과_같다 () {
        LottoCount count = new LottoCount(100, 43);
        assertThat(count.getAutoLottoCount()).isEqualTo(57);
    }
}
