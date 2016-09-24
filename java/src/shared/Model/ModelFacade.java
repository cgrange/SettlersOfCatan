package shared.model;

import shared.model.Model;
import shared.locations.HexLocation;
import shared.model.map.Map;
import shared.model.players.Player;
import shared.model.resources.Bank;
import shared.locations.VertexLocation;
import shared.locations.EdgeLocation;
import shared.model.devcard.DevCard;
import shared.model.resources.Resource;

public class ModelFacade {
	/**
	 * @param vLocation the vertex location that the player wants to build on
	 * @return a boolean specifying whether or not the player can build a city at that vertex location
	 */
	public boolean canBuildCity(VertexLocation vLocation){
		//TODO implement
		//player has 2 grain, 3 ore
		//there must already be a settlement that the same player owns on this location
		//the player must have enough cities left to be able to build
		//how do I know who the player is?
		return false;
	}
	/**
	 * @param vLocation the vertex location that the player wants to build in
	 */
	public void buildCity(VertexLocation vLocation){
		//TODO implement
		//how do I know who the player is?
	}
	/**
	 * @param eLocation the edge location that the player wants to build on
	 * @return a boolean specifying whether or not the player can build a road at that edge location
	 */
	public boolean canBuildRoad(EdgeLocation eLocation){
		//TODO implement
		//player has brick and lumber
		//must be placed on edges between two hexes
		//must connect to another road belonging to the same player (except first round when player can place two roads anywhere)
		return false;
	}
	/**
	 * @param eLocation edge location where the road is to be built
	 */
	public void buildRoad(EdgeLocation eLocation){
		//TODO implement
		//remember to calculate the longest road
	}
	/**
	 * @param vLocation the vertexLocation where the player wants to build
	 * @return a boolean specifying whether or not the player can build a settlement at that vertex location
	 */
	public boolean canBuildSettlement(VertexLocation vLocation){
		//TODO implement
		//must be placed two or more road segments away from each other, and must connect to one or more roads belonging to the player. 
		return false;
	}
	/**
	 * @param vLocation the vertexLocation where the player wants to build
	 */
	public void buildSettlement(VertexLocation vLocation){
		//TODO implement
		//give the player points
	}
	/**
	 * @param devCard the development card that the player wants to play
	 * @return a boolean specifying whether or not the player can play that devCard
	 */
	public boolean canPlayDevCard(DevCard devCard){
		//TODO implement
		//check to see if player hasn't already used a dev card that round
		//must wait for next round if just picked up a card (other than the monument card [point card])
		//soldier card acts like a robber so we can just use the canrob method to see if it will work
		//i think you can use year of plenty and monopoly anytime....
		
		return false;
	}
	/**
	 * @param devCard the devCard that the player wants to play
	 */
	public void playDevCard(DevCard devCard){
		//TODO implement
		//maybe a switch statement or something idk
	}
	/**
	 * @return a boolean specifying whether or not the player can draw a dev card
	 */
	public boolean canDrawDevCard(){
		//TODO implement
		//player has wool, ore, and grain
		//clicked "buy card" and not "no thanks"
		return false;
	}
	public void drawDevCard(){
		//TODO implement
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @return a boolean specifying whether or not the player can trade at that port
	 */
	public boolean canTradeAtPort(EdgeLocation eLocation){
		//TODO implement
		//does the player reside on the port. Check
		return false;
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @param receive the resource that the player wants to receive for her trade
	 */
	public void tradeAtPort(EdgeLocation eLocation, Resource receive){
		//TODO implement
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @param give the resource that the player wants to give for her trade
	 * @return a boolean specifying whether or not the player can trade at that port
	 */
	public boolean canTradeAtPort(EdgeLocation eLocation, Resource give){
		//TODO implement
		//does the player reside on the port. Check
		return false;
	}
	/**
	 * @param eLocation the edge location where the port resides
	 * @param give the resource that the player wants to give for her trade
	 * @param receive the resource that the player wants to receive for her trade
	 */
	public void tradeAtPort(EdgeLocation eLocation, Resource give, Resource receive){
		//TODO implement
		//does the player reside on the port. Check
	}
	/**
	 * @param location the location that the player wants to move the robber to
	 * @return a boolean specifying whether or not the player can move the robber to that location
	 */
	public boolean canUseRobber(HexLocation location){
		//TODO implement
		//cannot be moved to water
		//cannot be moved to previous robber location
		return false;
	}
	/**
	 * @param location the location that the player wants to move the robber to
	 * @param player the player that the current player wants to take a resource from
	 * @param resource the resource that the current player wants to take from another player
	 */
	public void useRobber(HexLocation location, Player player, Resource resource){
		//TODO implement
	}
	/**
	 * @return a boolean specifying whether or not the player is affected by the robber being used
	 */
	public boolean canGetPlundered(){
		//TODO implement
		//if player has 8 or more cards
		return false;
	}
	/**
	 * @param toDiscard the resources that the player chooses to discard should they be affected by the robber
	 */
	public void getPlundered(Bank toDiscard){
		//TODO implement
		//remember to round down
	}
	/**
	 * @param location the hex location that the robber has been moved to
	 * @return a boolean specifying whether or not the player can have a resource take from them
	 */
	public boolean canGetMugged(HexLocation location){
		//TODO implement
		//if player has settlement or city on the robber hex then he can get mugged
		//must have cards
		return false;
	}
	/**
	 * @param resource the resource that is being taken from this player
	 */
	public void getMugged(Resource resource){
		//TODO implement
	}
	/**
	 * @param sender the resources that are being sent
	 * @param receiver the resources that are being received
	 */
	public void acceptTrade(Bank sender, Bank receiver){
		//TODO implement
	}

}
