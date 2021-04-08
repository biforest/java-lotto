package lotto.domain.lotto;

import java.util.List;

public class LottoAutomaticTickets {
    private final List<LottoAutomaticTicket> lottoAutomaticTickets;

    public LottoAutomaticTickets(List<LottoAutomaticTicket> lottoAutomaticTickets) {
        this.lottoAutomaticTickets = lottoAutomaticTickets;
    }

    public List<LottoAutomaticTicket> getLottoManualTickets() {
        return lottoAutomaticTickets;
    }
}
