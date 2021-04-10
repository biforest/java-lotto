package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoIssueStrategy implements IssueStrategy {

    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final int numberOfTickets;

    public AutoIssueStrategy(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public List<LottoTicket> issue() {
        List<LottoNumber> lottoNumbers = LottoNumber.range();
        Collections.shuffle(lottoNumbers);

        return IntStream.range(0, numberOfTickets)
                .mapToObj(__ -> makeRandomLottoNumbers(lottoNumbers))
                .map(LottoNumbers::new)
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> makeRandomLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS)
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
    }
}
