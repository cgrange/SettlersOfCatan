package shared.Model.players;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		return longestRoad;
	}

	public void setLongestRoad(Player longestRoad) {
		this.longestRoad = longestRoad;
	}

	public Player getLargestArmy() {
		return largestArmy;
	}

	public void setLargestArmy(Player largestArmy) {
		this.largestArmy = largestArmy;
	}

	/**
	 * Move the turn tracker to the next Phase
	 */
	public void moveOn()
	{
		throw new NotImplementedException();
	}

	/**
	 * Return the turn tracker for the currentGame
	 * @return the current turn tracker
	 */
	public static TurnTracker get()
	{
		throw new NotImplementedException();
	}


}
