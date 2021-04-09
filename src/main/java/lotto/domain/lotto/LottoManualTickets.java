package lotto.domain.lotto;

import java.util.List;

public class LottoManualTickets {
    private final List<LottoManualTicket> lottoManualTickets;

    public LottoManualTickets(List<LottoManualTicket> lottoManualTickets) {
        this.lottoManualTickets = lottoManualTickets;
    }

    public List<LottoManualTicket> getLottoManualTickets() {
        return lottoManualTickets;
    }
}
