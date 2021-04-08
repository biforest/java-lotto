package lotto.ui;

import lotto.domain.NumberOfLottoTicket;
import lotto.domain.lotto.LottoAutomaticTicket;
import lotto.domain.lotto.LottoAutomaticTickets;
import lotto.domain.lotto.LottoManualTicket;
import lotto.domain.lotto.LottoManualTickets;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_MANUAL_TICKET_NUMBER_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_LOTTO_MANUAL_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PRINT_NUMBER_OF_LOTTO_TICKET_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";


    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void requestLottoManualTicketNumber() {
        System.out.println(REQUEST_LOTTO_MANUAL_TICKET_NUMBER_MESSAGE);
    }

    public void requestLottoManualTicket() {
        System.out.println(REQUEST_LOTTO_MANUAL_TICKET_MESSAGE);
    }

    public void printNumberOfEachLottoTicket(NumberOfLottoTicket numberOfLottoTicket) {
        System.out.println(String.format(
                PRINT_NUMBER_OF_LOTTO_TICKET_MESSAGE,
                numberOfLottoTicket.getNumberOfManualLottoTicket(),
                numberOfLottoTicket.getAutomaticLottoTicketOfNumber()
        ));
    }

    public void printLottoAutomaticTickets(LottoAutomaticTickets lottoAutomaticTickets) {
        for (LottoAutomaticTicket lottoAutomaticTicket: lottoAutomaticTickets.getLottoAutomaticTickets()) {
            System.out.println(lottoAutomaticTicket.getLotto());
        }
    }

    public void printLottoManualTickets(LottoManualTickets lottoManualTickets) {
        for (LottoManualTicket lottoManualTicket: lottoManualTickets.getLottoManualTickets()) {
            System.out.println(lottoManualTicket.getLotto());
        }
    }

    public void requestLastWeekLottoWinningNumber() {
        System.out.println(REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE);
    }
}
