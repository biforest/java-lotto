package lotto.domain.lotto;

import java.util.List;

public class LastWeekWinningLotto extends Lotto{
    private final List<Integer> winningLotto;

    public LastWeekWinningLotto(List<Integer> winningLotto) {
        super(winningLotto);
        this.winningLotto = winningLotto;
    }

    public List<Integer> getLotto(){
        return winningLotto;
    }

}
