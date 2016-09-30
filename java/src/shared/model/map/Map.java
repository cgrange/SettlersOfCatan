package shared.model.map;

import java.util.ArrayList;
import java.util.List;

import shared.model.map.Road;
import shared.model.players.Player;
import shared.model.players.TurnTracker;
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
			roads.add(new Road(playerIndex, location));
	}

	/**
	 * Adds a settlement
	 * @exception CannotBuildSettlementException if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addSettlement(int playerIndex, VertexLocation location) throws CannotBuildSettlementException
	{
		settlements.add(new Settlement(playerIndex, location));
	}

	/**
	 * Adds a City
	 * @exception CannotBuildCityException if playerIndex or location is invalid.
	 * @param playerIndex the index of the player
	 * @param location the place to add
	 */
	public void addCity(int playerIndex, VertexLocation location) throws CannotBuildCityException
	{
		cities.add(new City(playerIndex, location));
	}

	/**
	 * Adds a road
	 * @exception CannotBuildRoadException if playerIndex or location is invalid.
	 * @param location the place to add
	 * @return boolean for whether or not the road can be added
	 */
	public boolean canAddRoad(int playerIndex, EdgeLocation location) throws CannotBuildRoadException
	{
		return isConnectedToRoad(playerIndex, location);
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
		return !hasNeighbor(playerIndex, location);
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
		return isConnectedToRoad(playerIndex, location);
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
	            if (roads.get(i).getOwnerIndex() == (playerIndex))
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
            if (settlements.get(i).getOwnerIndex() == (playerIndex))
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
            if (cities.get(i).getOwnerIndex() == (playerIndex))
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
            if (player.equals(settlements.get(i).getOwnerIndex()) && settlements.get(i).getLocation().equals(vLocation)){
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
	 * checks weather a edge is touching land
	 * @param eLocation is the location to check
	 * @param HexType the type to check for
	 * @return true or false depending on if edgelocation is on land
	 */
	public boolean isTouchesLand(EdgeLocation eLocation){
		for (int i = 0; i < hexes.size(); i++){
			if (!hexes.get(i).getHexType().equals(HexType.WATER)){
				if (eLocation.getHexLoc().equals(hexes.get(i))){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public Hex getHex(HexLocation hLocation){
		for (int i = 0; i < hexes.size(); i++){
			if (hLocation.equals(hexes.get(i).getLocation())){
				return hexes.get(i);
			}
		}
		return null;
	}
	
	public static boolean checkForConnectedRoad(int roadLength, VertexLocation vLocation){
		//TODO use recursion
		return false;
	}
	
	public boolean existsRoad(int playerIndex, HexLocation hLocation, EdgeDirection eDirection){
		for (int i = 0; i < roads.size(); i++){
			boolean exists = true;
			if (!roads.get(i).getLocation().getNormalizedLocation().getHexLoc().equals(hLocation)){
				exists = false;
			}
			if (roads.get(i).getOwnerIndex() != playerIndex){
				exists = false;
			}
			if (!roads.get(i).getLocation().getNormalizedLocation().getDir().equals(eDirection)){
				exists = false;
			}
			if (exists){
				return true;
			}
		}
		return false;
	}
	
	public boolean existsRoad(int playerIndex, HexLocation hLocation, VertexDirection vDirection){
		for (int i = 0; i <roads.size(); i++){
			boolean exists = true;
			if (!roads.get(i).getLocation().getNormalizedLocation().getHexLoc().equals(hLocation)){
				exists = false;
			}
			if (roads.get(i).getOwnerIndex() != playerIndex){
				exists = false;
			}
			if (!roads.get(i).getLocation().getNormalizedLocation().getDir().equals(vDirection)){
				exists = false;
			}
			if (exists){
				return true;
			}
		}
		return false;
	}
	
	public boolean existsCityOrSettlement(int playerIndex, HexLocation hLocation, VertexDirection vDirection){
		for (int i = 0; i < cities.size(); i++){
			boolean exists = true;
			if (!cities.get(i).getLocation().getNormalizedLocation().getHexLoc().equals(hLocation)){
				exists = false;
			}
			if (!cities.get(i).getLocation().getNormalizedLocation().getDir().equals(vDirection)){
				exists = false;
			}
			if (!settlements.get(i).getLocation().getNormalizedLocation().getHexLoc().equals(hLocation)){
				exists = false;
			}
			if (!settlements.get(i).getLocation().getNormalizedLocation().getDir().equals(vDirection)){
				exists = false;
			}
			if (exists){
				return true;
			}
		}
		return false;
	}
	
	public boolean isConnectedToRoad(int playerIndex, VertexLocation location){
		VertexDirection dir = location.getDir();
		Hex hex = null;
		for (int i = 0; i < hexes.size(); i++){
			if (hexes.get(i).getLocation().equals(location.getHexLoc())){
				hex = hexes.get(i);
			}
		}
		switch (dir) {
		case NorthWest:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthWest), EdgeDirection.NorthEast))
				return true;
			break;
		case NorthEast:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthEast), EdgeDirection.NorthWest))
				return true;
			break;
		case East:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), EdgeDirection.NorthWest))
				return true;
			break;
		case SouthEast:
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.NorthEast))
				return true;
			break;
		case SouthWest:
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.NorthEast))
				return true;
			break;
		case West:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.NorthEast))
				return true;
			break;
		}
		return false;
	}
	
	public boolean isConnectedToRoad(int playerIndex, EdgeLocation location) throws CannotBuildRoadException
	{
		EdgeDirection dir = location.getDir();
		Hex hex = null;
		for (int i = 0; i < hexes.size(); i++){
			if (hexes.get(i).getLocation().equals(location.getHexLoc())){
				hex = hexes.get(i);
			}
		}
		switch (dir) {
		case North: 
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthEast), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthWest), EdgeDirection.NorthEast))
				return true;
			break;
		case NorthWest:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthWest), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.NorthEast))
				return true;
			break;
		case NorthEast:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthEast), EdgeDirection.NorthWest))
				return true;
			break;
		case SouthEast:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), EdgeDirection.North))
				return true;
			break;
		case South:
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.NorthEast))
				return true;
			break;
		case SouthWest:
			if (existsRoad(playerIndex, hex.getLocation(), EdgeDirection.NorthEast))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), EdgeDirection.North))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.NorthWest))
				return true;
			if (existsRoad(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), EdgeDirection.North))
				return true;
			break;
		}
		//must connect to another road belonging to the same player (except first round when player can place two roads anywhere)
		return false;
	}
	
	public boolean hasNeighbor(int playerIndex, VertexLocation location){
		VertexDirection dir = location.getDir();
		Hex hex = null;
		for (int i = 0; i < hexes.size(); i++){
			if (hexes.get(i).getLocation().equals(location.getHexLoc())){
				hex = hexes.get(i);
			}
		}
		switch (dir){
		case SouthEast:
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), VertexDirection.NorthWest))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), VertexDirection.NorthWest))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South).getNeighborLoc(EdgeDirection.SouthEast), VertexDirection.NorthWest))
				return true;
			break;
		case SouthWest:
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), VertexDirection.NorthEast))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), VertexDirection.NorthEast))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South).getNeighborLoc(EdgeDirection.SouthWest), VertexDirection.NorthEast))
				return true;
			break;
		case West:
			if (existsCityOrSettlement(playerIndex, hex.getLocation(), VertexDirection.NorthWest))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), VertexDirection.NorthWest))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.South), VertexDirection.NorthWest))
			break;
		case NorthEast:
			if (existsCityOrSettlement(playerIndex, hex.getLocation(), VertexDirection.NorthWest))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthEast), VertexDirection.NorthWest))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthEast), VertexDirection.NorthWest))
				return true;
			break;
		case NorthWest:
			if (existsCityOrSettlement(playerIndex, hex.getLocation(), VertexDirection.NorthEast))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.SouthWest), VertexDirection.NorthEast))
				return true;
			if (existsCityOrSettlement(playerIndex, hex.getLocation().getNeighborLoc(EdgeDirection.NorthWest), VertexDirection.NorthEast))
				return true;
			break;
		}
		return false;
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
