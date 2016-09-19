package client.proxy;

import java.util.List;

import client.overview.SimpleGame;
import shared.definitions.CatanColor;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.resources.Resource;

public interface IProxy {

	/**
	 * Logs the caller in to the server, and sets their catan.user HTTP cookie
	 * @pre username is not null
	 * @pre password is not null
	 * @post the HTTP response headers set the catan.user cookie to contain the identity of the logged in player
	 */
	public void user_login();

	/**
	 * Creates a new user account, logs the caller in
	 * @pre username is not null
	 * @pre password is not null
	 * @pre the specified username is not already in use
	 * @post a new user is logged in
	 * @post the HTTP response headers set the catan.user cookie to contain the identity of the logged in player
	 */
	public void user_register();

	/**
	 * Gets info about all games on server
	 * @post body contains a JSON array containing a list of objects that contain information about the server's games
	 * @return information about all the games on the server
	 */
	public List<SimpleGame> games_list();

	/**
	 * Creates a new game on the server
	 * @param randomTiles the random tiles
	 * @param randomNumbers the random numbers
	 * @param randomPorts the random ports
	 * @pre all parameters are valid
	 * @return A new game information
	 */
	public SimpleGame games_create(boolean randomTiles, boolean randomNumbers, boolean randomPorts);

	/**
	 * Adds the player to the specified game
	 * @pre the user has previously logged in to the server
	 * @pre The player is already in the game or there is space in the game
	 * @pre the specified game is valid
	 * @pre the specified color is valid
	 * @post the player is in a game
	 * @post The catan.game HTTP cookie is set
	 * @param id the gameId
	 * @param color the color of the player
	 * @return the game
	 */
	public String games_join(int id, CatanColor color);

	/**
	 * This method is for testing and debugging purposes. When a bug is found, you can use the
     * /games/save method to save the state of the game to a file, and attach the file to a bug report.
     * A developer can later restore the state of the game when the bug occurred by loading the
     * previously saved file using the /games/load method. Game files are saved to and loaded from
     * the server's saves/ directory
     * @pre specified game ID is valid
     * @pre the specified file name is valid
     * @param id the game ID
	 */
	public void games_save(int id);

	/**
	 * This method is for testing and debugging purposes. When a bug is found, you can use the
     * /games/save method to save the state of the game to a file, and attach the file to a bug report.
     * A developer can later restore the state of the game when the bug occurred by loading the
     * previously saved file using the /games/load method. Game files are saved to and loaded from
     * the server's saves/ directory
     * @param name the name of the game to load
     * @pre A saved game file with the specified name exists
     * @post game state is restored
	 */
	public void games_load(String name);

	/**
	 * Returns the current state of the game in JSON format
	 * @param versionNumber the current version number, does not return anything if nothing has changed
	 * @pre logged in and joined to game
	 * @pre versionNumber is valid
	 * @post the Model is returned
	 * @return the current Model, or nothing if there is no update
	 */
	public Model game_model(int versionNumber);

	/**
	 * Clears out the history of the game
	 * @pre User is logged in and joined
	 * @post the game's command history has been cleared out
	 * @post the game's players have not been cleared out
	 * @return the model of the clear game
	 */
	public Model game_reset();

	/**
	 * Get a list of commands in the game
	 * @return a list of commands that have been executed in the game
	 * @pre the caller is logged in and joined a game
	 */
	public Model game_commands_get();

	/**
	 * Executes the specified command list in the current game
	 * @param commands the command list to apply
	 */
	public void game_commands_post(List<String> commands);

	/**
	 * Returns a list of supported AI player types
	 * @return the list of supported AI types
	 */
	public List<String> game_listAI();

	/**
	 * Adds an AI player to the current game
	 * @param AIType the type of AI to add
	 * @pre the user is logged in and joined
	 * @pre the game is not full
	 * @pre The specified AIType is valid
	 * @post the AI player is added
	 * @return the game with the AI added
	 */
	public SimpleGame game_addAI(String AIType);

	/**
	 * Sets the server's logging level
	 * @pre the caller specifies a valid logging level
	 * @post the server is set to the specified logging level
	 * @param level a valid logging level
	 */
	public void util_changeLogLevel(String level);

	/**
	 * Sends a chat message
	 * @param message the message to send
	 * @return the model
	 * @post the chat should contain your message
	 */
	public Model move_sendChat(String message);

	/**
	 * Respond to a trade offer
	 * @pre you have been offered a domestic trade
	 * @pre to accept the offered trade, you have the required resources
	 * @post if you accepted, you and the player who offered swap the specified resources
	 * @post if you declined no resources are exchanged
	 * @post the trade offer is removed
	 * @param willAccept whether or not you accept the offered trade
	 * @return the model
	 */
	public Model move_acceptTrade(boolean willAccept);

	/**
	 * Discard cards
	 * @pre the status of the client model is discarding
	 * @pre you have over 7 cards
	 * @pre you have the cards you're choosing to discard
	 * @post you give up the specified resources
	 * @post if you're the last one to discard, the client model status changes to Robbing
	 * @param toDiscard the cards you are discarding
	 * @return the model
	 */
	public Model move_discardCards(Bank toDiscard);

	/**
	 * Roll number
	 * @param number integer in the range 2-12
	 * @pre it is your turn
	 * @pre the client model's status is Rolling
	 * @post the Client model's status is now in discarding, robbing, or playing
	 * @return the model
	 */
	public Model move_rollNumber(int number);

	/**
	 * Builds a road
	 * @param free whether or not you get this piece for free
	 * @param edge the new road's location
	 * @pre the road location is open
	 * @pre the road location is connected to another road owned by teh player
	 * @pre the road location is not on water
	 * @pre you have the require resources
	 * @pre if in the setup rounds, must be placed by settlement owned by the player with no adjacent road
	 * @post you lost the resources required to build a road
	 * @post the road is on the map at the specified location
	 * @post if applicable, "longest road" has been awarded to the player with the longest road
	 * @return the model
	 */
	public Model move_buildRoad(boolean free, EdgeLocation edge);

	/**
	 * Builds a settlement on the model
	 * @param free whether or not you get this piece for free
	 * @param vertex the location of the settlement
	 * @return the model
	 * @pre the settlement location is open
	 * @pre the settlement location is not on water
	 * @pre the settlement location is connect to one of your roads except during setup
	 * @pre you have the required resources
	 * @pre the settlement cannot be placed adjacent to another settlement
	 * @post you lost the resources
	 * @post the settlement is on the map
	 */
	public Model move_buildSettlement(boolean free, VertexLocation vertex);

	/**
	 * Builds a city
	 * @param vertex the location of the city
	 * @return the model
	 * @pre the city location is where you currently have a settlement
	 * @pre you have the required resources
	 * @post you lost the resources required to build a city
	 * The city is on the map at the specified location
	 * You got a settlement back
	 */
	public Model move_buildCity(VertexLocation vertex);

	/**
	 * Creates a trade offer
	 * @param offer the specified offer
	 * @param playerIndex the index of the player to receive the trade
	 * @return the model
	 * @pre you have the resources you are offering
	 * @post the trade is offered to the otehr player
	 */
	public Model move_offerTrade(Bank offer, int playerIndex);

	/**
	 * Causes maritime trade
	 * @param ratio integer 2, 3 or 4
	 * @param inputResource what you are giving
	 * @param outputResource what you are getting
	 * @pre you have the resources you are giving
	 * @pre for ratios less than 4 you ahve the correct port fot he trade
	 * @return the model
	 * @post the trade has been executed
	 */
	public Model move_maritimeTrade(int ratio, Resource inputResource, Resource outputResource);

	/**
	 * Rob player
	 * @param location the new robber location
	 * @param victimIndex playerIndex, or -1 if you are not robbing anyone
	 * @return the model
	 * @pre the robber is not being kept in the same location
	 * If a player is being robbed, the player being robbed has resource cards
	 * @post the robber is in the new location
	 * @post the player being robbed gave you one of his resource cards
	 */
	public Model move_robPlayer(HexLocation location, int victimIndex);

	/**
	 * Finish your turn
	 * @post the card in your new dev card hand have been transferred to your old dev card hand
	 * @post it is the next player's turn
	 * @return the model
	 */
	public Model move_finishTurn();

	/**
	 * Draw a dev card
	 * @pre you have the required resources
	 * @pre there are dev cards left in the deck
	 * @return the model
	 * @post the cards in your new dev card hand have been transferred to your old dev card hand
	 * @post it is the next player's turn
	 */
	public Model move_buyDevCard();

	/**
	 * Play a soldier dev card
	 * @param location the new location for the robber
	 * @param victimIndex the player you are robbing
	 * @return the model
	 * @pre the robber is not being kept in the same location
	 * @pre if a player is being robbed, the player being robbed has resource cards
	 * @post the robber is in the new location
	 * @post the player being robbed gave you one of his resource cards
	 * @post if applicable, largest army has been awarded to the player who has played the most soldier cards
	 * @post you are not allowed to play other dev cards during this turn, except monument cards
	 */
	public Model move_soldier(HexLocation location, int victimIndex);

	/**
	 * Plays a year of plenty dev card
	 * @param resource1 the first resource you want
	 * @param resource2 the second resource you want to receive
	 * @return the model
	 * @pre the two specified resources are in the bank
	 * @post you gained the two specified resources
	 */
	public Model move_yearOfPlenty(Resource resource1, Resource resource2);

	/**
	 * Plays a road building dev card
	 * @param spot1 the first road
	 * @param spot2 the second road
	 * @pre the first road is connected to one of your roads
	 * @pre the second road location is connected to one of your roads or the first road location
	 * @pre neither road location is on water
	 * @pre you have at least two unused roads
	 * @post you have two fewer unused roads
	 * @post two new roads appear on the map at the specified locations
	 * @post if applicable, "longest road" has been awarded to the player with the longest road
	 * @return the model
	 */
	public Model move_roadBuilding(EdgeLocation spot1, EdgeLocation spot2);

	/**
	 * Plays a monopoly dev card
	 * @param resource the resouce being taken from the other players
	 * @post all of the other players have given you all of their resource cards of the specified type
	 * @return the model
	 */
	public Model move_monopoly(Resource resource);

	/**
	 * Plays a monument dev card
	 * @return the model
	 * @pre you have enough monument cards to win the game
	 * @post you gained a victory point
	 */
	public Model move_monument();




}
