package shared.model.map;

import shared.definitions.HexType;
import shared.locations.HexLocation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Hex {
	private HexLocation location;
	private int chit;
	private HexType hexType;
	
	public Hex(String jsonString) throws Exception{
		Gson gson = new Gson();
		
		JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        chit = jsonObject.get("number").getAsInt();
		
		JsonElement locationElement = jsonObject.get("location");
		String locationJsonString = gson.toJson(locationElement);
		location = new HexLocation(locationJsonString);
			
		String resource = jsonObject.get("resource").getAsString();
		
		if(resource.equalsIgnoreCase("brick")){
			hexType = HexType.BRICK;
		}
		else if(resource.equalsIgnoreCase("ore")){
			hexType = HexType.ORE;
		}
		else if(resource.equalsIgnoreCase("wheat")){
			hexType = HexType.WHEAT;
		}
		else if(resource.equalsIgnoreCase("desert")){
			hexType = HexType.DESERT;
		}
		else if(resource.equalsIgnoreCase("wood")){
			hexType = HexType.WOOD;
		}
		else if(resource.equalsIgnoreCase("sheep")){
			hexType = HexType.SHEEP;
		}
		else {
			throw new Exception("the resource is not one of the 6 approved resources");
		}
		
	}

	public HexLocation getLocation() {
		return location;
	}

	public int getChit() {
		return chit;
	}

	public HexType getHexType() {
		return hexType;
	}

	/**
	 * Checks whether the robber can be placed here
	 * @return false if the robber is already here
	 */
	public boolean canPlaceRobber()
	{
		return false;
	}

	/**
	 * serializes the hex
	 * @return the hex
	 */
	public String serialize()
	{
		return "";
	}

}
