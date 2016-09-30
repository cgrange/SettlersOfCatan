package shared.model.map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.exceptions.CannotCollectResourcesException;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import shared.model.players.Player;

public abstract class VertexObject {
	private int ownerIndex;
	private VertexLocation location;
	
	public VertexObject(String jsonString) throws Exception{
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonObject jObj = jsonParser.parse(jsonString).getAsJsonObject();
		
		ownerIndex = jObj.get("owner").getAsInt();
		
		JsonElement jElement = jObj.get("location");
		String locationStr = gson.toJson(jElement);
		location = new VertexLocation(locationStr);
	}

	public Player getOwner() {
		return Player.get(ownerIndex);
	}
	public VertexObject(int ownerIndex, VertexLocation location){
		this.ownerIndex = ownerIndex;
		this.location = location;
	}

	public int getOwnerIndex() {
		return ownerIndex;
	}

	public VertexLocation getLocation() {
		return location;
	}

	/**
	 * Gets the resources from the given location
	 * @exception CannotCollectResourcesException if the resources are being blocked off by outside source
	 * @param location the location to get resources from
	 */
	public void collectResources(HexLocation location) throws CannotCollectResourcesException
	{

	}

	/**
	 * Returns a serialized version of the object
	 * @return a json string
	 */
	public String serialize()
	{
		return "";
	}

	/**
	 * Checks whether a city or settlement
	 * @return 1 if settlement, 2 if city
	 */
	public abstract int getPointValue();

}
