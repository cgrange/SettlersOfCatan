package shared.model.map;

import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;
import shared.model.players.Player;

public class Port {
	private int resourcesRequired;
	private ResourceType resourceType;
	private EdgeLocation location;
	private Player owner;

	
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public void setLocation(EdgeLocation location)
	{
		this.location = location;
		return;
	}

	public void setResourceType(ResourceType resourceType){
		this.resourceType = resourceType;
		return;
	}

	public void setResoucesRequired(int resourcesRequired){
		this.resourcesRequired = resourcesRequired;
	}

	public EdgeLocation getLocation(){
		return location;
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
