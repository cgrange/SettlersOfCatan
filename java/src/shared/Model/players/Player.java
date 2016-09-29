package shared.model.players;

import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.devcard.DevCardHand;

import shared.definitions.CatanColor;

import java.io.Console;
import java.util.List;

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


	public Player(CatanColor color, String name, int index){
		this.color = color;
		this.name = name;
		this.playerIndex = index;
	}

	private int playerID;
	private int playerIndex;
	private String name;
	private CatanColor color;
	private int numberOfMonuments;
	
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

	public void incrementNumberOfMonuments(int numberOfMonuments) {
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
	
	public int getNumberOfUnbuildRoads() {
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