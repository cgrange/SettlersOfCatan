package shared.model.devcard;

import shared.definitions.DevCardType;
import shared.exceptions.CannotDecrementException;

public class DevCard {
	private DevCardType type;
	private int amount;

	public DevCard(DevCardType type)
	{
		this.type = type;
		this.amount = 0;
	}

	public DevCardType getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void decrementAmounts(int amount) throws CannotDecrementException {
		if (this.amount - amount < 0){
			throw new CannotDecrementException("Cannot decrease DevCard amount below 0");
		}
		else {
			this.amount -= amount;
		}
	}

	public boolean canPlay()
	{
		return false;
	}

	//
	public void play()
	{

	}

	public String serialize()
	{
		return "";
	}
}
