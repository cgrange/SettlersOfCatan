package shared.model.map;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.definitions.HexType;
import shared.model.map.Hex;
import shared.locations.HexLocation;

public class HexConstructorTest {

	@Test
	public void testConstructor() {
		try{
			Hex hex = new Hex("{ \"location\":{ \"x\":1, \"y\":2 }, \"resource\":\"BrIck\", \"number\":8 }");
			assertTrue(hex.getChit() == 8);
			assertTrue(hex.getLocation().equals(new HexLocation(1, 2)));
			assertTrue(hex.getHexType() == HexType.BRICK);
		}
		catch(Exception e){
			e.printStackTrace();
			assertTrue(1 == 2);
		}
	}

}
