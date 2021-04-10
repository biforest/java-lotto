import domain.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankTest {
    @Test
    void 맞은_개수와_등수_확인한다 () {
        assertThat(LottoRank.getRank(3, false)).isEqualTo(LottoRank.THREE_MATCH);
        assertThat(LottoRank.getRank(3, true)).isEqualTo(LottoRank.THREE_MATCH);

        assertThat(LottoRank.getRank(4, false)).isEqualTo(LottoRank.FOUR_MATCH);
        assertThat(LottoRank.getRank(4, true)).isEqualTo(LottoRank.FOUR_MATCH);

        assertThat(LottoRank.getRank(5, false)).isEqualTo(LottoRank.FIVE_MATCH);
        assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.FIVE_MATCH_WITH_BONUS_BALL);

        assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.SIX_MATCH);
        assertThat(LottoRank.getRank(6, true)).isEqualTo(LottoRank.SIX_MATCH);
    }
}
