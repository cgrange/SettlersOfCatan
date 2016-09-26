package shared.model;

import java.util.List;
import java.util.ArrayList;

import shared.locations.HexLocation;
import shared.model.map.Map;
import shared.model.players.Player;
import shared.model.players.TurnTracker;
import shared.model.resources.Bank;
import shared.model.resources.TradeOffer;

public class Model {
	private static Model instance;
	private Bank centralBank;
	private List<Player> playerList;
	private Map map;
	private int version;
	private TurnTracker turnTracker;
	private TradeOffer tradeOffer;
	
	/**
	 * Gets the points
	 * @param playerIndex the player to get the points of
	 * @return the number of points
	 */
	public int calculatePoints(Player currentPlayer)
	{
		int points = 0;

		points += currentPlayer.getNumberOfSettlements();

		//add other instances when points are merited.

		return points;
	}
	
	public Model(String jsonString)
	{
		//TODO: Implement
		centralBank = null;
		playerList = null;
		map = null;
		version = -1;
		turnTracker = null;
		tradeOffer = null;
	}

	/**
	 * Get the main game model
	 * @pre the model is on the client
	 * @return the main game model
	 */
	public static Model get()
	{
		if(instance == null){
			//not a valid constructor
			//instance = new Model();
		}
		return instance;
	}

	public Bank getBank(){
		return centralBank;
	}

	public void setBank(Bank b){
		centralBank = b;
	}

	public List<Player> getPlayers(){
		return playerList;
	}

	public void setPlayers(List <Player> pList){
		playerList = pList;
	}

	public int getVersion(){
		return version;
	}

	public void setMap(Map m){
		map = m;
	}

	public Map getMap(){
		return map;
	}

	public void setVersion(int v){
		version = v;
	}

	public TurnTracker getTurnTracker(){
		return turnTracker;
	}

	public void setTurnTracker(TurnTracker t){
		turnTracker = t;
	}

	public TradeOffer getTradeOffer(){
		return tradeOffer;
	}

	public void setTradeOffer(TradeOffer t){
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
