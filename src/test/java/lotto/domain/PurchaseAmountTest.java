package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @Test
    void 로또_구입금액_객체를_생성한다(){
        //given
        int purchaseAmountNumber = 1000;
        int actual = 1000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountNumber);

        //when
        int expected = purchaseAmount.getPurchaseAmount();
        System.out.println(expected);

        //then
        assertThat(expected).isEqualTo(actual);
    }
}