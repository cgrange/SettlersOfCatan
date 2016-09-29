package shared.model.devcard;

import shared.definitions.DevCardType;
import shared.exceptions.CannotDecrementException;
import shared.model.Model;
import shared.model.resources.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * A class representing a hand of dev cards
 *
 */
public class DevCardHand {

	Random random = new Random();

	private DevCard monopoly = new DevCard(DevCardType.MONOPOLY);
	private DevCard yearOfPlenty = new DevCard(DevCardType.YEAR_OF_PLENTY);
	private DevCard monument = new DevCard(DevCardType.MONUMENT);
	private DevCard soldier = new DevCard(DevCardType.SOLDIER);
	private DevCard roadBuilding = new DevCard(DevCardType.ROAD_BUILD);
	
	public DevCardHand(String jsonStr){

		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(jsonStr).getAsJsonObject();
		
		int yearOfPlentyAmount = jsonObj.get("yearOfPlenty").getAsInt();
		yearOfPlenty.setAmount(yearOfPlentyAmount);
		
		int monopolyAmount = jsonObj.get("monopoly").getAsInt();
		monopoly.setAmount(monopolyAmount);
		
		int soldierAmount = jsonObj.get("soldier").getAsInt();
		soldier.setAmount(soldierAmount);
		
		int roadBuildingAmount = jsonObj.get("roadBuilding").getAsInt();
		roadBuilding.setAmount(roadBuildingAmount);
		
		int monumentAmount = jsonObj.get("monument").getAsInt();
		monument.setAmount(monumentAmount);
		
	}
	
	public DevCardHand(){
		//mainly for testing purposes
	}

	/**
	 * Serializes the hand
	 * @return a json string
	 */
	public String serialize()
	{
		return "";
	}

	/**
	 * Gets the bank's cards
	 * @return the central group of cards
	 */
	public static DevCardHand getCentral()
	{
		return Model.get().getCentralDevCardHand();
	}


	private List<DevCard> getDevCards()
	{
		List<DevCard> cards = new ArrayList<DevCard>();
		cards.add(monopoly);
		cards.add(yearOfPlenty);
		cards.add(monument);
		cards.add(soldier);
		cards.add(roadBuilding);
		return cards;
	}

	public DevCard getRandomDevCard() {
		int totalAmount = monopoly.getAmount() + yearOfPlenty.getAmount() + monument.getAmount() + soldier.getAmount() + roadBuilding.getAmount();

		int cardsToRemove = random.nextInt(totalAmount);

		for(DevCard r: getDevCards()) {

			if (cardsToRemove < r.getAmount())
			{
				try {
					r.decrementAmounts(1);
					return new DevCard(r.getType());
				}
				catch (CannotDecrementException exception) {
				}
			} else { cardsToRemove -= r.getAmount(); }
		}

		return null;
	}

	public void setAmount(DevCardType type, int amount) {
		switch (type){
			case MONOPOLY:
				monopoly.setAmount(amount);
				break;
			case YEAR_OF_PLENTY:
				yearOfPlenty.setAmount(amount);
				break;
			case MONUMENT:
				monument.setAmount(amount);
				break;
			case SOLDIER:
				soldier.setAmount(amount);
				break;
			case ROAD_BUILD:
				roadBuilding.setAmount(amount);
				break;
		}
	}

	/**
	 * Checks whether a card can be played
	 * @param type the type of the dev card
	 * @return true if the card can be played
	 */
	public boolean canPlay(DevCardType type)
	{
		return false;
	}

	/**
	 * decrements the given dev card
	 * @param type the type to decrement
	 */
	public void play(DevCardType type)
	{

	}

	/**
	 * Checks how many dev cards you have
	 * @param type the type of dev card to check
	 * @return the number of dev cards
	 */
	public int getNumberOf(DevCardType type)
	{
		switch (type){
			case MONOPOLY:
				monopoly.getAmount();
				break;
			case YEAR_OF_PLENTY:
				yearOfPlenty.getAmount();
				break;
			case MONUMENT:
				monument.getAmount();
				break;
			case SOLDIER:
				soldier.getAmount();
				break;
			case ROAD_BUILD:
				roadBuilding.getAmount();
				break;
		}
		return 0;
	}

	/**
	 * Makes new dev cards active at the end of your turn
	 * @param newHand the new hand for the player
	 */
	public void moveToNewDevCardHand(DevCardHand newHand)
	{

	}

}
