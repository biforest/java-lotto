import domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    void getLotto() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        List<String> lottoData = lotto.getLotto();

        assertThat((lottoData).contains("1"));
        assertThat((lottoData).contains("2"));
        assertThat((lottoData).contains("3"));
        assertThat((lottoData).contains("4"));
        assertThat((lottoData).contains("5"));
        assertThat((lottoData).contains("6"));
    }
}
