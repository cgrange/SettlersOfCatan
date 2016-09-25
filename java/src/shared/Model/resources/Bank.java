package shared.model.resources;

import com.google.gson.JsonObject;

import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;

/**
 * Represents a collection of resources
 *
 */
public class Bank {

	Resource ore = new Resource(ResourceType.ORE, 0);
	Resource wheat = new Resource(ResourceType.WHEAT, 0);
	Resource brick = new Resource(ResourceType.BRICK, 0);
	Resource wood = new Resource(ResourceType.WOOD, 0);
	Resource sheep = new Resource(ResourceType.SHEEP, 0);
	
	public Bank() {};

	public Resource getResource(ResourceType type){
		return null;
	}

	/**
	 * Checks whether the bank has any resources
	 * @return true if the user has resources
	 */
	public boolean canRob(){
		return false;
	}

	/**
	 * Robs this bank
	 * @param robbingBank the bank to give the resource to
	 */
	public void rob(Bank robbingBank) {
	}

	/**
	 * Checks for the appropriate resources to build a settlement
	 * @return true if a settlement can be built
	 */
	public boolean canBuildSettlement() {
		return false;
	}

	/**
	 * Removes the amount of resources of a settlement being built
	 */
	public void removeSettlementResources() {

	}

	/**
	 * Checks for the appropriate resources to build a city
	 * @return true if a city can be built
	 */
	public boolean canBuildCity() {
		return false;
	}

	/**
	 * Removes the amount of resources of a city being built
	 */
	public void removeCityResources() {

	}

	/**
	 * Checks for the appropriate resources to build a road
	 * @return true if a road can be built
	 */
	public boolean canBuildRoad() {
		return false;
	}

	/**
	 * Removes the amount of resources of a road being built
	 */
	public void removeRoadResources() {

	}

	/**
	 * Checks for the appropriate resources to draw a dev card
	 * @return true if a dev card can be drawn
	 */
	public boolean canDrawDevCard() {
		return false;
	}

	/**
	 * Removes the amount of resources of a dev card being drawn
	 */
	public void removeDevCardResources() {

	}

	/**
	 * Facilitates a trade between the two banks
	 * @param sender The bank sending the offer
	 * @param receiver The bank receiving the offer
	 */
	public void acceptTrade(Bank sender, Bank receiver) {

	}

	/**
	 * Finds the central bank of the game
	 * @return The central bank of the game
	 */
	public static Bank getCentralBank() {
		return null;
	}

	/**
	 * Checks whether this player has the resources to make the specified trade
	 * @param inputResource the resource he wants to trade
	 * @param outputResource the resource he wants to receive
	 * @param ratio the correct ratio for the port trade
	 * @return whether he has the correct resources
	 */
	public boolean canTradeAtPort(Resource inputResource, Resource outputResource, int ratio)
	{
		return false;
	}

	/**
	 * Makes the given trade
	 * @pre canTradeAtPort is accurate
	 * @pre the user actually has the specified port
	 * @param ratio 2,3 or 4
	 * @param inputResource the resources coming in from the trade
	 * @param outputResource the resources going out from the trade
	 */
	public void tradeAtPort(int ratio, Resource inputResource, Resource outputResource)
	{

	}

	/**
	 * Discards the given cards
	 * @pre the player really has to discard
	 * @pre the player has the given cards
	 * @param bank the cards to discard
	 */
	public void discard(Bank bank)
	{

	}

	/**
	 * Serializes the Bank
	 * @return a json string
	 */
	public JsonObject serialize()
	{
		JsonObject bank = new JsonObject();
		bank.addProperty("brick", Integer.toString(brick.getAmount()));
		bank.addProperty("ore", Integer.toString(ore.getAmount()));
		bank.addProperty("sheep", Integer.toString(sheep.getAmount()));
		bank.addProperty("wheat", Integer.toString(wheat.getAmount()));
		bank.addProperty("wood", Integer.toString(wood.getAmount()));
		return bank;

	}
}
