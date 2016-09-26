package shared.model.devcard;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import shared.model.*;
import shared.model.devcard.DevCard;

import shared.definitions.DevCardType;

public class DevCardTest {
  @Test
  public void getType() {

    DevCard card = new DevCard(DevCardType.SOLDIER);

    assertEquals(DevCardType.SOLDIER, card.getType());
  }
}