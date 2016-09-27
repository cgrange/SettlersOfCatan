package shared.model.map;

import shared.locations.HexLocation;

import java.util.ArrayList;
import java.util.List;

import shared.exceptions.CannotMoveException;

/**
 * Represents the maps' robber
 *
 */
public class Robber {
	private HexLocation location;
	private HexLocation previousLocation;

	/**
	 * moves the robber to the player's desired location
	 * @exception CannotMoveException returned if newLocation is invalid
	 * @param newLocation the location to move the robber
	 */
	public void move(HexLocation newLocation) throws CannotMoveException
	{
		previousLocation = location;
		location = newLocation;
			
	}

	public HexLocation getLocation(){
		return location;
	}
	
	/**
	 * checks if robber has been in a location
	 * @param hLocation location to check
	 * @return true if the location hasn't been used
	 */
	public boolean checkPreviousLocation(HexLocation hLocation){
		return !previousLocation.equals(hLocation);
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
