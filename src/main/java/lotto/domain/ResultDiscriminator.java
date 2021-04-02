package lotto.domain;

public class ResultDiscriminator {
    private final LottoTickets lottoTickets;
    private final WinningNumber winningNumber;

    public ResultDiscriminator(LottoTickets lottoTickets, WinningNumber winningNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumber = winningNumber;
    }

    public GameResults discriminate() {
        return lottoTickets.matchNumbers(winningNumber);
    }
}
