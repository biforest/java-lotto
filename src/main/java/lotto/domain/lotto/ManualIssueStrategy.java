package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualIssueStrategy implements IssueStrategy {

    private final List<LottoNumbers> manualLottoNumbers;

    public ManualIssueStrategy(List<LottoNumbers> manualLottoNumbers) {
        this.manualLottoNumbers = new ArrayList<>(manualLottoNumbers);
    }

    public List<LottoTicket> issue() {
        return manualLottoNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}
