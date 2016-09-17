package shared.model.map;

import shared.definitions.HexType;
import shared.locations.HexLocation;

public class Hex {
	private HexLocation location;
	private int chit;
	private HexType hexType;
	
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
	 * @return false if a desert, or if the robber is already here
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