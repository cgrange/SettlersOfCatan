package shared.model.players;

import shared.model.resources.Bank;
import shared.model.devcard.DevCardHand;

public class Player {

	private Bank resources;
	private DevCardHand newDevCards;
	private DevCardHand oldDevCards;
	private int points;
	private int numberOfSoldiers;
	private int numberOfCities;
	private boolean discarded;
	private boolean playedDevCard;
	private int numberOfRoads;
	private int numberOfSettlements;

	public Player(Color color, String name, int index){
		this.color = color;
		this.name = name;
		this.playerIndex = index;
	}

	public enum Color {
	     BLUE, RED, ORANGE, YELLOW, GREEN, PURPLE, PUCE, WHITE, BROWN
	};
	private int playerID;
	private int playerIndex;
	private String name;
	private Color color;
	private int numberOfMonuments;
	public int getPlayerID() {
		return playerID;
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

	public Color getColor() {
		return color;
	}

	public int getNumberOfMonuments() {
		return numberOfMonuments;
	}

	public void incrementNumberOfMonuments(int numberOfMonuments) {
		//TODO
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
		//TODO
	}

	public int getNumberOfCities() {
		return numberOfCities;
	}

	public void setNumberOfCities(int numberOfCities) {
		this.numberOfCities = numberOfCities;
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

	public int getNumberOfRoads() {
		return numberOfRoads;
	}

	public void setNumberOfRoads(int numberOfRoads) {
		this.numberOfRoads = numberOfRoads;
	}

	public int getNumberOfSettlements() {
		return numberOfSettlements;
	}

	public void setNumberOfSettlements(int numberOfSettlements) {
		this.numberOfSettlements = numberOfSettlements;
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
	public int calculatePoints(){
		return 0;
	}

}