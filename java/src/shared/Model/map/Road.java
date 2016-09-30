package shared.model.map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.locations.EdgeLocation;
import shared.model.players.Player;

/**
 * A class representing a road
 *
 */
public class Road {
	
	  private Player owner;
	  private EdgeLocation location;
	
	public Road(String jsonString) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(jsonString).getAsJsonObject();
		int playerID = jsonObj.get("owner").getAsInt();
		owner = Player.get(playerID);
		try {
			location = new EdgeLocation(jsonString);
		} catch (Exception e) {
			// TODO system.exit(1)?
			e.printStackTrace();
		}
	}

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  public EdgeLocation getLocation() {
    return location;
  }

  public void setLocation(EdgeLocation location) {
    this.location = location;
  }
  /**
   * Serializes the road
   * @return a json string
   */
  public String serialize()
  {
    return "";
  }
}
