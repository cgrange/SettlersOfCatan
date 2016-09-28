package shared.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import shared.definitions.DevCardType;
import shared.model.devcard.*;

public class ModelTest {

  @Test
  public void getRandomDevCard() {
    Model m = Model.get();
    DevCardHand hand = new DevCardHand();
    hand.setAmount(DevCardType.MONOPOLY, 1);

    m.setCentralDevCardHand(hand);

    DevCard randomCard = Model.get().getRandomDevCard();

    assertEquals(0, hand.getNumberOf(DevCardType.MONOPOLY));
    assertEquals(DevCardType.MONOPOLY, randomCard.getType());
  }
}