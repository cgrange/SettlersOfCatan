package shared.model.map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.model.Model;
import shared.locations.EdgeLocation;
import shared.model.players.Player;

/**
 * A class representing a road
 *
 */
public class Road {
	
	  private int ownerIndex;
	  private EdgeLocation location;
	
	public Road(String jsonString) {
//		JsonParser jsonParser = new JsonParser();
//		JsonObject jsonObj = jsonParser.parse(jsonString).getAsJsonObject();
//	//	int playerID = jsonObj.get("owner").getAsInt();
//	//	ownerIndex = Player.get(playerID);
//		try {
//			location = new EdgeLocation(jsonString);
//		} catch (Exception e) {
//			// TODO system.exit(1)?
//			e.printStackTrace();
//		}
//		for (int i = 0; i < Model.get().getPlayers().size(); i++){
//			Player player = Model.get().getPlayers().get(i);
//		//	if (player.getPlayerID() == playerID){
//				ownerIndex = player.getPlayerIndex(); 
//			}
//		}
//		location = new EdgeLocation(jsonString);
	}
	
	public Road(int ownerIndex, EdgeLocation location){
		this.ownerIndex = ownerIndex;
		this.location = location;
	}

  public int getOwnerIndex() {
    return ownerIndex;
  }

  public void setOwnerIndex(int ownerIndex) {
    this.ownerIndex = ownerIndex;
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
