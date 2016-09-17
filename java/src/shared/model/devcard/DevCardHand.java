package shared.model.devcard;

import shared.definitions.DevCardType;

/**
 * A class representing a hand of dev cards
 *
 */
public class DevCardHand {
	
	private DevCard monopoly = new DevCard(DevCardType.MONOPOLY);
	private DevCard yearOfPlenty = new DevCard(DevCardType.YEAR_OF_PLENTY);
	private DevCard monument = new DevCard(DevCardType.MONUMENT);
	private DevCard soldier = new DevCard(DevCardType.SOLDIER);
	private DevCard buildRoad = new DevCard(DevCardType.ROAD_BUILD);
	
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
		return null;
	}
	
	/**
	 * Checks whether a card can be played
	 * @param type the type of the dev card
	 * @return true if it can be played
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
		return 0;
	}
	
	/**
	 * Makes new dev cards active at the end of your turn
	 * @param newHand
	 */
	public void moveToNewDevCardHand(DevCardHand newHand)
	{
		
	}

}
