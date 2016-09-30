package shared.model.map;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;
import shared.model.map.City;
import shared.model.map.Settlement;
import shared.model.players.Player;

public class CitiesAndSettlementsTest {
	
	@Test
	public void cityTest() {
		try {
			City city = new City(" { \"owner\":1, \"location\":{ \"x\":2, \"y\":2, \"direction\":\"W\" } } ");
			VertexLocation vLocation = new VertexLocation(new HexLocation(2,2), VertexDirection.getVertexDirection("W"));
			assertTrue(city.getLocation().equals(vLocation));
			assertTrue(city.getPointValue() == 2);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(1==2);
		}
	}
	
	@Test
	public void settlementTest() {
		try {
			Settlement settlement = new Settlement(" { \"owner\":2, \"location\":{ \"x\":1, \"y\":1, \"direction\":\"E\" } } ");
			VertexLocation vLocation = new VertexLocation(new HexLocation(1,1), VertexDirection.getVertexDirection("E"));
			assertTrue(settlement.getLocation().equals(vLocation));
			assertTrue(settlement.getPointValue() == 1);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(1==2);
		}
	}

}
