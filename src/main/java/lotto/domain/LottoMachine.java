package lotto.domain;

import lotto.domain.lotto.*;
import lotto.domain.strategy.RandomLottoNumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final static int LOTTO_SIZE = 6;
    private final RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();

    public LottoAutomaticTickets generateLottoAutomaticTicket(NumberOfLottoTicket numberOfLottoTicket) {
        int numberOfLottoAutomaticTicket = numberOfLottoTicket.getAutomaticLottoTicketOfNumber();
        List<LottoAutomaticTicket> lottoAutomaticTicket = IntStream.range(0, numberOfLottoAutomaticTicket).
                mapToObj(lottoTicket -> new LottoAutomaticTicket(randomLottoNumberGenerator.getRandomLottoNumbers())).
                collect(Collectors.toList());
        return new LottoAutomaticTickets(lottoAutomaticTicket);
    }

    public Map<Integer, Boolean> lottoManualTicketsDiscriminator(
            LottoManualTickets lottoManualTickets,
            LastWeekWinningLotto lastWeekWinningLotto,
            LastWeekWinningBonusBall lastWeekWinningBonusBall) {
        Map<Integer, Boolean> mappingLottoManualTicketsResult = new HashMap<>();

        for (LottoManualTicket lastManualTicket : lottoManualTickets.getLottoManualTickets()) {
            int matchedLottoManualTicketCount = calculateMatchedLottoManualTicket(lastManualTicket, lastWeekWinningLotto);
            Boolean isMatchedBonusBall = calculateMatchedBonusBallManualTicket(lastManualTicket, lastWeekWinningBonusBall);
            mappingLottoManualTicketsResult.put(matchedLottoManualTicketCount, isMatchedBonusBall);
        }
        return mappingLottoManualTicketsResult;
    }

    private Boolean calculateMatchedBonusBallManualTicket(
            LottoManualTicket lottoManualTicket,
            LastWeekWinningBonusBall lastWeekWinningBonusBall) {
        List<Integer> lottoTicket = lottoManualTicket.getLotto();
        int WinningBonusBalls = lastWeekWinningBonusBall.getLastWeekWinningBonusBall();
        return lottoTicket.contains(WinningBonusBalls);
    }

    private int calculateMatchedLottoManualTicket(
            LottoManualTicket lottoManualTicket,
            LastWeekWinningLotto lastWeekWinningLotto) {
        List<Integer> lottoTicket = lottoManualTicket.getLotto();
        List<Integer> lastWeekWinningLottoTicket = lastWeekWinningLotto.getLotto();
        int matchedCount = 0;
        for (int lottoNumber = 0; lottoNumber < LOTTO_SIZE; lottoNumber++) {
            Boolean isMatchLottoNumber = lottoTicket.contains(lastWeekWinningLottoTicket.get(lottoNumber));
            matchedCount += countMatchedLottoNumber(isMatchLottoNumber);
        }
        return matchedCount;
    }

    private int countMatchedLottoNumber(Boolean isMatchLottoNumber) {
        if (isMatchLottoNumber) {
            return 1;
        }
        return 0;
    }

}
