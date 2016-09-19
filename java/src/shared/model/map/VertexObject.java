package shared.model.map;

import shared.exceptions.CannotCollectResourcesException;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import shared.model.players.Player;

public abstract class VertexObject {
	private Player owner;
	private VertexLocation location;

	public Player getOwner() {
		return owner;
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
