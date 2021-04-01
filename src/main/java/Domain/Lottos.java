package Domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(int lottoTicketCount){
        lottos = new ArrayList<>(lottoTicketCount);
        for(int count = 0; count <lottoTicketCount; count++){
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
