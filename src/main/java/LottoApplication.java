import domain.LottoMachine;
import domain.Profit;
import domain.WinningStatus;
import domain.lastweekwinninglotto.LastWeekWinningBonusBall;
import domain.lastweekwinninglotto.LastWeekWinningLotto;
import domain.lottoticket.LottoTicket;
import domain.lottoticket.Lottos;
import domain.lottoticket.NumberOfLottoTicket;
import domain.strategy.RandomLottoNumberStrategy;
import ui.Printer;
import ui.Receiver;

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
        ArrayList<WinningStatus> getLottoPrices =  lottoMachine.Discriminator(lottos, lastWeekWinningLotto, lastWeekWinningBonusBall, numberOfLottoTicket);
        Profit profit = new Profit(getLottoPrices);
        printer.printLottoProfit(profit.getCalculatedProfit(numberOfLottoTicket));
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