package shared.model.communication;

import shared.definitions.CatanColor;
import shared.model.players.Player;

public class MessageLine {

	private int playerIndex;
	private String entry;


	public MessageLine(int playerIndex, String entry){
		this.playerIndex = playerIndex;
		this.entry = entry;
	}
	
	/**
	 * Adds a line to the Chat List
	 * @param playerIndex index of source player
	 * @return the color for the player
	 */
	public CatanColor getPlayerColor(int playerIndex){
		return null;
	}

	/**
	* toString for the messageline
	* @return the entry
	*/
	public String toString(){
		return entry;
	}

	/**
	 * Serializes the MessageLine
	 * @return a json string
	 */
	public String serialize()
	{
		return "";
	}

}
