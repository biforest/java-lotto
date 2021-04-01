package Domain;

import UI.Printer;
import UI.Receiver;

public class Application {
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final TicketBooth ticketBooth = new TicketBooth();
    private Lottos lottos;

    public void run(){
        printer.requestPrice();
        lottos = ticketBooth.issueTicket(receiver.receiveLine());

    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();

    }
}
