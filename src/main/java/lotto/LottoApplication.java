package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.lastweekwinninglotto.LastWeekWinningBonusBall;
import lotto.domain.lastweekwinninglotto.LastWeekWinningLotto;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.Lottos;
import lotto.domain.lottoticket.NumberOfLottoTicket;
import lotto.domain.strategy.RandomLottoNumberStrategy;
import lotto.ui.Printer;
import lotto.ui.Receiver;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private static LottoMachine lottoMachine = new LottoMachine();
    private final RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy();

    public void run() {
        printer.requestPurchaseAmount();
        NumberOfLottoTicket numberOfLottoTicket = new NumberOfLottoTicket(receiver.receiveLottoTotalAmount());
        Lottos lottos = makeLottos(numberOfLottoTicket);
        printer.printAllLotto(lottos);
        printer.requestLastWeekLottoWinningNumber();
        List<Integer> LastWeekLottoWinningNumbers = receiver.receiveLastWeekLottoWinningNumbers();
        LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(LastWeekLottoWinningNumbers);
        printer.requestLottoBonusBallNumber();
        LastWeekWinningBonusBall lastWeekWinningBonusBall = new LastWeekWinningBonusBall(receiver.receiveLottoBonusBallNumber());
        lottoMachine.Discriminator(lottos, lastWeekWinningLotto, lastWeekWinningBonusBall, numberOfLottoTicket);
    }

    private Lottos makeLottos(NumberOfLottoTicket numberOfLottoTicket) {
        ArrayList<LottoTicket> lottoDummy = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTicket.getNumberOfLottoTicket(); i++) {
            LottoTicket lotto = new LottoTicket(randomLottoNumberStrategy.getRandomLottoNumbers());
            lottoDummy.add(lotto);
        }
        Lottos lottos = new Lottos(lottoDummy);
        return lottos;
    }

    public static void main(String[] args) {
        LottoApplication app = new LottoApplication();
        app.run();
    }
}

