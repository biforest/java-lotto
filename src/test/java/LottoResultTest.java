import domain.LottoRank;
import domain.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    @Test
    void 전체_이익은_각_로또의_돈과_같다() {
        Map<LottoRank, Integer> rankResult = new HashMap<>();
        rankResult.put(LottoRank.SIX_MATCH, 1);
        rankResult.put(LottoRank.FIVE_MATCH_WITH_BONUS_BALL, 3);
        rankResult.put(LottoRank.THREE_MATCH, 4);

        LottoResult result = new LottoResult(rankResult);

        assertThat(result.calculateTotalPrize()).isEqualTo(2_000_000_000L + 30_000_000 * 3 + 5_000 * 4);
    }
}
