package shared.model.resources;

import com.google.gson.JsonObject;

import shared.definitions.ResourceType;
import shared.exceptions.CannotDecrementException;
import shared.locations.EdgeLocation;
import shared.model.Model;

import java.util.List;
import java.util.Random;

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

	public Resource getResource(ResourceType type){
		switch (type) {
			case ORE:
				return ore;
			case WHEAT:
				return wheat;
			case BRICK:
				return brick;
			case WOOD:
				return wood;
			case SHEEP:
				return sheep;
		}
		return null;
	}

	/**
	 * Checks whether the bank has any resources
	 * @return true if the user has resources
	 */
	public boolean canRob(){
		return ( ore.getAmount()   > 0 ||
		 		 wheat.getAmount() > 0 ||
				 brick.getAmount() > 0 ||
				 wood.getAmount()  > 0 ||
				 sheep.getAmount() > 0 );
	}

	/**
	 * Robs this bank
	 * @param robbingBank the bank to give the resource to
	 */
	public void rob(Bank robbingBank) {
		if (this.canRob()) {
			int totalAmount = ore.getAmount() + wheat.getAmount() + brick.getAmount() + wood.getAmount() + sheep.getAmount();

			Random rnd = new Random();
			int resourceToRemove = rnd.nextInt(totalAmount);



			// select random type that exists
		}
	}

	/**
	 * Checks for the appropriate resources to build a settlement
	 * @return true if a settlement can be built
	 */
	public boolean canBuildSettlement() {
		return (   brick.getAmount() > 1
				&& wood.getAmount()  > 1
				&& sheep.getAmount() > 1
				&& wheat.getAmount() > 1);
	}

	/**
	 * Removes the amount of resources of a settlement being built
	 */
	public void removeSettlementResources() throws CannotDecrementException {
		brick.decrementAmounts(1);
		wood.decrementAmounts(1);
		sheep.decrementAmounts(1);
		wheat.decrementAmounts(1);
	}

	/**
	 * Checks for the appropriate resources to build a city
	 * @return true if a city can be built
	 */
	public boolean canBuildCity() {
		return (   ore.getAmount()   > 3
				&& wheat.getAmount() > 2);
	}

	/**
	 * Removes the amount of resources of a city being built
	 */
	public void removeCityResources() throws CannotDecrementException {
		ore.decrementAmounts(3);
		wheat.decrementAmounts(2);
	}

	/**
	 * Checks for the appropriate resources to build a road
	 * @return true if a road can be built
	 */
	public boolean canBuildRoad() {
		return (   brick.getAmount() > 1
				&& wood.getAmount()  > 1);
	}

	/**
	 * Removes the amount of resources of a road being built
	 */
	public void removeRoadResources() throws CannotDecrementException {
		ore.decrementAmounts(1);
		wheat.decrementAmounts(1);
	}

	/**
	 * Checks for the appropriate resources to draw a dev card
	 * @return true if a dev card can be drawn
	 */
	public boolean canDrawDevCard() {
		return (   ore.getAmount()   > 1
				&& sheep.getAmount() > 1
				&& wheat.getAmount() > 1);
	}

	/**
	 * Removes the amount of resources of a dev card being drawn
	 */
	public void removeDevCardResources() throws CannotDecrementException {
		ore.decrementAmounts(1);
		sheep.decrementAmounts(1);
		wheat.decrementAmounts(1);
	}

	/**
	 * Facilitates a trade between the two banks
	 * @param sender The bank sending the offer
	 * @param receiver The bank receiving the offer
	 * @param offer The offer being given
	 */
	public void acceptTrade(Bank sender, Bank receiver, TradeOffer offer) {


	}

	/**
	 * Finds the central bank of the game
	 * @return The central bank of the game
	 */
	public static Bank getCentralBank() {
		return Model.get().getBank();
	}

	/**
	 * Checks whether this player has the resources to make the specified trade
	 * @param inputResource the resource he wants to trade
	 * @param outputResource the resource he wants to receive
	 * @param ratio the correct ratio for the port trade (2, 3 or 4)
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
	 * @param inputResource the resources coming in from the trade
	 * @param outputResource the resources going out from the trade
	 * @param ratio 2, 3 or 4
	 */
	public void tradeAtPort(Resource inputResource, Resource outputResource, int ratio)
	{

	}

	/**
	 * Discards the given cards
	 * @pre the player really has to discard
	 * @pre the player has the given cards
	 * @param bank the cards to discard
	 */
	public void discard(Bank bank) {

	}

	/**
	 * Serializes the Bank
	 * @return a json string
	 */
	public JsonObject serialize()
	{
		return null;
	}
}
