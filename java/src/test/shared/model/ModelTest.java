package shared.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import shared.model.*;
import shared.model.players.Player;


public class ModelTest {
  @Test
  public void calculatePoints() {

    Player testPlayer = Player.getCurrentPlayer();

    testPlayer.setNumberOfSettlements(3);

    assertEquals(3, Model.get().calculatePoints(testPlayer));


  }
}