package lotto;

import lotto.domain.LottoStore;
import lotto.domain.NumberOfLottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.LastWeekWinningBonusBall;
import lotto.domain.lotto.LastWeekWinningLotto;
import lotto.domain.lotto.LottoAutomaticTickets;
import lotto.domain.lotto.LottoManualTickets;

public class LottoApplication {
    private final LottoStore lottoStore = new LottoStore();

    public void run() {
        PurchaseAmount purchaseAmount = lottoStore.inputLottoPurchaseAmount();
        int lottoManualTicketNumber = lottoStore.inputLottoManualTicketNumber();
        LottoManualTickets lottoManualTickets = lottoStore.inputLottoManualTickets(lottoManualTicketNumber);
        NumberOfLottoTicket numberOfLottoTicket = lottoStore.informNumberOfLottoTicket(purchaseAmount, lottoManualTicketNumber);
        LottoAutomaticTickets lottoAutomaticTickets = lottoStore.informLottoAutomaticTickets(lottoManualTickets, numberOfLottoTicket);
        LastWeekWinningLotto lastWeekWinningLotto = lottoStore.inputLastWeekWinningLotto();
        LastWeekWinningBonusBall lastWeekWinningBonusBall = lottoStore.inputLastWeekWinningBonusBall();
        lottoStore.informLottoStatistics(numberOfLottoTicket, lottoManualTickets, lottoAutomaticTickets, lastWeekWinningLotto, lastWeekWinningBonusBall);
    }

    public static void main(String[] args) {
        LottoApplication app = new LottoApplication();
        app.run();
    }
}
