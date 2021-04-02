package lotto.domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class LottoTicket {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private final List<LottoNumber> lottoNumbers;
    public LottoTicket() {
        List<LottoNumber> lottoNumbers = LottoNumber.range();
        lottoNumbers = generateLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }
    private List<LottoNumber> generateLottoNumbers(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS)
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
        return lottoNumbers;
    }
    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}