package shared.model;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import client.poller.Poller;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.locations.HexLocation;
import shared.model.map.Map;
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

	/**
	 * Gets the points
	 * @param playerIndex the player to get the points of
	 * @return the number of points
	 */
	public int calculatePoints(Player currentPlayer)
	{
		int points = 0;

		points += currentPlayer.getNumberOfBuiltSettlements();

		//add other instances when points are merited.

		return points;
	}

	public Model(String jsonString) throws Exception
	{
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(jsonString).getAsJsonObject();
		
		JsonElement deckElement = jsonObj.get("deck");
		String deckStr = gson.toJson(deckElement);
		centralDevCardHand = new DevCardHand(deckStr);
		
		JsonElement mapElement = jsonObj.get("map");
		String mapStr = gson.toJson(mapElement);
		map = new Map(mapStr);
		
		JsonArray playerArray = jsonObj.get("players").getAsJsonArray();
		for(int i = 0; i < playerArray.size(); i++){
			JsonElement playerElement = playerArray.get(i);
			String playerStr = gson.toJson(playerElement);
			Player player = new Player(playerStr);
			playerList.add(player);
		}
		centralDevCardHand = new DevCardHand(mapStr);
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
			instance = new Model("");
		}
		return instance;
	}

	public static void set(Model model)
	{
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

	}

}
