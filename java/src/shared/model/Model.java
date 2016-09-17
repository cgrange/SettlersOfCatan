package shared.model;

import java.util.List;

import shared.locations.HexLocation;
import shared.model.map.Map;
import shared.model.players.Player;
import shared.model.players.TurnTracker;
import shared.model.resources.Bank;
import shared.model.resources.TradeOffer;

public class Model {
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
		return 0;
	}
	
	/**
	 * Get the main game model
	 * @pre the model is on the client
	 * @return the main game model
	 */
	public static Model get()
	{
		return null;
	}
	
	/**
	 * Resets the current model to the given model
	 * @param model the model to update the game with
	 */
	public static void setCurrentModel(Model model)
	{
		
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
