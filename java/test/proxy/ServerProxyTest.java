package client.proxy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import client.overview.SimpleGame;
import client.proxy.IHttpClient;
import client.proxy.MockClient;
import client.proxy.ServerProxy;
import shared.definitions.CatanColor;
import shared.definitions.ResourceType;
import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;
import shared.model.Model;
import shared.model.resources.Bank;
import shared.model.resources.Resource;

/**
 * This class is designed to test the inputs of the ServerProxy
 * especially that ServerProxy is serializing post requests correctly
 *
 */
public class ServerProxyTest {
	
	ServerProxy proxy;
	MockClient client;
	
	public void arrange()
	{
		proxy = new ServerProxy();
		client = new MockClient();
		proxy.setHttpClient(client);
	}

	@Test
	public void user_loginTest() { 
		arrange(); 
		//act
		proxy.user_login("username", "password");
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("username").getAsString().equals("username"));
		assertTrue(request.get("password").getAsString().equals("password"));

	}

	@Test
	public void user_registerTest() { 
		arrange();
		//act
		proxy.user_register("username", "password");;
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("username").getAsString().equals("username"));
		assertTrue(request.get("password").getAsString().equals("password"));

	}

	@Test
	public void games_createTest() { 
		arrange();
		//act
		proxy.games_create(true, true, true, "name");
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("randomTiles").getAsString().equals("true"));
		assertTrue(request.get("randomNumbers").getAsString().equals("true"));
		assertTrue(request.get("randomPorts").getAsString().equals("true"));
		assertTrue(request.get("name").getAsString().equals("name"));
	}

	@Test
	public void games_joinTest() { 
		arrange();
		//act
		proxy.games_join(7, CatanColor.BLUE);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("id").getAsString().equals("7"));
		assertTrue(request.get("color").getAsString().equals("blue"));

	}

	@Test
	public void games_saveTest() { 
		arrange();
		//act
		proxy.games_save(7, "name");
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("id").getAsString().equals("7"));
		assertTrue(request.get("name").getAsString().equals("name"));

	}

	@Test
	public void games_loadTest() { 
		arrange();
		//act
		proxy.games_load("name");;
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("name").getAsString().equals("name"));

	}

	@Test
	public void game_addAITest() { 
		arrange();
		//act
		proxy.game_addAI("AIType");
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("AIType").getAsString().equals("AIType"));
	}

	@Test
	public void util_changeLogLevelTest() { 
		arrange();
		//act
		proxy.util_changeLogLevel("level");
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("logLevel").getAsString().equals("level"));

	}
	

	@Test
	public void move_sendChatTest() { 
		arrange();
		//act
		proxy.move_sendChat("message", 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("sendChat"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("content").getAsString().equals("message"));

	}

	@Test
	public void move_acceptTradeTest() { 
		arrange();
		//act
		proxy.move_acceptTrade(true, 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("acceptTrade"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("willAccept").getAsString().equals("true"));

	}
	
	private static void assertEmptyBank(JsonObject object)
	{
		assertTrue(object.get("brick").getAsString().equals("0"));
		assertTrue(object.get("ore").getAsString().equals("0"));
		assertTrue(object.get("sheep").getAsString().equals("0"));
		assertTrue(object.get("wheat").getAsString().equals("0"));
		assertTrue(object.get("wood").getAsString().equals("0"));

	}

	@Test
	public void move_discardCardsTest() { 
		arrange();
		//act
		proxy.move_discardCards(new Bank(), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("discardCards"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertEmptyBank(request.get("discardedCards").getAsJsonObject());

	}

	@Test
	public void move_rollNumberTest() { 
		arrange();
		//act
		proxy.move_rollNumber(12, 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("rollNumber"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("number").getAsString().equals("12"));

	}
	
	public static void assertLocation(JsonObject request)
	{
		assertHexLocation(request);
		assertTrue(request.get("direction").getAsString().equals("NE"));
	}

	private static void assertHexLocation(JsonObject request) {
		assertTrue(request.get("x").getAsString().equals("0"));
		assertTrue(request.get("y").getAsString().equals("0"));
	}

	@Test
	public void move_buildRoadTest() { 
		arrange();
		//act
		proxy.move_buildRoad(false, new EdgeLocation(new HexLocation(0,0),EdgeDirection.NorthEast), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("buildRoad"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertLocation(request.get("roadLocation").getAsJsonObject());
		assertTrue(request.get("free").getAsString().equals("false"));


	}

	@Test
	public void move_buildSettlementTest() { 
		arrange();
		//act
		proxy.move_buildSettlement(true, new VertexLocation(new HexLocation(0,0), VertexDirection.NorthEast), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("buildSettlement"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("free").getAsString().equals("true"));
		assertLocation(request.get("vertexLocation").getAsJsonObject());
	}

	@Test
	public void move_buildCityTest() { 
		arrange();
		//act
		proxy.move_buildCity( new VertexLocation(new HexLocation(0,0), VertexDirection.NorthEast), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("buildCity"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertLocation(request.get("vertexLocation").getAsJsonObject());

	}

	@Test
	public void move_offerTradeTest() { 
		arrange();
		//act
		proxy.move_offerTrade(new Bank(), 0, 0);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("offerTrade"));
		assertTrue(request.get("playerIndex").getAsString().equals("0"));
		assertTrue(request.get("receiver").getAsString().equals("0"));
		assertEmptyBank(request.get("offer").getAsJsonObject());

	}

	@Test
	public void move_maritimeTradeTest() { 
		arrange();
		//act
		proxy.move_maritimeTrade(3, new Resource(ResourceType.BRICK, 3), new Resource(ResourceType.ORE, 3), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("maritimeTrade"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("ratio").getAsString().equals("3"));
		assertTrue(request.get("inputResource").getAsString().equals("brick"));
		assertTrue(request.get("outputResource").getAsString().equals("ore"));


	}

	@Test
	public void move_robPlayerTest() { 
		arrange();
		//act
		proxy.move_robPlayer(new HexLocation(0,0), 0, 0);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("robPlayer"));
		assertTrue(request.get("playerIndex").getAsString().equals("0"));
		assertTrue(request.get("victimIndex").getAsString().equals("0"));
		assertHexLocation(request.get("location").getAsJsonObject());

	}

	@Test
	public void move_finishTurnTest() { 
		arrange();
		//act
		proxy.move_finishTurn(3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("finishTurn"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));

	}

	@Test
	public void move_buyDevCardTest() { 
		arrange();
		//act
		proxy.move_buyDevCard(3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("buyDevCard"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));

	}

	@Test
	public void move_soldierTest() { 
		arrange();
		//act
		proxy.move_soldier(new HexLocation(0,0), 3, 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("Soldier"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("victimIndex").getAsString().equals("3"));
		assertHexLocation(request.get("location").getAsJsonObject());

	}

	@Test
	public void move_yearOfPlentyTest() { 
		arrange();
		//act
		proxy.move_yearOfPlenty(new Resource(ResourceType.BRICK,0), new Resource(ResourceType.SHEEP, 0), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("Year_of_Plenty"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertTrue(request.get("resource1").getAsString().equals("brick"));
		assertTrue(request.get("resource2").getAsString().equals("sheep"));

	}

	@Test
	public void move_roadBuildingTest() { 
		arrange();
		//act
		proxy.move_roadBuilding(new EdgeLocation(new HexLocation(0,0), EdgeDirection.NorthEast), new EdgeLocation(new HexLocation(0,0), EdgeDirection.NorthEast), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("Road_Building"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));
		assertLocation(request.get("spot1").getAsJsonObject());
		assertLocation(request.get("spot2").getAsJsonObject());

	}

	@Test
	public void move_monopolyTest() { 
		arrange();
		//act
		proxy.move_monopoly(new Resource(ResourceType.WOOD,0), 3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("Monopoly"));
		assertTrue(request.get("resource").getAsString().equals("wood"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));

	}

	@Test
	public void move_monumentTest() { 
		arrange();
		//act
		proxy.move_monument(3);
		
		//assert
		JsonObject request = new JsonParser().parse(client.getLastBody()).getAsJsonObject();
		assertTrue(request.get("type").getAsString().equals("Monument"));
		assertTrue(request.get("playerIndex").getAsString().equals("3"));

	}
}
