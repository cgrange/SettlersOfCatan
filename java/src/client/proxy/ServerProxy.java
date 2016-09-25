package client.proxy;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import client.overview.SimpleGame;
import shared.definitions.CatanColor;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.resources.Resource;

public class ServerProxy implements IProxy {
	
	private IHttpClient httpClient = new HttpClient();
	
	/**
	 * For testing purposes, we can add an IHttpClient so that it will construct the request, but not actually send it
	 * @param client the client to send the response with
	 */
	public void setHttpClient(IHttpClient client)
	{
		this.httpClient = client;
	}
	
	public IHttpClient getHttpClient()
	{
		return this.httpClient;
	}

	@Override
	public void user_login(String username, String password) {
		JsonObject dataSet = new JsonObject();
		dataSet.addProperty("username", username);
		dataSet.addProperty("password", password);
		httpClient.post("/user/login", dataSet.toString());
	}

	@Override
	public void user_register(String username, String password) {
		JsonObject credentials = new JsonObject();
		credentials.addProperty("username", username);
		credentials.addProperty("password", password);
		httpClient.post("/user/register", credentials.toString());
	}

	@Override
	public List<SimpleGame> games_list() {
		String data = httpClient.get("games/list");
		// TODO: Create this
		return null;
	}

	@Override
	public SimpleGame games_create(boolean randomTiles, boolean randomNumbers, boolean randomPorts, String name) {
		JsonObject newGame = new JsonObject();
		newGame.addProperty("randomTiles", randomTiles);
		newGame.addProperty("randomNumbers", randomNumbers);
		newGame.addProperty("randomPorts", randomPorts);
		newGame.addProperty("name", name);
		String data = httpClient.post("/games/create", newGame.toString());
		return new SimpleGame(data);
	}

	@Override
	public void games_join(int id, CatanColor color) {
		JsonObject request = new JsonObject();
		request.addProperty("id", id);
		request.addProperty("color", color.name().toLowerCase());
		httpClient.post("/games/join", request.toString());
	}

	@Override
	public void games_save(int id, String name) {
		JsonObject request = new JsonObject();
		request.addProperty("id", id);
		request.addProperty("name", name);
		httpClient.post("/games/save", request.toString());
	}

	@Override
	public void games_load(String name) {
		JsonObject request = new JsonObject();
		request.addProperty("name", name);
		httpClient.post("/games/load", request.toString());
	}

	@Override
	public Model game_model(int versionNumber) {
		String data = httpClient.get("game/model?version=" + versionNumber);
		if (data != "true")
		{
			return new Model(data);
		}
		return null;
	}

	@Override
	public Model game_reset() {
		return new Model(httpClient.post("/game/reset", ""));
	}

	@Override
	public String game_commands_get() {
		return httpClient.get("/game/commands");
	}

	@Override
	public Model game_commands_post(String commands) {
		return new Model(httpClient.post("/game/commands", commands));
	}

	@Override
	public List<String> game_listAI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void game_addAI(String AIType) {
		JsonObject request = new JsonObject();
		request.addProperty("AIType", AIType);
		httpClient.post("/game/addAI", request.toString());
	}

	@Override
	public void util_changeLogLevel(String level) {
		JsonObject request = new JsonObject();
		request.addProperty("logLevel", level);
		httpClient.post("/util/changeLogLevel", request.toString());
	}
	
	private static JsonObject getIntializedRequest(String type, int playerIndex)
	{
		JsonObject request = new JsonObject();
		request.addProperty("type", type);
		request.addProperty("playerIndex", playerIndex);
		return request;
	}

	@Override
	public Model move_sendChat(String message, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("sendChat", playerIndex);
		request.addProperty("content", message);
		return new Model(httpClient.post("/moves/sendChat", request.toString()));
	}

	@Override
	public Model move_acceptTrade(boolean willAccept, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("acceptTrade", playerIndex);
		request.addProperty("willAccept", willAccept);
		return new Model(httpClient.post("/moves/acceptTrade", request.toString()));
	}

	@Override
	public Model move_discardCards(Bank toDiscard, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("discardCards", playerIndex);
		request.add("discardedCards", toDiscard.serialize());
		return new Model(httpClient.post("/moves/sendChat", request.toString()));
	}

	@Override
	public Model move_rollNumber(int number, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("rollNumber", playerIndex);
		request.addProperty("number", number);
		return new Model(httpClient.post("/moves/rollNumber", request.toString()));
	}

	@Override
	public Model move_buildRoad(boolean free, EdgeLocation edge, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("buildRoad", playerIndex);
		request.add("roadLocation", edge.serialize());
		request.addProperty("free", free);
		return new Model(httpClient.post("/moves/buildRoad", request.toString()));
	}

	@Override
	public Model move_buildSettlement(boolean free, VertexLocation vertex, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("buildSettlement", playerIndex);
		request.add("vertexLocation", vertex.serialize());
		request.addProperty("free", free);
		return new Model(httpClient.post("/moves/buildSettlement", request.toString()));
	}

	@Override
	public Model move_buildCity(VertexLocation vertex, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("buildCity", playerIndex);
		request.add("vertexLocation", vertex.serialize());
		return new Model(httpClient.post("/moves/buildCity", request.toString()));
	}

	@Override
	public Model move_offerTrade(Bank offer, int playerIndex, int receiverIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("offerTrade", playerIndex);
		request.add("offer", offer.serialize());
		request.addProperty("receiver", receiverIndex);
		return new Model(httpClient.post("/moves/offerTrade", request.toString()));
	}

	@Override
	public Model move_maritimeTrade(int ratio, Resource inputResource, Resource outputResource, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("maritimeTrade", playerIndex);
		request.addProperty("ratio", ratio);
		request.addProperty("inputResource", inputResource.getType().name().toLowerCase());
		request.addProperty("outputResource", outputResource.getType().name().toLowerCase());
		return new Model(httpClient.post("/moves/maritimeTrade", request.toString()));
	}

	@Override
	public Model move_robPlayer(HexLocation location, int victimIndex, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("robPlayer", playerIndex);
		request.addProperty("victimIndex", victimIndex);
		JsonObject loc = new JsonObject();
		loc.addProperty("x", location.getX());
		loc.addProperty("y", location.getY());
		request.add("location", loc);
		return new Model(httpClient.post("/moves/buildRoad", request.toString()));
	}

	@Override
	public Model move_finishTurn(int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("finishTurn", playerIndex);
		return new Model(httpClient.post("/moves/finishTurn", request.toString()));
	}

	@Override
	public Model move_buyDevCard(int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("buyDevCard", playerIndex);
		return new Model(httpClient.post("/moves/buyDevCard", request.toString()));
	}

	@Override
	public Model move_soldier(HexLocation location, int victimIndex, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("Soldier", playerIndex);
		request.addProperty("victimIndex", victimIndex);
		JsonObject loc = new JsonObject();
		loc.addProperty("x", location.getX());
		loc.addProperty("y", location.getY());
		request.add("location", loc);
		return new Model(httpClient.post("/moves/Soldier", request.toString()));
	}

	@Override
	public Model move_yearOfPlenty(Resource resource1, Resource resource2, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("Year_of_Plenty", playerIndex);
		request.addProperty("resource1", resource1.getType().name().toLowerCase());
		request.addProperty("resource2", resource2.getType().name().toLowerCase());
		return new Model(httpClient.post("/moves/Year_of_Plenty", request.toString()));
	}

	@Override
	public Model move_roadBuilding(EdgeLocation spot1, EdgeLocation spot2, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("road_Building", playerIndex);
		request.add("spot1", spot1.serialize());
		request.add("spot2", spot1.serialize());
		return new Model(httpClient.post("/moves/road_Building", request.toString()));
	}

	@Override
	public Model move_monopoly(Resource resource, int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("Monopoly", playerIndex);
		request.addProperty("resource", resource.getType().name().toLowerCase());
		return new Model(httpClient.post("/moves/Monopoly", request.toString()));
	}

	@Override
	public Model move_monument(int playerIndex) {
		JsonObject request = ServerProxy.getIntializedRequest("Monument", playerIndex);
		return new Model(httpClient.post("/moves/Monument", request.toString()));
	}

}
