package shared.model.map;

import java.util.List;

import map.Road;
import shared.locations.*;
import shared.exceptions.*;

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
	 * @exception CannotBuildRoadException if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addRoad(int playerIndex, EdgeLocation location) throws CannotBuildRoadException
	{

	}

	/**
	 * Adds a settlement
	 * @exception CannotBuildSettlementException if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addSettlement(int playerIndex, VertexLocation location) throws CannotBuildSettlementException
	{

	}

	/**
	 * Adds a City
	 * @exception CannotBuildCityException if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addCity(int playerIndex, VertexLocation location) throws CannotBuildCityException
	{

	}

	/**
	 * Adds a road
	 * @exception CannotBuildRoadException if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 * @return boolean for whether or not the road can be added
	 */
	public boolean canAddRoad(int playerIndex, EdgeLocation location) throws CannotBuildRoadException
	{

		return false;
	}

	/**
	 * Checks to see if the given player can add a city
	 * @exception CannotBuildCityException if playerIndex or location is invalid.
	 * @param playerIndex the player to add
	 * @param location where to add
	 * @return whether or not the city can be added
	 */
	public boolean canAddCity(int playerIndex, VertexLocation location) throws CannotBuildCityException
	{
		return false;
	}

	/**
	 * Checks to see if the given player can add a settlement
	 * @exception CannotBuildSettlementException if playerIndex or location is invalid.
	 * @param playerIndex the player to add
	 * @param location where to add
	 * @return whether or not the settlement can be added
	 */
	public boolean canAddSettlement(int playerIndex, VertexLocation location) throws CannotBuildSettlementException
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
	 * @return boolean whether or not the resources can be harvested
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
