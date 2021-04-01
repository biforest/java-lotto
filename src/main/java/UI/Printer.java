package UI;

import Domain.Lotto;
import Domain.Lottos;

public class Printer {
    private static final String PRICE_REQUEST_MESSAGE = ("구입금액을 입력해 주세요.");
    private static final String TICKET_COUNT_MESSAGE = ("개를 구매했습니다.");

    public void requestPrice(){
        System.out.println(PRICE_REQUEST_MESSAGE);
    }

    public void printTicketCount(int count){
        System.out.println(count + TICKET_COUNT_MESSAGE);
    }

    public void printLottoNumber(Lotto lotto){
        System.out.println(lotto.getLottoNumber());
    }
}
