package lotto.domain.lastweekwinninglotto;

import lotto.domain.exception.NotValidLottoLengthException;
import lotto.domain.lottoticket.Lotto;

import java.util.List;

public class LastWeekWinningLotto implements Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> winningLotto;

    public LastWeekWinningLotto(List<Integer> winningLotto){
        checkLottoLength(winningLotto);
        this.winningLotto = winningLotto;
    }

    private void checkLottoLength(List<Integer> numbers){
        if(numbers.size() !=LOTTO_NUMBER_COUNT){
            throw new NotValidLottoLengthException();
        }
    }

    @Override
    public List<Integer> getLotto(){
        return this.winningLotto;
    }
}
