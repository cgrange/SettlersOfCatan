package shared.model.map;

import shared.locations.HexLocation;
import shared.exceptions.CannotMoveException;

/**
 * Represents the maps' robber
 *
 */
public class Robber {
	private HexLocation location;


	/**
	 * moves the robber to the player's desired location
	 * @exception CannotMoveException returned if newLocation is invalid
	 * @param newLocation the location to move the robber
	 */
	public void move(HexLocation newLocation) throws CannotMoveException
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
