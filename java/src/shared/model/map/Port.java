package shared.model.map;

import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;

public class Port {
	private int resourcesRequired;
	private ResourceType resourceType;
	private EdgeLocation location;

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
