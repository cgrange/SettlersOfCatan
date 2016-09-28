package shared.model.players;

import shared.definitions.Status;
import shared.model.Model;
import java.util.ArrayList;
import java.util.List;
import shared.model.map.Map;

/**
 * A class to interface with the game state button
 *
 */
public class TurnTracker {

	private static TurnTracker instance;
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

		//get from map class

		Map m = Model.get().getMap();
		//m.getLongestRoad();


		// //Doesn't longest road have to be consecutive and not branched? Need to figure out how to do that...
		// List<Player> pList = Model.get().getPlayers();
		// if(longestRoad == null){
		// 	longestRoad = pList.get(0);
		// }

		// for(Player p : pList){
		// 	if(p.getNumberOfRoads() > longestRoad.getNumberOfRoads()){
		// 		longestRoad = p;
		// 	}
		// }

		return longestRoad;
	}

	public Player getLargestArmy() {

		//get from player class

		//largestArmy = Player.get().getLargestArmy();

		// List<Player> pList = Model.get().getPlayers();
		// if(largestArmy == null){
		// 	largestArmy = pList.get(0);
		// }
		
		// for(Player p : pList){
		// 	if(p.getNumberOfSoldiers() > largestArmy.getNumberOfSoldiers()){
		// 		largestArmy = p;
		// 	}
		// }
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
		if(instance == null){
			instance = new TurnTracker();
		}
		return instance;
	}
	
	/**
	 * Gets the player whose turn it is 
	 * @return the player whose turn it is
	 */
	public Player isTurn()
	{
		return currentPlayer;
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
		return Model.get().calculatePoints(playerIndex);
	}
	
	/**
	 * serializes the turn tracker
	 * @return a json string
	 */
	public String serialize(){
		return "";
	}
	
}
