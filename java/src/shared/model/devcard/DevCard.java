package shared.model.devcard;

import shared.definitions.DevCardType;
import shared.exceptions.CannotDecrementException;
import shared.model.players.Player;

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
		return (this.amount > 0);
	}

	//
	public void play()
	{
		amount--;
		// Logic for actually playing dev cards maybe doesn't make sense here, 
		// we don't have all the info we need
	}	

	public String serialize()
	{
		return "";
	}
}
