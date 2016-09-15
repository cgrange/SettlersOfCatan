package shared.Model.Resources;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Represents a collection of resources
 * 
 */
public class Bank {

	Resource ore = new Resource(ResourceType.Ore, 0);
	Resource wheat = new Resource(ResourceType.Wheat, 0);
	Resource brick = new Resource(ResourceType.Brick, 0);
	Resource wood = new Resource(ResourceType.Wood, 0);
	Resource sheep = new Resource(ResourceType.Sheep, 0);
	
	public Resource getResource(ResourceType type){
		throw new NotImplementedException();
	}
	
	/**
	 * Checks whether the bank has any resources
	 * @return true if the user has resources
	 */
	public boolean canRob(){
		throw new NotImplementedException();
	}
	
	/**
	 * Robs this bank
	 * @param robbingBank the bank to give the resource to
	 */
	public void rob(Bank robbingBank) {
		throw new NotImplementedException();
	}
	
	/**
	 * Checks for the appropriate resources to build a settlement
	 * @return true if a settlement can be built
	 */
	public boolean canBuildSettlement() {
		throw new NotImplementedException();
	}
	
	/**
	 * Removes the amount of resources of a settlement being built
	 */
	public void removeSettlementResources() {
		throw new NotImplementedException();
	}
	
	/**
	 * Checks for the appropriate resources to build a city
	 * @return true if a city can be built
	 */
	public boolean canBuildCity() {
		throw new NotImplementedException();
	}
	
	/**
	 * Removes the amount of resources of a city being built
	 */
	public void removeCityResources() {
		throw new NotImplementedException();
	}
	
	/**
	 * Checks for the appropriate resources to build a road
	 * @return true if a road can be built
	 */
	public boolean canBuildRoad() {
		throw new NotImplementedException();
	}
	
	/**
	 * Removes the amount of resources of a road being built
	 */
	public void removeRoadResources() {
		throw new NotImplementedException();
	}
	
	/**
	 * Checks for the appropriate resources to draw a dev card
	 * @return true if a dev card can be drawn
	 */
	public boolean canDrawDevCard() {
		throw new NotImplementedException();
	}
	
	/**
	 * Removes the amount of resources of a dev card being drawn
	 */
	public void removeDevCardResources() {
		throw new NotImplementedException();
	}
	
	/**
	 * Facilitates a trade between the two banks
	 * @param sender The bank sending the offer
	 * @param receiver The bank receiving the offer
	 */
	public void acceptTrade(Bank sender, Bank receiver) {
		throw new NotImplementedException();
	}
	
	/**
	 * Finds the central bank of the game
	 * @return The central bank of the game
	 */
	public static Bank getCentralBank() {
		throw new NotImplementedException();
	}
}
