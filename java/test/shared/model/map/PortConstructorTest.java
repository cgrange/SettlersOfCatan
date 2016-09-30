package shared.model.map;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.definitions.ResourceType;
import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.model.map.Port;

public class PortConstructorTest {

	@Test
	public void test() {
		try {
			Port port = new Port(" {\"resource\":\"whEat\",\"location\":{ \"x\":2, \"y\":2 },\"direction\":\"N\",\"ratio\":2} ");
			assertTrue(port.getOwner() == null);
			assertTrue(port.getEdgeLocation().equals(new EdgeLocation(new HexLocation(2,2), EdgeDirection.getEdgeDirection("N"))));
			assertTrue(port.getResourcesRequired() == 2);
			assertTrue(port.getResourceType() == ResourceType.WHEAT);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(1 == 2);
		}
	}

}
