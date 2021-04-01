package Domain;

import java.util.ArrayList;
import java.util.List;

public class TicketBooth {
    private int ticketCount;

    public Lottos issueTicket(String price){
        ticketCount = Integer.parseInt(price)/1000;
        return new Lottos(ticketCount);
    }
}
