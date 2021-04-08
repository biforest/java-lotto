package lotto.domain;

import lotto.domain.lotto.*;
import lotto.domain.strategy.RandomLottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final static int LOTTO_SIZE = 6;
    private final static int WINNING_LOTTO_WITH_BONUS_BALL_MATCHED_COUNT = 5;

    private final RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
    private final ArrayList<WinningStatus> lottoPrices = new ArrayList<>();

    public LottoAutomaticTickets generateLottoAutomaticTicket(NumberOfLottoTicket numberOfLottoTicket) {
        int numberOfLottoAutomaticTicket = numberOfLottoTicket.getAutomaticLottoTicketOfNumber();
        List<LottoAutomaticTicket> lottoAutomaticTicket = IntStream.range(0, numberOfLottoAutomaticTicket).
                mapToObj(lottoTicket -> new LottoAutomaticTicket(randomLottoNumberGenerator.getRandomLottoNumbers())).
                collect(Collectors.toList());
        return new LottoAutomaticTickets(lottoAutomaticTicket);
    }

    public List<LottoMatchStatus> lottoManualTicketsDiscriminator(
            LottoManualTickets lottoManualTickets,
            LastWeekWinningLotto lastWeekWinningLotto,
            LastWeekWinningBonusBall lastWeekWinningBonusBall) {
        List<LottoMatchStatus> lottoMatchStatuses = new ArrayList<>();

        for (LottoManualTicket lottoManualTicket : lottoManualTickets.getLottoManualTickets()) {
            int matchedLottoManualTicketCount = calculateMatchedLottoManualTicket(lottoManualTicket, lastWeekWinningLotto);
            Boolean isMatchedBonusBall = calculateMatchedBonusBallManualTicket(lottoManualTicket, lastWeekWinningBonusBall);
            LottoMatchStatus lottoMatchStatus = new LottoMatchStatus(matchedLottoManualTicketCount, isMatchedBonusBall);
            lottoMatchStatuses.add(lottoMatchStatus);
        }
        return lottoMatchStatuses;
    }

    public List<LottoMatchStatus> lottoAutomaticTicketsDiscriminator(
            LottoAutomaticTickets lottoAutomaticTickets,
            LastWeekWinningLotto lastWeekWinningLotto,
            LastWeekWinningBonusBall lastWeekWinningBonusBall) {
        List<LottoMatchStatus> lottoMatchStatuses = new ArrayList<>();

        for (LottoAutomaticTicket lottoAutomaticTicket : lottoAutomaticTickets.getLottoAutomaticTickets()) {
            int matchedLottoAutomaticTicketCount = calculateMatchedLottoAutomaticTicket(lottoAutomaticTicket, lastWeekWinningLotto);
            Boolean isMatchedBonusBall = calculateMatchedBonusBallAutomaticTicket(lottoAutomaticTicket, lastWeekWinningBonusBall);
            LottoMatchStatus lottoMatchStatus = new LottoMatchStatus(matchedLottoAutomaticTicketCount, isMatchedBonusBall);
            lottoMatchStatuses.add(lottoMatchStatus);
        }
        return lottoMatchStatuses;
    }

    private Boolean calculateMatchedBonusBallAutomaticTicket(
            LottoAutomaticTicket lottoAutomaticTicket,
            LastWeekWinningBonusBall lastWeekWinningBonusBall) {

        List<Integer> lottoTicket = lottoAutomaticTicket.getLotto();
        int WinningBonusBalls = lastWeekWinningBonusBall.getLastWeekWinningBonusBall();
        return lottoTicket.contains(WinningBonusBalls);
    }

    private int calculateMatchedLottoAutomaticTicket(
            LottoAutomaticTicket lottoAutomaticTicket,
            LastWeekWinningLotto lastWeekWinningLotto) {

        List<Integer> lottoTicket = lottoAutomaticTicket.getLotto();
        List<Integer> lastWeekWinningLottoTicket = lastWeekWinningLotto.getLotto();
        int matchedCount = 0;
        for (int lottoNumber = 0; lottoNumber < LOTTO_SIZE; lottoNumber++) {
            Boolean isMatchLottoNumber = lottoTicket.contains(lastWeekWinningLottoTicket.get(lottoNumber));
            matchedCount += countMatchedLottoNumber(isMatchLottoNumber);
        }
        return matchedCount;

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

    public List<WinningStatus> getStatistics(List<LottoMatchStatus> lottoAllTicketMatchStatuses) {
        for (LottoMatchStatus lottoMatchStatus : lottoAllTicketMatchStatuses) {
            mappingLottoTicketWithBonusBall(lottoMatchStatus);
        }
        return lottoPrices;
    }

    private void mappingLottoTicketWithBonusBall(LottoMatchStatus lottoMatchStatus) {
        for (WinningStatus winningStatus : WinningStatus.values()) {
            compareWinningStatus(winningStatus, lottoMatchStatus.getMatchedCount(), lottoMatchStatus.getHasBonusBall());
        }
    }

    private void compareWinningStatus(WinningStatus winningStatus, int lottoMatchedCount, Boolean hasBonusBall) {
        if ((winningStatus.getMatchCount() == lottoMatchedCount) && (lottoMatchedCount != WINNING_LOTTO_WITH_BONUS_BALL_MATCHED_COUNT)) {
            lottoPrices.add(winningStatus);
        }
        if ((winningStatus.hasBonusBall() == hasBonusBall) && (lottoMatchedCount == WINNING_LOTTO_WITH_BONUS_BALL_MATCHED_COUNT)) {
            lottoPrices.add(winningStatus);
        }
    }

    public Map<WinningStatus, Integer> getMappingLottoWithBonusBall() {
        Map<WinningStatus, Integer> mappingLottoWithBonusBall = new HashMap<>();

        for (WinningStatus key : lottoPrices) {
            mappingLottoWithBonusBall.put(key, mappingLottoWithBonusBall.getOrDefault(key, 0) + 1);
        }
        return mappingLottoWithBonusBall;
    }

    public Profit getProfitInformation(List<WinningStatus> lottoStatistics, NumberOfLottoTicket numberOfLottoTicket) {
        return new Profit(lottoStatistics, numberOfLottoTicket);
    }
}
