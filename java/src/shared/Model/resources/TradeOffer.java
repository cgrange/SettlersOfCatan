package shared.model.resources;

import shared.model.players.Player;

public class TradeOffer {
	private Player sender;
	private Player receiver;
	private Bank senderGive;
	private Bank senderTake;
	
	public Player getSender() {
		return sender;
	}

	public Player getReceiver() {
		return receiver;
	}

	/**
	 * Sets the give of the offer
	 */
	public void setOffer(Bank giveOffer, Bank takeOffer) {
		this.senderGive = giveOffer;
		this.senderTake = takeOffer;
	}

	/**
	 * Rejects the trade
	 */
	public void reject() {

	}
	
	/**
	 * Makes the appropriate trade
	 */
	public void accept() {

	}
	
	/**
	 * Serializes the turn tracker
	 * @return a json string
	 */
	public String serialize() {
		return "";
	}
}
