package lotto.domain.lottoticket;

public class NumberOfLottoTicket {
    private final static int LOTTO_PRICE = 1000;
    private final int tickets;

    public NumberOfLottoTicket(int money){
        this.tickets = setNumberOfLottoTickets(money);
    }

    //    naming 바꾸기
    private int setNumberOfLottoTickets(int money) {
        return money / LOTTO_PRICE;
    }

    public int getNumberOfLottoTicket(){
        return this.tickets;
    }
}
