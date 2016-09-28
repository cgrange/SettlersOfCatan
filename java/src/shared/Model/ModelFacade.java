package shared.model;

import shared.model.Model;
import shared.locations.HexLocation;
import shared.model.map.City;
import shared.model.map.Map;
import shared.model.map.Settlement;
import shared.model.players.Player;
import shared.model.resources.Bank;
import shared.locations.VertexLocation;
import shared.model.map.Robber;
import shared.definitions.DevCardType;
import shared.definitions.HexType;
import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;
import shared.model.devcard.DevCard;
import shared.model.resources.Resource;
import java.util.ArrayList;
import java.util.List;

public class ModelFacade {
	/**
	 * @param vLocation the vertex location that the player wants to build on
	 * @return a boolean specifying whether or not the player can build a city at that vertex location
	 */
	
	private static Map gameMap;
	private static Player player;
	private static Bank playerBank;
	private static Robber robber;
	public static boolean canBuildCity(VertexLocation vLocation){
		updateCurrentObjects();
		if (!playerBank.canBuildCity()){
			return false;
		}
		if (!gameMap.findSettlementForPlayer(player, vLocation)){
			return false;
		}
		return true;
	}
	/**
	 * @param vLocation the vertex location that the player wants to build in
	 */
	public static void buildCity(VertexLocation vLocation){
		//TODO implement
		//how do I know who the player is?
	}
	/**
	 * @param eLocation the edge location that the player wants to build on
	 * @return a boolean specifying whether or not the player can build a road at that edge location
	 */
	public static boolean canBuildRoad(EdgeLocation eLocation){
		updateCurrentObjects();
		if (player.getNumberOfRoads() == 0){
			return false;
		}
		if (!playerBank.canBuildRoad()){
			return false;
		}
		if (!inBetweenHex(eLocation)){
			return false;
		}
		return true;
	}
	/**
	 * @param eLocation edge location where the road is to be built
	 */
	public static void buildRoad(EdgeLocation eLocation){
		//TODO implement
		//remember to calculate the longest road
	}
	/**
	 * @param vLocation the vertexLocation where the player wants to build
	 * @return a boolean specifying whether or not the player can build a settlement at that vertex location
	 */
	public static boolean canBuildSettlement(VertexLocation vLocation){
		updateCurrentObjects();
		if (player.getNumberOfSettlements() == 0){
			return false;
		}
		if (!playerBank.canBuildSettlement()){
			return false;
		}
		if (!checkForConnectedRoad(2, vLocation)){
			return false;
		}
		return true;
	}
	/**
	 * @param vLocation the vertexLocation where the player wants to build
	 */
	public static void buildSettlement(VertexLocation vLocation){
		//TODO implement
		//give the player points
	}
	/**
	 * @param devCard the development card that the player wants to play
	 * @return a boolean specifying whether or not the player can play that devCard
	 */
	public static boolean canPlayDevCard(DevCard devCard){
		//TODO implement
		updateCurrentObjects();
		if (player.hasPlayedDevCard()){
			return false;
		}
		//TODO john check players bank to see if the devCard was just bought  ex. playerBank.justBought(devCard) 
		//I need a bank or player function that knows if the card was just picked up
		if (devCard.getType().equals(DevCardType.SOLDIER)){
			//check if can rob
		}
		
		return false;
	}
	/**
	 * @param devCard the devCard that the player wants to play
	 */
	public static void playDevCard(DevCard devCard){
		devCard.play();
	}
	/**
	 * @return a boolean specifying whether or not the player can draw a dev card
	 */
	public static boolean canDrawDevCard(){
		//TODO implement
		updateCurrentObjects();
		return playerBank.canDrawDevCard();
	}
	public static void drawDevCard(){
		//TODO add removeDevCardResources needs an exception
		//TODO add method that picks up new random dev card in player
		updateCurrentObjects();
	//	playerBank.removeDevCardResources();
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @return a boolean specifying whether or not the player can trade at that port
	 */
	public static boolean canTradeAtPort(EdgeLocation eLocation){
		//TODO implement
		//does the player reside on the port. Check
		return false;
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @param receive the resource that the player wants to receive for her trade
	 */
	public static void tradeAtPort(EdgeLocation eLocation, Resource receive){
		//TODO implement
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @param give the resource that the player wants to give for her trade
	 * @return a boolean specifying whether or not the player can trade at that port
	 */
	public static boolean canTradeAtPort(EdgeLocation eLocation, Resource give){
		//TODO implement
		//does the player reside on the port. Check
		return false;
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @param give the resource that the player wants to give for her trade
	 * @param receive the resource that the player wants to receive for her trade
	 */
	public static void tradeAtPort(EdgeLocation eLocation, Resource give, Resource receive){
		//TODO implement
		//does the player reside on the port. Check
	}
	/**
	 * @param location the location that the player wants to move the robber to
	 * @return a boolean specifying whether or not the player can move the robber to that location
	 */
	public static boolean canUseRobber(HexLocation location){
		updateCurrentObjects();
		if (!robber.checkPreviousLocation(location)){
			return false;
		}
		if (gameMap.checkHexType(location, HexType.WATER)){
			return false;
		}
		return false;
	}
	/**
	 * @param location the location that the player wants to move the robber to
	 * @param player the player that the current player wants to take a resource from
	 * @param resource the resource that the current player wants to take from another player
	 */
	public static void useRobber(HexLocation location, Player player, Resource resource){
		//TODO implement
	}
	/**
	 * @return a boolean specifying whether or not the player is affected by the robber being used
	 */
	public static boolean canGetPlundered(){
		//TODO implement
		//if player has 8 or more cards
		return false;
	}
	/**
	 * @param toDiscard the resources that the player chooses to discard should they be affected by the robber
	 */
	public static void getPlundered(Bank toDiscard){
		//TODO implement
		//remember to round down
	}
	/**
	 * @param location the hex location that the robber has been moved to
	 * @param playerToRob player that is going to get robbed
	 * @return a boolean specifying whether or not the player can have a resource take from them
	 */
	public static boolean canGetMugged(HexLocation location,Player playerToRob){
		updateCurrentObjects();
		Bank opponentBank = playerToRob.getResources();
		if (!opponentBank.canRob()){
			return false;
		}
		for (int i = 0; i < gameMap.getCitiesForPlayer(playerToRob.getPlayerIndex()).size(); i++){
			City city = gameMap.getCitiesForPlayer(playerToRob.getPlayerIndex()).get(i);
			if (city.getLocation().getHexLoc().equals(location)){
				return true;
			}
		}
		for (int i = 0; i < gameMap.getSettlementsForPlayer(playerToRob.getPlayerIndex()).size(); i++){
			Settlement settlement = gameMap.getSettlementsForPlayer(playerToRob.getPlayerIndex()).get(i);
			if (settlement.getLocation().getHexLoc().equals(location)){
				return true;
			}
		}
		return false;
	}
	/**
	 * @param player that is getting robbed
	 */
	public static void getMugged(Player playerToRob){
		
		//TODO implement
		updateCurrentObjects();
		playerToRob.getResources().rob(playerBank);
	}
	/**
	 * @param sender the resources that are being sent
	 * @param receiver the resources that are being received
	 */
	public static void acceptTrade(Bank sender, Bank receiver){
		//TODO implement
	}
	
	public static void updateCurrentObjects(){
		player = Player.getCurrentPlayer();
		playerBank = player.getResources();
		gameMap = Model.get().getMap();
		robber = Model.get().getMap().getRobber();
	}
	
	public static boolean inBetweenHex(EdgeLocation eLocation){
		//TODO
		return false;
	}
	
	public static boolean isConnected(EdgeLocation eLocation){
		//TODO
		//must connect to another road belonging to the same player (except first round when player can place two roads anywhere)
		return false;
	}
	
	public static boolean checkForConnectedRoad(int roadLength, VertexLocation vLocation){
		//TODO use recursion
		return false;
	}

}