package lotto.domain.lotto;

public class Issuer {

    private Issuer() {
    }

    public static LottoTickets issueLottoTickets(IssueStrategy strategy) {
        return new LottoTickets(strategy.issue());
    }
}
