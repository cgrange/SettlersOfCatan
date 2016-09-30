package shared.model.map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;
import shared.model.players.Player;

public class Port {
	private int resourcesRequired;
	private ResourceType resourceType;
	private EdgeLocation edgeLocation;
	private Player owner;
	
	public Port(String jsonString) {
		
		owner = null;
		JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
		resourcesRequired = jsonObject.get("ratio").getAsInt();
		String resourceStr = jsonObject.get("resource").getAsString();
		try {
			resourceType = ResourceType.getResourceType(resourceStr);
		} catch (Exception e) {
			// TODO idk what we wanna do here... system.exit(1)?
			e.printStackTrace();
		}
		String directionString = jsonObject.get("direction").getAsString();
		JsonObject locationObj = jsonObject.get("location").getAsJsonObject();
		Gson gson = new Gson();
		String locationString = gson.toJson(locationObj);
		try {
			edgeLocation = new EdgeLocation(locationString, directionString);
		} catch (Exception e) {
			// TODO same as above
			e.printStackTrace();
		}
		
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public void setEdgeLocation(EdgeLocation edgeLocation)
	{
		this.edgeLocation = edgeLocation;
		return;
	}

	public void setResourceType(ResourceType resourceType){
		this.resourceType = resourceType;
		return;
	}

	public void setResoucesRequired(int resourcesRequired){
		this.resourcesRequired = resourcesRequired;
	}

	public EdgeLocation getEdgeLocation(){
		return edgeLocation;
	}

	public int getResourcesRequired(){
		return resourcesRequired;
	}

	public ResourceType getResourceType(){
		return resourceType;
	}

	/**
	 * Serializes the port
	 * @return a json string
	 */
	private String serialize()
	{
		return "";
	}
}
