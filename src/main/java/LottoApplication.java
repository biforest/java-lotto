import java.util.ArrayList;
import java.util.List;
import domain.LottoNumber;
import domain.Lotto;
import domain.LottoCount;
import domain.Lottos;
import domain.Money;
import domain.ProfitResult;
import domain.WinningLotto;
import ui.Receiver;
import ui.Printer;

public class LottoApplication {

    Printer printer = new Printer();
    Receiver receiver = new Receiver();

    public static void main(String[] args) {
        LottoApplication app = new LottoApplication();
        app.start();
    }

    private void start() {
        LottoCount count = getCountByMoney();
        List<String> manualLottoNumbers = getManualLottoNumbers(count);
        printer.printNumberOfLottoTickets(count);
        Lottos lottos = Lottos.createLottos(manualLottoNumbers, count);
        printer.printLottos(lottos);
        WinningLotto winningLotto = getWinningLotto();
        ProfitResult result = winningLotto.getResult(lottos);
        printer.printLottoProfit(result);
        printer.printIsLottoProfit(result.isProfit());
    }

    private List<String> getManualLottoNumbers(LottoCount count) {
        List<String> manualLottoNumbers = new ArrayList<>();
        if (count.hasManualLottoCount()) {
            manualLottoNumbers.addAll(receiver.receiveManualLottoNumbers(count));
        }
        return manualLottoNumbers;
    }

    private LottoCount getCountByMoney() {
        int inputMoney = receiver.receiveMoney();
        Money money = new Money(inputMoney);
        return money.getLottoCount(receiver.receiveManualNumberOfLottoTickets());
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = Lotto.of(receiver.receiveWinningLottoNumbers());
        LottoNumber bonusBall = LottoNumber.of(receiver.receiveBonusBall());
        return new WinningLotto(winningLotto, bonusBall);
    }
}