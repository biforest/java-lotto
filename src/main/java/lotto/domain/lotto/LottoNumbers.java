package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final String NUMBER_OF_LOTTO_NUMBERS_MUST_6_EXCEPTION_MESSAGE = "로또 번호는 " + NUMBER_OF_LOTTO_NUMBERS + "자리이어야 합니다.";
    private static final String NUMBER_OF_LOTTO_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 각각 다른 숫자여야만 합니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NUMBER_OF_LOTTO_NUMBERS_MUST_6_EXCEPTION_MESSAGE);
        }

        if (new HashSet<>(lottoNumbers).size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NUMBER_OF_LOTTO_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
