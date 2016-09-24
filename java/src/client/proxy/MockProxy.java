package client.proxy;

import java.util.List;

import com.google.gson.JsonObject;

import client.overview.SimpleGame;
import shared.definitions.CatanColor;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;
import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.resources.Resource;

public class MockProxy implements IProxy {

	@Override
	public void user_login(String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void user_register(String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SimpleGame> games_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleGame games_create(boolean randomTiles, boolean randomNumbers, boolean randomPorts, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void games_join(int id, CatanColor color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void games_save(int id, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void games_load(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Model game_model(int versionNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model game_reset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String game_commands_get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model game_commands_post(String commands) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> game_listAI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void game_addAI(String AIType) {
		// TODO Auto-generated method stub
	}

	@Override
	public void util_changeLogLevel(String level) {
		// TODO Auto-generated method stub

	}

	@Override
	public Model move_sendChat(String message, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_acceptTrade(boolean willAccept, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_discardCards(Bank toDiscard, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_rollNumber(int number, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buildRoad(boolean free, EdgeLocation edge, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buildSettlement(boolean free, VertexLocation vertex, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buildCity(VertexLocation vertex, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_offerTrade(Bank offer, int playerIndex, int receiverIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_maritimeTrade(int ratio, Resource inputResource, Resource outputResource, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_robPlayer(HexLocation location, int victimIndex, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_finishTurn(int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buyDevCard(int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_soldier(HexLocation location, int victimIndex, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_yearOfPlenty(Resource resource1, Resource resource2, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_roadBuilding(EdgeLocation spot1, EdgeLocation spot2, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_monopoly(Resource resource, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_monument(int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
