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

  @Test
  public void getAmount() {
    DevCard card = new DevCard(DevCardType.SOLDIER);

    assertEquals(0, card.getAmount());
  }

  @Test
  public void setAmount() {
    DevCard card = new DevCard(DevCardType.SOLDIER);

    assertEquals(0, card.getAmount());
    card.setAmount(1);
    assertEquals(1, card.getAmount());
  }

  // @Test
  // public void canPlay() {
  //   DevCard card = new DevCard(DevCardType.SOLDIER);

  //   assertEquals(DevCardType.SOLDIER, card.getType());
  // }

  // @Test
  // public void play() {

  //   DevCard card = new DevCard(DevCardType.SOLDIER);

  //   assertEquals(DevCardType.SOLDIER, card.getType());
  // }
}