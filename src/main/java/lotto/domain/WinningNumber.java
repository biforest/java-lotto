package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private static final String BONUS_NUMBER_EXCEPTION_MESSAGE = "보너스 번호는 당첨 번호와 다른 번호여야 합니다.";

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());

        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
