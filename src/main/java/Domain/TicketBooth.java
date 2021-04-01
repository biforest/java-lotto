package Domain;

import UI.Printer;

import java.util.ArrayList;
import java.util.List;

public class TicketBooth {
    private static final int LOTTO_PRICE = 1000;
    private int ticketCount;

    public Lottos issueTicket(String price, Printer printer){
        ticketCount = Integer.parseInt(price)/LOTTO_PRICE;
        printer.printTicketCount(ticketCount);
        return new Lottos(ticketCount);
    }

    public void printLottoNumber(Lottos lottos, Printer printer){
        for(int count = 0; count<ticketCount; count++){
            printer.printLottoNumber(lottos.getLottos().get(count));
        }
    }
}
