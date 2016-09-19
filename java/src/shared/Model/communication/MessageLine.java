package shared.Model.communication;

import shared.definitions.CatanColor;

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