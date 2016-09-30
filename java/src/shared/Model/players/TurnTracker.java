package shared.model.players;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

<<<<<<< HEAD
	private static TurnTracker instance;
	private Player currentPlayer;
=======
	private int currentPlayerIndex;
>>>>>>> 022e8801e2f3ed7717aaa0a60d80d76cf69b2bcb
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
<<<<<<< HEAD

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
=======
		return Player.get(longestRoadPlayerIndex);
	}

	public Player getLargestArmy() {
		//TODO: re-compute largest army
		return Player.get(largestArmyPlayerIndex);
>>>>>>> 022e8801e2f3ed7717aaa0a60d80d76cf69b2bcb
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
