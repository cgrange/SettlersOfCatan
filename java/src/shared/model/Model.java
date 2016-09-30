package shared.model;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import client.poller.Poller;

import java.util.ArrayList;

import shared.locations.HexLocation;
import shared.model.map.Map;
import shared.model.map.*;
import shared.model.players.*;
import shared.model.resources.*;
import shared.model.devcard.*;

public class Model {
	private static Model instance;
	private static Object lockObject;
	private Bank centralBank;
	private List<Player> playerList;
	private Map map;
	private int version;
	private TurnTracker turnTracker;
	private TradeOffer tradeOffer;
	private DevCardHand centralDevCardHand;
	private int longestRoadPlayerIndex;
	private int largestArmyPlayerIndex;

	//create method hasLongestRoad which returns a playerIndex of the longest road

	/**
	 * Gets the points
	 * @param playerID the player to get the points of
	 * @return the number of points
	 */
	public int calculatePoints(Player currentPlayer)
	{
		int points = 0;

		Player currentPlayer = Player.get(playerIndex);
		points += currentPlayer.getNumberOfBuiltSettlements();


		int cityPoints = currentPlayer.getNumberOfCities()*2;
		points += cityPoints;

		TurnTracker turnT = TurnTracker.get();
		if (turnT.getLongestRoad() == currentPlayer){
			points += 2;
		}

		if (turnT.getLargestArmy() == currentPlayer){
			points += 2;
		}

		//checking for victory point cards? do we have those implemented anywhere for me to check?
		//monument cards

		return points;
	}

	public void setLongestRoad(int playerIndex){
		longestRoadPlayerIndex = playerIndex;
	}

	public int getLongestRoad(){
		return longestRoadPlayerIndex;
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
			instance = new Model("");
		}
		return instance;
	}

	public static void set(Model model)
	{

		instance = model;
		synchronized(lockObject)
		{
			instance = model;
		}
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

	public List getPlayers(){
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

	public void setCentralDevCardHand(DevCardHand h) { centralDevCardHand = h; }

	public DevCardHand getCentralDevCardHand() {
		return centralDevCardHand;
	}

	public DevCard getRandomDevCard() {
		return centralDevCardHand.getRandomDevCard();
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
	public void plunder(HexLocation location, Player player)
	{
		Robber robber = map.getRobber();

		robber.move(location);

		Bank bankToRob = player.getResources();

		bankToRob.rob(TurnTracker.get().getCurrentPlayer().getResources());


	}

}
