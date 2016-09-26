package shared.locations;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

import shared.locations.HexLocation;

public class HexLocationTest {

  @Test
  public void testConstructor() {
    Gson gson = new Gson();
    HexLocation location = new HexLocation(1, 2);
    String json = gson.toJson(location);
    HexLocation location2 = new HexLocation(json);
    assertTrue(location.equals(location2));
  }

}
