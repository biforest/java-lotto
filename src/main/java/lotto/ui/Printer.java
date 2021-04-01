package lotto.ui;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public void requestPurchaseAmount(){
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }
    public void requestLastWeekLottoWinningNumber(){
        System.out.println(REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE);
    }
}

