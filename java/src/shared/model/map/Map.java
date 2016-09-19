package shared.model.map;

import java.util.List;

import map.Road;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

public class Map {
	private List<City> cities;
	private List<Settlement> settlements;
	private List<VertexObject> allVertexObjects;
	private List<Road> roads;
	private List<Port> ports;
	private List<Hex> hexes;
	private Robber robber;
	
	/**
	 * Adds a road
	 * @exception CannotBuildRoad if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addRoad(int playerIndex, EdgeLocation location)
	{
		
	}
	
	/**
	 * Adds a settlement
	 * @exception CannotBuildSettlement if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addSettlement(int playerIndex, VertexLocation location)
	{
		
	}
	
	/**
	 * Adds a City
	 * @exception CannotBuildCity if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addCity(int playerIndex, VertexLocation location)
	{
		
	}
	
	/**
	 * Adds a road
	 * @exception CannotBuildRoad if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public boolean canAddRoad(int playerIndex, EdgeLocation location)
	{
		return false;
	}
	
	/**
	 * Checks to see if the given player can add a city
	 * @exception CannotBuildCity if playerIndex or location is invalid.
	 * @param playerIndex the player to add
	 * @param location where to add
	 * @return
	 */
	public boolean canAddCity(int playerIndex, VertexLocation location)
	{
		return false;
	}
	
	/**
	 * Checks to see if the given player can add a settlement
	 * @exception CannotBuildSettlement if playerIndex or location is invalid.
	 * @param playerIndex the player to add
	 * @param location where to add
	 * @return
	 */
	public boolean canAddSettlement(int playerIndex, VertexLocation location)
	{
		return false;
	}
	
	/**
	 * Gets the objects for the specified player
	 * @param PlayerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<Road> getRoadsForPlayer(int PlayerIndex)
	{
		return null;
	}
	
	/**
	 * Gets the objects for the specified player
	 * @param PlayerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<Settlement> getSettlementsForPlayer(int PlayerIndex)
	{
		return null;
	}
	
	/**
	 * Gets the objects for the specified player
	 * @param PlayerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<City> getCitiesForPlayer(int PlayerIndex)
	{
		return null;
	}
	
	/**
	 * Gets the objects for the specified player
	 * @param PlayerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<Port> getPortsForPlayer(int PlayerIndex)
	{
		return null;
	}
	
	/**
	 * Checks to see if you can harvest resources from a location
	 * @param location the location to check
	 * @return
	 */
	public boolean canHarvestResources(HexLocation location)
	{
		return false;
	}
	
	/**
	 * Gets resources on a die roll
	 * @param dieRoll The number to use
	 */
	public void harvestResources(int dieRoll)
	{
		
	}
	
	/**
	 * Serializes the map
	 * @return a json string
	 */
	public String serialize()
	{
		return "";
	}
}
