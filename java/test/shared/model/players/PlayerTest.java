package shared.model.players;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import shared.model.*;
import shared.model.players.Player;


public class PlayerTest {
  @Test
  public void getPlayerID() {

    Player testPlayer = new Player(Player.Color.BLUE, "Bob", 0);
    testPlayer.setPlayerID(1);

    assertEquals(1, testPlayer.getPlayerID());
  }
}