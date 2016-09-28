package shared.model.resources;

import shared.definitions.ResourceType;
import shared.exceptions.CannotDecrementException;

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
	 * @exception CannotDecrementException if the amount to decrement cannot be performed
	 * @pre do not try to decrement past zero
	 * @pre toDecrement should be a positive number
	 * @param toDecrement how much to decrement the resource
	 */
	public void decrementAmounts(int toDecrement) throws CannotDecrementException
	{
		if (this.amount - toDecrement >= 0) {
			this.amount -= toDecrement;
		}
		else {
			throw new CannotDecrementException("Cannot decrement below zero");
		}
	}

	/**
	 * Increments the amount by the given amount
	 * @pre toIncrement should be a positive number
	 * @param toIncrement how much to increment the resource
	 */
	public void incrementAmounts(int toIncrement) {
		this.amount += toIncrement;
	}

	/**
	 * Checks whether there is the specified amount of this resource
	 * @param amount to check
	 * @return boolean whether or not there is enough of this resource
	 */
	public boolean hasEnough(int amount)
	{
		return (this.amount >= amount);
	}
}
