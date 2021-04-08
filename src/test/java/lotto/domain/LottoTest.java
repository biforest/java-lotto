package lotto.domain;

import lotto.domain.exception.NotDuplicatedNumberException;
import lotto.domain.exception.NotValidLottoLengthException;
import lotto.domain.lotto.LottoAutomaticTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private LottoAutomaticTicket lottoAutomaticTicket;

    @BeforeEach
    void setup() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6,7,8,9,10,11));
        lottoAutomaticTicket = new LottoAutomaticTicket(numbers);
    }

    @Test
    void 로또_객체를_생성한다(){
        //given
        List<Integer> actual = new ArrayList<>(Arrays.asList(6,7,8,9,10,11));


        //when
        List<Integer> expected = lottoAutomaticTicket.getLotto();
        System.out.println(expected);
        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 로또_숫자가_6개를_초과할_경우_NotValidLottoLengthException을_던진다(){
        //given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6,7,8,9,10,11,12));

        //when
        //then
        assertThatExceptionOfType(NotValidLottoLengthException.class).
                isThrownBy(() -> new LottoAutomaticTicket(numbers));
    }
    @Test
    void 로또_숫자가_6개_미만일_경우_NotValidLottoLengthException을_던진다(){
        //given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6,7,8,9,10));

        //when
        //then
        assertThatExceptionOfType(NotValidLottoLengthException.class).
                isThrownBy(() -> new LottoAutomaticTicket(numbers));
    }

    @Test
    void 로또_숫자가_6개일때_겹치는_숫자가_있을_경우_NotDuplicatedNumberException_을_던진다() {
        //given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6,6,7,8,9,10));

        //when
        //then
        assertThatExceptionOfType(NotDuplicatedNumberException.class).
                isThrownBy(() -> new LottoAutomaticTicket(numbers));
    }
}