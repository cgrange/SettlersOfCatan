package shared.model.players;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.definitions.Status;
import shared.model.players.Player;
import shared.model.players.TurnTracker;

public class TurnTrackerTest {

	@Test
	public void test() {
		try {
			TurnTracker turnTracker = new TurnTracker("{ \"status\": \"Rolling\", \"currentTurn\": 0, \"longestRoad\": -1, \"largestArmy\": -1 }");
			assertTrue(turnTracker.getStatus() == Status.ROLLING);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertTrue(1==2);
		}
	}

}
