package domain.lastweekwinninglotto;

import domain.lottoticket.Lotto;

import java.util.List;

public class LastWeekWinningLotto implements Lotto {
    private final List<Integer> winningLotto;

    public LastWeekWinningLotto(List<Integer> winningLotto){
        this.winningLotto = winningLotto;
    }

    @Override
    public List<Integer> getLotto(){
        return this.winningLotto;
    }
}