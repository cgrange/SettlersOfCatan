package shared.model.players;

import shared.definitions.Status;

/**
 * A class to interface with the game state button
 *
 */
public class TurnTracker {

	private Player currentPlayer;
	private Status status;
	private Player longestRoad;
	private Player largestArmy;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Player getLongestRoad() {
		//TODO: re-compute longest road
		return longestRoad;
	}

	public Player getLargestArmy() {
		//TODO: re-compute largest army
		return largestArmy;
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
