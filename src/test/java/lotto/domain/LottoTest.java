package lotto.domain;

import lotto.domain.exception.NotValidLottoLengthException;
import lotto.domain.lottoticket.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {
    @Test
    void 로또_객체를_생성한다(){
        //given
        List<Integer> numbers = List.of(6,7,8,9,10,11);
        List<Integer> actual = List.of(6,7,8,9,10,11);
        LottoTicket lotto = new LottoTicket(numbers);

        //when
        List<Integer> expected = lotto.getLotto();
        System.out.println(expected);
        //then
        assertThat(expected).isEqualTo(actual);
    }
    @Test
    void 로또_숫자가_6개를_초과할_경우_NotValidLottoLengthException을_던진다(){
        //given
        List<Integer> numbers = List.of(6,7,8,9,10,11,12);

        //when
        //then
        assertThatExceptionOfType(NotValidLottoLengthException.class).
                isThrownBy(() -> new LottoTicket(numbers));
    }
    @Test
    void 로또_숫자가_6개_미만일_경우_NotValidLottoLengthException을_던진다(){
        //given
        List<Integer> numbers = List.of(6,7,8,9,10);

        //when
        //then
        assertThatExceptionOfType(NotValidLottoLengthException.class).
                isThrownBy(() -> new LottoTicket(numbers));
    }
}