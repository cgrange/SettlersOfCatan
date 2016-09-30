package shared.model.players;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

import shared.definitions.CatanColor;
import shared.model.*;
import shared.model.devcard.DevCardHand;
import shared.model.players.Player;
import shared.model.resources.Bank;

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
  
  @Test
  public void testDeserialization(){
		try {
			Player player = new Player("{ \"resources\": { \"brick\": 0, \"wood\": 1, \"sheep\": 1, \"wheat\": 1, \"ore\": 0 }, \"oldDevCards\": { \"yearOfPlenty\": 0, \"monopoly\": 0, \"soldier\": 0, \"roadBuilding\": 0, \"monument\": 0 }, \"newDevCards\": { \"yearOfPlenty\": 0, \"monopoly\": 0, \"soldier\": 0, \"roadBuilding\": 0, \"monument\": 0 }, \"roads\": 13, \"cities\": 4, \"settlements\": 3, \"soldiers\": 0, \"victoryPoints\": 2, \"monuments\": 0, \"playedDevCard\": false, \"discarded\": false, \"playerID\": 0, \"playerIndex\": 0, \"name\": \"Sam\", \"color\": \"orange\" }");
			assertEquals(player.getColor(), CatanColor.ORANGE); 
			assertTrue(player.getName().equals("Sam"));
			//assertEquals(player.getNumberOfCities(),4);
			assertEquals(player.getNumberOfMonuments(),0);
			//assertEquals(player.getNumberOfRoads(),13);
			//assertEquals(player.getNumberOfSettlements(),3);
			assertEquals(player.getNumberOfSoldiers(),0);
			assertEquals(player.getPoints(),2);
			assertEquals(player.getPlayerIndex(),0);
			assertEquals(player.getPlayerID(),0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertEquals(1,2);
		}
  }

}