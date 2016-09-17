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

public class ServerProxy implements IProxy {

	@Override
	public void user_login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void user_register() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SimpleGame> games_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleGame games_create(boolean randomTiles, boolean randomNumbers, boolean randomPorts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String games_join(int id, CatanColor color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void games_save(int id) {
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
	public Model game_commands_get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void game_commands_post(List<String> commands) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> game_listAI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleGame game_addAI(String AIType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void util_changeLogLevel(String level) {
		// TODO Auto-generated method stub

	}

	@Override
	public Model move_sendChat(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_acceptTrade(boolean willAccept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_discardCards(Bank toDiscard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_rollNumber(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buildRoad(boolean free, EdgeLocation edge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buildSettlement(boolean free, VertexLocation vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buildCity(VertexLocation vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_offerTrade(Bank offer, int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_maritimeTrade(int ratio, Resource inputResource, Resource outputResource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_robPlayer(HexLocation location, int victimIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_finishTurn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_buyDevCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_soldier(HexLocation location, int victimIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_yearOfPlenty(Resource resource1, Resource resource2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_roadBuilding(EdgeLocation spot1, EdgeLocation spot2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_monopoly(Resource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model move_monument() {
		// TODO Auto-generated method stub
		return null;
	}

}
