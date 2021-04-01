package lotto.ui;

import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.Lottos;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해주세요";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }
    public void requestLastWeekLottoWinningNumber() {
        System.out.println(REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE);
    }
    public void requestLottoBonusBallNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE);
    }
    public void printAllLotto(Lottos lottos){
        for (LottoTicket lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }
}

