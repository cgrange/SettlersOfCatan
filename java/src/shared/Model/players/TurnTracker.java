package shared.model.players;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.definitions.Status;

/**
 * A class to interface with the game state button
 *
 */

public class TurnTracker {

	private int currentPlayerIndex;
	private Status status;
	private int longestRoadPlayerIndex;
	private int largestArmyPlayerIndex;
	
	public TurnTracker(String jsonStr) throws Exception{
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(jsonStr).getAsJsonObject();
		
		String statusString = jsonObj.get("status").getAsString();
		status = Status.getStatus(statusString);
		
		currentPlayerIndex = jsonObj.get("currentTurn").getAsInt();
		largestArmyPlayerIndex = jsonObj.get("largestArmy").getAsInt();
		longestRoadPlayerIndex = jsonObj.get("longestRoad").getAsInt();

	}

	public TurnTracker(){
		// for testing purposes
	}

	public Player getCurrentPlayer() {
		return Player.get(currentPlayerIndex);
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayerIndex = currentPlayer.getPlayerIndex();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Player getLongestRoad() {
		//TODO: re-compute longest road
		return Player.get(longestRoadPlayerIndex);
	}

	public Player getLargestArmy() {
		//TODO: re-compute largest army
		return Player.get(largestArmyPlayerIndex);
	}

	/**
	 * Move the turn tracker to the next Phase
	 */
	public void moveOn()
	{
	}

	/**
	 * Return the turn tracker for the currentGame
	 * @return the current turn tracker
	 */
	public static TurnTracker get()
	{
		return null;
	}
	
	/**
	 * Gets the player whose turn it is 
	 * @return the player whose turn it is
	 */
	public Player isTurn()
	{
		return null;
	}
	
	/**
	 * Checks whether the current player can finish his turn
	 * @param playerIndex the player index of the player to finish turn
	 * @return true if the player can finish his turn
	 */
	public boolean canFinishTurn(int playerIndex)
	{
		return false;
	}

	/**
	 * Checks whether the current player player can roll
	 * @param playerIndex the player index of the player to roll
	 * @return true if the player can roll
	 */
	public boolean canRoll(int playerIndex)
	{
		return false;
	}
	
	/**
	 * Checks whether the given player can use the robber
	 * @param playerIndex the player index of the player to check
	 * @return true if the status is robbing
	 */
	public boolean canUseRobber(int playerIndex)
	{
		return false;
	}
	
	/**
	 * Gets the victory points of the given player
	 * @param playerIndex the player index of the player to check
	 * @return the number of points
	 */
	public int totalPoints(int playerIndex)
	{
		return 0;
	}
	
	/**
	 * serializes the turn tracker
	 * @return a json string
	 */
	public String serialize(){
		return "";
	}
	
}
