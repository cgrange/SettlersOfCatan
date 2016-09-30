package shared.model.players;

import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.devcard.DevCardHand;
import shared.definitions.CatanColor;

import java.io.Console;
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
	private int points;
	private int numberOfSoldiers;
	private boolean discarded;
	private boolean playedDevCard;
	
	private int numberOfUnusedCities;
	private int numberOfUnusedRoads;
	private int numberOfUnusedSettlements;
	
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
		
		numberOfUnusedRoads = jsonObj.get("roads").getAsInt();
		numberOfUnusedCities = jsonObj.get("cities").getAsInt();
		numberOfUnusedSettlements = jsonObj.get("settlements").getAsInt();
		numberOfSoldiers = jsonObj.get("soldiers").getAsInt();
		points = jsonObj.get("victoryPoints").getAsInt();
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

	public void setNewDevCards(DevCardHand newDevCards) {
		this.newDevCards = newDevCards;
	}

	public DevCardHand getOldDevCards() {
		return oldDevCards;
	}

	public void setOldDevCards(DevCardHand oldDevCards) {
		this.oldDevCards = oldDevCards;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}

	public void incrementNumberOfSoldiers(int numberOfSoldiers) {
		numberOfSoldiers++;
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