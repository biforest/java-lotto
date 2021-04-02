package lotto.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }
    public GameResults matchNumbers(WinningNumber winningNumber) {
        List<GameResult> results = lottoTickets.stream()
                .map(winningNumber::matchNumbers)
                .map(GameResult::evaluate)
                .collect(Collectors.toList());
        return new GameResults(results);
    }
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}