package lotto.ui;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_MANUAL_TICKET_NUMBER_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_LOTTO_MANUAL_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void requestLottoManualTicketNumber() {
        System.out.println(REQUEST_LOTTO_MANUAL_TICKET_NUMBER_MESSAGE);
    }

    public void requestLottoManualTicket() {
        System.out.println(REQUEST_LOTTO_MANUAL_TICKET_MESSAGE);
    }

}
