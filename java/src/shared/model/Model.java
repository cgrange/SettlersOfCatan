package shared.model;

import java.util.List;

import shared.locations.HexLocation;
import shared.model.map.Map;
import shared.model.players.Player;
import shared.model.players.TurnTracker;
import shared.model.resources.Bank;
import shared.model.resources.TradeOffer;

public class Model {
	private static Model instance;
	private Bank centralBank;
	private List<Player> players;
	private Map map;
	private int version;
	private TurnTracker turnTracker;
	private TradeOffer tradeOffer;
	
	/**
	 * Gets the points
	 * @param playerIndex the player to get the points of
	 * @return the number of points
	 */
	public int calculatePoints(int playerIndex)
	{
		Player currentPlayer;
		int points = 0;

		for(Player p : players){
			if (p.getPlayerIndex() == playerIndex){
				currentPlayer = p;
			}
		}

		points += currentPlayer.getNumberOfSettlements();

		//add other instances when points are merited.

		return points;
	}
	
	/**
	 * Get the main game model
	 * @pre the model is on the client
	 * @return the main game model
	 */
	public static Model get()
	{
		if(instance == null){
			instance = new Model();
		}
		return instance;
	}
	
	/**
	 * Resets the current model to the given model
	 * @param model the model to update the game with
	 */
	public static void setCurrentModel(Model model)
	{
		instance = model;	
	}

	public static Bank getBank(){
		return centralBank;
	}

	public static void setBank(Bank b){
		centralBank = b;
	}

	public static List getPlayers(){
		return players;
	}

	public static void setPlayers(List <Player> playerList){
		players = playerList;
	}

	public static int getVersion(){
		return version;
	}

	public static void setVersion(int v){
		version = v;
	}

	public static TurnTracker getTurnTracker(){
		return turnTracker;
	}

	public static void setTurnTracker(TurnTracker t){
		turnTracker = t;
	}

	public static TradeOffer getTradeOffer(){
		return tradeOffer;
	}

	public static void setTradeOffer(TradeOffer t){
		tradeOffer = t;
	}


	
	/**
	 * serializes a model
	 * @return a json string
	 */
	public String serialize()
	{
		return "";
	}
	
	/**
	 * Plunders a given player
	 * @param location moves the robber to the given hex
	 * @param player takes a random resource from this player
	 */
	public void Plunder(HexLocation location, Player player)
	{
		
	}

}
