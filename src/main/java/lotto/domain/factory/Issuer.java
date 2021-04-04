package lotto.domain.factory;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Issuer {
    private static final int TICKET_PRICE = 1000;
    private static final int MINIMUM_NUMBER_OF_TICKETS = 1;

    private static final String MONEY_AMOUNT_EXCEPTION_MESSAGE = "금액은 " + TICKET_PRICE + "원 이상으로 입력해주세요.";

    public static LottoTickets issueLottoTickets(int money) {
        int numberOfTickets = money / TICKET_PRICE;
        validate(numberOfTickets);

        return new LottoTickets(
                IntStream.range(0, numberOfTickets)
                        .mapToObj(__ -> new LottoTicket())
                        .collect(Collectors.toList())
        );
    }

    private static void validate(int numberOfTickets) {
        if (numberOfTickets < MINIMUM_NUMBER_OF_TICKETS) {
            throw new IllegalArgumentException(MONEY_AMOUNT_EXCEPTION_MESSAGE);
        }
    }
}
