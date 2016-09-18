package shared.Model.communication;

import shared.definitions.CatanColor;

public class MessageLine {

	private Player source;
	private String entry;
	
	/**
	 * Adds a line to the Chat List
	 * @param playerIndex index of source player
	 */
	public CatanColor getPlayerColor(int playerIndex){

		return null;
	}

	public void setEntry(String entry){

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