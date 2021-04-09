package lotto.domain.factory;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.ArrayList;
import java.util.List;
public class Issuer {
    private static final int TICKET_PRICE = 1000;
    private static final int MINIMUM_NUMBER_OF_TICKETS = 1;
    private static final String MONEY_AMOUNT_EXCEPTION_MESSAGE = "금액은 " + TICKET_PRICE + "원 이상으로 입력해주세요.";

    public static LottoTickets issueManualLottoTickets(int manualTicketCount, List<List<Integer>> manualLottoTicketNumbers){
        validate(manualTicketCount);
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for(int i = 0; i <manualTicketCount; i++) {
            manualLottoTickets.add(new LottoTicket(manualLottoTicketNumbers.get(i)));
        }
        return new LottoTickets(manualLottoTickets);
    }

    public static LottoTickets issueLottoTickets(int money, int manualTicketCount) {
        int numberOfTickets = (money / TICKET_PRICE)-manualTicketCount;
        validate(numberOfTickets);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }
    private static void validate(int numberOfTickets) {
        if (numberOfTickets < MINIMUM_NUMBER_OF_TICKETS) {
            throw new IllegalArgumentException(MONEY_AMOUNT_EXCEPTION_MESSAGE);
        }
    }
}