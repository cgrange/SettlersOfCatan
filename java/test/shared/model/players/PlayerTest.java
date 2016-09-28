package shared.model.players;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.*;

import shared.definitions.CatanColor;
import shared.model.*;

public class PlayerTest {

  // Helper methods
  public void setupModel(Player newPlayer) {
    Model m = Model.get();

    ArrayList<Player> players = new ArrayList<Player>();
    players.add(newPlayer);
    m.setPlayers(players);
  }
  public void setCurrentPlayerInModel(Player currentPlayer) {
    Model m = Model.get();

    if (m.getTurnTracker() == null) {
      m.setTurnTracker(new TurnTracker());
    }
    m.getTurnTracker().setCurrentPlayer(currentPlayer);
  }

  @Test
  public void getPlayerID() {
    Player testPlayer = new Player(CatanColor.BLUE, "Bob", 0);
    testPlayer.setPlayerID(1);

    assertEquals(1, testPlayer.getPlayerID());
  }

  @Test
  public void getCurrentPlayer() {
    Player newPlayer = new Player(CatanColor.BLUE, "Bob", 0);

    setupModel(newPlayer);
    setCurrentPlayerInModel(newPlayer);

    assertNotNull(Player.getCurrentPlayer());
    assertEquals(newPlayer, Player.getCurrentPlayer());
  }

}