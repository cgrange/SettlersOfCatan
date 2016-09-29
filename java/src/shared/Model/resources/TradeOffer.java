package shared.model.resources;

import shared.exceptions.CannotDecrementException;
import shared.model.Model;
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
		Model.get().setTradeOffer(null);
	}
	
	/**
	 * Makes the appropriate trade
	 * @throws CannotDecrementException 
	 */
	public void accept() throws CannotDecrementException {
		Bank senderBank = sender.getResources();
		Bank receiverBank = receiver.getResources();
		
		senderBank.addAmounts(senderTake);
		senderBank.subtractAmounts(senderGive);
		
		receiverBank.addAmounts(senderGive);
		receiverBank.subtractAmounts(senderTake);
		Model.get().setTradeOffer(null);
	}
	
	/**
	 * Serializes the turn tracker
	 * @return a json string
	 */
	public String serialize() {
		return "";
	}
}
