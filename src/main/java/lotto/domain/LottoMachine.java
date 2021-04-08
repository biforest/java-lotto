package lotto.domain;

import lotto.domain.lotto.LottoAutomaticTicket;
import lotto.domain.lotto.LottoAutomaticTickets;
import lotto.domain.strategy.RandomLottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();

    public LottoAutomaticTickets generateLottoAutomaticTicket(NumberOfLottoTicket numberOfLottoTicket) {
        int numberOfLottoAutomaticTicket = numberOfLottoTicket.getAutomaticLottoTicketOfNumber();
        List<LottoAutomaticTicket> lottoAutomaticTicket = IntStream.range(0, numberOfLottoAutomaticTicket).
                mapToObj(lottoTicket -> new LottoAutomaticTicket(randomLottoNumberGenerator.getRandomLottoNumbers())).
                collect(Collectors.toList());
        return new LottoAutomaticTickets(lottoAutomaticTicket);
    }
}
