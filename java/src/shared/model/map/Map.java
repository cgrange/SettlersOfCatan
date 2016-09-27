package shared.model.map;

import java.util.ArrayList;
import java.util.List;

import shared.model.map.Road;
import shared.model.players.Player;
import shared.locations.*;
import shared.definitions.HexType;
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
	 * @param playerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<Road> getRoadsForPlayer(int playerIndex)
	{
		 List<Road> playerRoads = new ArrayList<Road>();
	        for (int i = 0; i < roads.size(); i++){
	            if (roads.get(i).getOwner().getPlayerIndex() == (playerIndex))
	                    playerRoads.add(roads.get(i));
	        }
	        return playerRoads;
	}

	/**
	 * Gets the objects for the specified player
	 * @param playerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<Settlement> getSettlementsForPlayer(int playerIndex)
	{
		List<Settlement> playerSettlements = new ArrayList<Settlement>();
        for (int i = 0; i < settlements.size(); i++){
            if (settlements.get(i).getOwner().getPlayerIndex() == (playerIndex))
                    playerSettlements.add(settlements.get(i));
        }
        return playerSettlements;
	}

	/**
	 * Gets the objects for the specified player
	 * @param playerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<City> getCitiesForPlayer(int playerIndex)
	{
		List<City> playerCities = new ArrayList<City>();
        for (int i = 0; i < cities.size(); i++){
            if (cities.get(i).getOwner().getPlayerIndex() == (playerIndex))
                    playerCities.add(cities.get(i));
        }
        return playerCities;
	}

	/**
	 * Gets the objects for the specified player
	 * @param playerIndex the player to get the objects for
	 * @return the list of objects
	 */
	public List<Port> getPortsForPlayer(int playerIndex)
	{
		List<Port> playerPorts = new ArrayList<Port>();
        for (int i = 0; i < ports.size(); i++){
            if (ports.get(i).getOwner().getPlayerIndex() == (playerIndex))
                    playerPorts.add(ports.get(i));
        }
        return playerPorts;
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
	 * Gets the object for the specified player and location
	 * @param playerIndex the player to get the object for
	 * @param cLocation the location to get the object for
	 * @return true or false
	 */
	public boolean findSettlementForPlayer(Player player, VertexLocation vLocation)
	{
		List<Settlement> playerSettlements = new ArrayList<Settlement>();
        for (int i = 0; i < settlements.size(); i++){
            if (player.equals(settlements.get(i).getOwner()) && settlements.get(i).getLocation().equals(vLocation)){
                    return true;
            }
        }
        return false;
	}
	
	/**
	 * checks weather a certain hex is a certain type
	 * @param HexLocation the location to check for
	 * @param HexType the type to check for
	 * @return true or false depending on if both parameters hold true
	 */
	public boolean checkHexType(HexLocation hLocation, HexType type){
		for (int i = 0; i <hexes.size(); i++){
			if (hexes.get(i).getLocation().equals(hLocation) && hexes.get(i).getHexType().equals(type)){
				return true;
			}
		}
		return false;
	}

	
	public Robber getRobber() {
		return robber;
	}

	public void setRobber(Robber robber) {
		this.robber = robber;
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
