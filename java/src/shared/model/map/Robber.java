package shared.model.map;

import shared.locations.HexLocation;

/**
 * Represents the maps' robber
 *
 */
public class Robber {
	private HexLocation location;
	

	/**
	 * moves the robber to the player's desired location
	 * @exception CannotMove returned if newLocation is invalid
	 */
	public void move(HexLocation newLocation)
	{
		
	}

	public HexLocation getLocation(){
		return location;
	}
	
	/**
	 * serializes the HexLocation
	 * @return a json string
	 */
	public String serialize()
	{
		return "";
	}
}
