package shared.model.resources;

import shared.model.players.Player;

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
	}
	
	/**
	 * Makes the appropriate trade
	 */
	public void trade() {
	}
}
