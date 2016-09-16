package shared.Model.Resources;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Represents a resource
 *
 */
public class Resource {
	private ResourceType type;
	private int amount;

	public Resource(ResourceType type, int amount) {
		super();
		this.type = type;
		this.amount = amount;
	}

	public ResourceType getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	/**
	 * Decrements the amount by the given amount
	 * @pre do not try to decrement past zero
	 * @pre toDecrement should be a positive number
	 * @param toDecrement how much to decrement the resource
	 */
	public void decrementAmounts(int toDecrement) {
		throw new NotImplementedException();
	}

	/**
	 * Increments the amount by the given amount
	 * @pre toIncrement should be a positive number
	 * @param toIncrement how much to increment the resource
	 */
	public void incrementAmounts(int toIncrement) {
		throw new NotImplementedException();
	}
}
