package shared.model.players;

import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.resources.Resource;
import shared.model.devcard.DevCardHand;
import shared.model.map.Map;
import shared.definitions.CatanColor;
import shared.definitions.DevCardType;
import shared.definitions.ResourceType;
import shared.exceptions.CannotBuildRoadException;
import shared.exceptions.CannotDecrementException;
import shared.exceptions.CannotMoveException;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Player {
	
	// Some constants
	private static final int roadsAllowed = 15;
	private static final int settlementsAllowed = 5;
	private static final int citiesAllowed = 4;

	private Bank resources;
	private DevCardHand newDevCards;
	private DevCardHand oldDevCards;
	private int numberOfSoldiers;
	private boolean discarded;
	private boolean playedDevCard;
	
	private int playerID;
	private int playerIndex;
	private String name;
	private CatanColor color;
	private int numberOfMonuments;
	
	public Player(String jsonString) throws Exception{
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(jsonString).getAsJsonObject();
		
		JsonElement resourcesElement = jsonObj.get("resources");
		String resourcesStr = gson.toJson(resourcesElement);
		resources = new Bank(resourcesStr);
		
		JsonElement oldDevCardsElement = jsonObj.get("oldDevCards");
		String oldDevCardsStr = gson.toJson(oldDevCardsElement);
		oldDevCards = new DevCardHand(oldDevCardsStr);
		
		JsonElement newDevCardsElement = jsonObj.get("newDevCards");
		String newDevCardsStr = gson.toJson(newDevCardsElement);
		newDevCards = new DevCardHand(newDevCardsStr);
		
		numberOfSoldiers = jsonObj.get("soldiers").getAsInt();
		//points = jsonObj.get("victoryPoints").getAsInt();
		numberOfMonuments = jsonObj.get("monuments").getAsInt();
		playedDevCard = jsonObj.get("playedDevCard").getAsBoolean();
		discarded = jsonObj.get("discarded").getAsBoolean();
		playerID = jsonObj.get("playerID").getAsInt();
		playerIndex = jsonObj.get("playerIndex").getAsInt();
		name = jsonObj.get("name").getAsString();
		String  colorStr = jsonObj.get("color").getAsString();
		color = CatanColor.getCatanColor(colorStr);
	}

	public Player(CatanColor color, String name, int index){
		this.color = color;
		this.name = name;
		this.playerIndex = index;
	}
	
	public int getPlayerID() {
		return playerID;
	}
	
	/**
	 * A static method to retrieve any player by his playerID
	 * @param playerID the Player ID of the desired player
	 * @return The player with the stipulated ID
	 */
	public static Player get(int playerIndex) {
		List<Player> players = Model.get().getPlayers();

		for(Player player: players) {
			System.out.println(player.getPlayerIndex());
			if (player.getPlayerIndex() == playerIndex) {
				return player;
			}
		}

		return null;
	}
	
	public static Player getCurrentPlayer(){
		return Model.get().getTurnTracker().getCurrentPlayer();
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

	public String getName() {
		return name;
	}

	public CatanColor getColor() {
		return color;
	}

	public int getNumberOfMonuments() {
		return numberOfMonuments;
	}
	
	public void setNumberOfMonuments(int numberOfMonuments) {
		this.numberOfMonuments = numberOfMonuments;
	}

	public void incrementNumberOfMonuments() {
		numberOfMonuments++;
	}

	public Bank getResources() {
		return resources;
	}

	public void setResources(Bank resources) {
		this.resources = resources;
	}

	public DevCardHand getNewDevCards() {
		return newDevCards;
	}

	public DevCardHand getOldDevCards() {
		return oldDevCards;
	}

	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}


	public boolean hasDiscarded() {
		return discarded;
	}

	public void setDiscarded(boolean discarded) {
		this.discarded = discarded;
	}

	public boolean hasPlayedDevCard() {
		return playedDevCard;
	}

	public void setPlayedDevCard(boolean playedDevCard) {
		this.playedDevCard = playedDevCard;
	}
	
	public int getNumberOfBuiltRoads() {
		return Model.get().getMap().getRoadsForPlayer(this.playerIndex).size();
	}
	
	public int getNumberOfUnbuiltRoads() {
		return roadsAllowed - getNumberOfBuiltRoads();
	}
	
	public int getNumberOfBuiltSettlements() {
		return Model.get().getMap().getSettlementsForPlayer(this.playerIndex).size();
	}
	
	public int getNumberOfUnbuiltSettlements() {
		return settlementsAllowed - getNumberOfBuiltSettlements();
	}
	
	public int getNumberOfBuiltCities() {
		return Model.get().getMap().getCitiesForPlayer(this.playerIndex).size();
	}
	
	public int getNumberOfUnbuiltCities() {
		return citiesAllowed - getNumberOfBuiltCities();
	}
	
	public boolean canPlayDevCard(DevCardType type)
	{
		return oldDevCards.canPlay(type);
	}
	
	public void playSoldier(HexLocation location, int victimIndex) throws CannotMoveException
	{
		oldDevCards.play(DevCardType.SOLDIER);
		Model.get().getMap().getRobber().move(location);
		Player.get(victimIndex).getResources().rob(this.getResources());
	}
	
	public void playYearOfPlenty(ResourceType resource1, ResourceType resource2) throws CannotDecrementException
	{
		oldDevCards.play(DevCardType.YEAR_OF_PLENTY);
		this.getResources().getResource(resource1).incrementAmounts(1);
		Bank.getCentralBank().getResource(resource1).decrementAmounts(1);
		this.getResources().getResource(resource2).incrementAmounts(1);
		Bank.getCentralBank().getResource(resource2).decrementAmounts(1);
	}
	
	public void playRoadBuilding(EdgeLocation spot1, EdgeLocation spot2) throws CannotBuildRoadException
	{
		oldDevCards.play(DevCardType.ROAD_BUILD);
		Map map = Model.get().getMap();
		map.addRoad(playerIndex, spot1);
		map.addRoad(playerIndex, spot2);
	}
	
	public void playMonopoly(ResourceType resource) throws CannotDecrementException
	{
		oldDevCards.play(DevCardType.MONOPOLY);
		int count = 0;
		for(Player player:Model.get().getPlayers())
		{
			Resource res = player.getResources().getResource(resource);
			int amount = res.getAmount();
			count = count + amount;
			res.decrementAmounts(amount);
		}
		this.getResources().getResource(resource).incrementAmounts(count);
	}
	
	public void playMonument()
	{
		oldDevCards.play(DevCardType.MONUMENT);
		this.numberOfMonuments++;
	}


	/**
	* serializes the Player to JSON
	* @return a JSON representation of the Player object
	*/
	public String serialize(){
		return "";
	}

	/**
	* calculates the number of victory points a Player has
	* @return the number of points the player has
	*/
	public int calculatePoints() {
		return 0;
	}

}