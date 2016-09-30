package shared.model.resources;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.exceptions.CannotDecrementException;
import shared.model.Model;
import shared.model.players.Player;

public class TradeOffer {
	private int senderIndex;
	private int receiverIndex;
	private Bank senderGive;
	private Bank senderTake;
	
	public TradeOffer(String jsonStr){
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(jsonStr).getAsJsonObject();
		senderIndex = jsonObj.get("sender").getAsInt();
		receiverIndex = jsonObj.get("receiver").getAsInt();
		String offerJson = jsonObj.get("offer").getAsString();
		senderGive = new Bank(offerJson);
	}
	
	public Player getSender() {
		return Player.get(senderIndex);
	}

	public Player getReceiver() {
		return Player.get(receiverIndex);
	}
	
	public Bank getSenderGive(){
		return senderGive;
	}

	public Bank getSenderTake(){
		return senderTake;
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
		Bank senderBank = Player.get(senderIndex).getResources();
		Bank receiverBank = Player.get(receiverIndex).getResources();
		
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
