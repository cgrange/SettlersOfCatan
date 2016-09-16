package shared.Model.Resources;

import shared.Model.players.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TradeOffer {
	private Player sender;
	private Player receiver;
	private Bank offer;
	
	public Player getSender() {
		return sender;
	}

	public Player getReceiver() {
		return receiver;
	}

	public Bank getOffer() {
		return offer;
	}

	/**
	 * Rejects the trade
	 */
	public void reject() {
		throw new NotImplementedException();
	}
	
	/**
	 * Makes the appropriate trade
	 */
	public void trade() {
		throw new NotImplementedException();
	}
}
