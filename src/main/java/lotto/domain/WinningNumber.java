package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());

        this.bonusNumber = new LottoNumber(bonusNumber);
    }

}
