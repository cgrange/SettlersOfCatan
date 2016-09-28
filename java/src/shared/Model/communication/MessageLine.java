package shared.model.communication;

import shared.definitions.CatanColor;
import shared.model.players.Player;

public class MessageLine {

	private int playerID;
	private String entry;
	private String playerName;
	private CatanColor color;

	public MessageLine(int playerID, String entry){
		this.playerID = playerID;
		this.entry = entry;
		this.playerName = Player.get(playerID).getName();
	}
	
	/**
	 * Adds a line to the Chat List
	 * @param playerIndex index of source player
	 * @return the color for the player
	 */
	public CatanColor getPlayerColor(int playerID){

		//just return this next line once Color is changed to CatanColor across the other classes
		Player.get(playerID).getColor();

		return null;
	}

	/**
	* toString for the messageline
	* @return the entry
	*/
	public String toString(){

		String str = new String(playerName + " " + entry);
		return str.toString();
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
