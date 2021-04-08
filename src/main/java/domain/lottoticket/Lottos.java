package domain.lottoticket;

import java.util.List;

public class Lottos {
    private final List<LottoTicket> lotto;

    public Lottos(List<LottoTicket> lotto ) {
        this.lotto = lotto;
    }

    public List<LottoTicket> getLottos() {
        return this.lotto;
    }
}