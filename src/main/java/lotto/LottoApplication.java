package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.lastweekwinninglotto.LastWeekWinningBonusBall;
import lotto.domain.lastweekwinninglotto.LastWeekWinningLotto;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.Lottos;
import lotto.domain.lottoticket.NumberOfLottoTicket;
import lotto.domain.strategy.RandomLottoNumberStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoApplication {
    Scanner scanner = new Scanner(System.in);
    private static RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy();
    private static LottoMachine lottoMachine = new LottoMachine();
    public void run(){
        ArrayList<LottoTicket> lottoDummy = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        NumberOfLottoTicket numberOfLottoTicket = new NumberOfLottoTicket(money);
        System.out.println(numberOfLottoTicket.getNumberOfLottoTicket());
        for (int i = 0; i < numberOfLottoTicket.getNumberOfLottoTicket(); i++) {
            LottoTicket lotto = new LottoTicket(randomLottoNumberStrategy.getRandomLottoNumbers());
            lottoDummy.add(lotto);
        }
        Lottos lottos = new Lottos(lottoDummy);
        for (LottoTicket lotto : lottos.getLottos())
        {
            System.out.println(lotto.getLotto());
        }
        System.out.println("지난 주 당첨번호를 적어주세요");
        String winningLottoNumbers = scanner.next();
        List<String> winningLotto = Arrays.asList(winningLottoNumbers.split(","));
        List<Integer> winningLottoNumber = winningLotto.stream().map(Integer::parseInt).collect(Collectors.toList());

        LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLottoNumber);

        System.out.println("보너스 볼을 입력해주세요");
        int bonusBall = scanner.nextInt();
        LastWeekWinningBonusBall lastWeekWinningBonusBall = new LastWeekWinningBonusBall(bonusBall);
        lottoMachine.Discriminator(lottos, lastWeekWinningLotto, lastWeekWinningBonusBall);
    }

    public static void main(String[] args) {
        LottoApplication app = new LottoApplication();
        app.run();
    }
}

