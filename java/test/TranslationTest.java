package test;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.definitions.CatanColor;
import shared.definitions.HexType;
import shared.definitions.ResourceType;
import shared.definitions.Status;
import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;
import shared.locations.VertexLocation;
import shared.model.communication.Communication;
import shared.model.map.City;
import shared.model.map.Hex;
import shared.model.map.Port;
import shared.model.map.Road;
import shared.model.map.Robber;
import shared.model.map.Settlement;
import shared.model.players.Player;
import shared.model.players.TurnTracker;
import shared.model.resources.Bank;
import shared.model.resources.TradeOffer;

import com.google.gson.Gson;

public class TranslationTest {
	
	@Test
	public void HexLocationTranslationTest() {
		Gson gson = new Gson();
		HexLocation location = new HexLocation(1, 2);
		String json = gson.toJson(location);
		HexLocation location2 = new HexLocation(json);
		assertTrue(location.equals(location2));
	}
	
	@Test
	public void BankTranslationTest() {
		Bank bank = new Bank("{ \"brick\":1, \"ore\":2, \"sheep\":3, \"wheat\":4, \"wood\":5 }");
		assertTrue(bank.getResource(ResourceType.BRICK).getAmount() == 1);
		assertTrue(bank.getResource(ResourceType.ORE).getAmount() == 2);
		assertTrue(bank.getResource(ResourceType.SHEEP).getAmount() == 3);
		assertTrue(bank.getResource(ResourceType.WHEAT).getAmount() == 4);
		assertTrue(bank.getResource(ResourceType.WOOD).getAmount() == 5);
	}
	
	@Test
	public void TradeOfferTranslationTest() {
		TradeOffer trade = new TradeOffer("{ \"sender\":1, \"receiver\":2, \"offer\":{ \"brick\":5, \"ore\":4, \"sheep\":3, \"wheat\":2, \"wood\":1 } }");
		assertTrue(trade.getSender().equals(Player.get(1)));
		assertTrue(trade.getReceiver().equals(Player.get(2)));
		assertTrue(trade.getSenderGive().equals(new Bank("{ \"brick\":5, \"ore\":4, \"sheep\":3, \"wheat\":2, \"wood\":1 }")));
	}
	
	@Test
	public void TurnTrackerTranslationTest() {
		try {
			TurnTracker turnTracker = new TurnTracker("{ \"status\": \"Rolling\", \"currentTurn\": 0, \"longestRoad\": -1, \"largestArmy\": -1 }");
			assertTrue(turnTracker.getStatus() == Status.ROLLING);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertTrue(1==2);
		}
	}
	
	@Test
	  public void PlayerTranslationTest(){
			try {
				Player player = new Player("{ \"resources\": { \"brick\": 0, \"wood\": 1, \"sheep\": 1, \"wheat\": 1, \"ore\": 0 }, \"oldDevCards\": { \"yearOfPlenty\": 0, \"monopoly\": 0, \"soldier\": 0, \"roadBuilding\": 0, \"monument\": 0 }, \"newDevCards\": { \"yearOfPlenty\": 0, \"monopoly\": 0, \"soldier\": 0, \"roadBuilding\": 0, \"monument\": 0 }, \"roads\": 13, \"cities\": 4, \"settlements\": 3, \"soldiers\": 0, \"victoryPoints\": 2, \"monuments\": 0, \"playedDevCard\": false, \"discarded\": false, \"playerID\": 0, \"playerIndex\": 0, \"name\": \"Sam\", \"color\": \"orange\" }");
				assertEquals(player.getColor(), CatanColor.ORANGE); 
				assertTrue(player.getName().equals("Sam"));
				//assertEquals(player.getNumberOfCities(),4);
				assertEquals(player.getNumberOfMonuments(),0);
				//assertEquals(player.getNumberOfRoads(),13);
				//assertEquals(player.getNumberOfSettlements(),3);
				assertEquals(player.getNumberOfSoldiers(),0);
				assertEquals(player.getPoints(),2);
				assertEquals(player.getPlayerIndex(),0);
				assertEquals(player.getPlayerID(),0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				assertEquals(1,2);
			}
	  }
	
	@Test
	public void PortTranslationTest() {
		try {
			Port port = new Port(" {\"resource\":\"whEat\",\"location\":{ \"x\":2, \"y\":2 },\"direction\":\"N\",\"ratio\":2} ");
			assertTrue(port.getOwner() == null);
			assertTrue(port.getEdgeLocation().equals(new EdgeLocation(new HexLocation(2,2), EdgeDirection.getEdgeDirection("N"))));
			assertTrue(port.getResourcesRequired() == 2);
			assertTrue(port.getResourceType() == ResourceType.WHEAT);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(1 == 2);
		}
	}
	
	@Test
	public void HexTranslationTest() {
		try{
			Hex hex = new Hex("{ \"location\":{ \"x\":1, \"y\":2 }, \"resource\":\"BrIck\", \"number\":8 }");
			assertTrue(hex.getChit() == 8);
			assertTrue(hex.getLocation().equals(new HexLocation(1, 2)));
			assertTrue(hex.getHexType() == HexType.BRICK);
		}
		catch(Exception e){
			e.printStackTrace();
			assertTrue(1 == 2);
		}
	}
	
	@Test
	public void cityTranslationTest() {
		try {
			City city = new City(" { \"owner\":1, \"location\":{ \"x\":2, \"y\":2, \"direction\":\"W\" } } ");
			VertexLocation vLocation = new VertexLocation(new HexLocation(2,2), VertexDirection.getVertexDirection("W"));
			assertTrue(city.getLocation().equals(vLocation));
			assertTrue(city.getPointValue() == 2);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(1==2);
		}
	}
	
	@Test
	public void settlementTranslationTest() {
		try {
			Settlement settlement = new Settlement(" { \"owner\":2, \"location\":{ \"x\":1, \"y\":1, \"direction\":\"E\" } } ");
			VertexLocation vLocation = new VertexLocation(new HexLocation(1,1), VertexDirection.getVertexDirection("E"));
			assertTrue(settlement.getLocation().equals(vLocation));
			assertTrue(settlement.getPointValue() == 1);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(1==2);
		}
	}
	
	@Test
	public void communicationTranslationTest() {
		try{
			Communication comm = new Communication("{ \"lines\": [] } ", "{ \"lines\": [ { \"source\": \"Sam\", \"message\": \"Sam built a road\" }, { \"source\": \"Sam\", \"message\": \"Sam built a settlement\" } ] }");
			assertTrue(comm.getChatList().size() == 0);
			assertTrue(comm.getLogList().size() == 2);
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertTrue(1==2);
		}
	}
	
	@Test 
	public void robberTranslationTest(){
		Robber robber = new Robber("{ \"x\": 0, \"y\": -2 }");
		HexLocation testLocation = new HexLocation("{ \"x\": 0, \"y\": -2 }");
		assertTrue(robber.getLocation().equals(testLocation));
	}
	
	@Test 
	public void roadTranslationTest(){
		Road road;
		try {
			road = new Road("{ \"owner\": 1, \"location\": { \"direction\": \"S\", \"x\": -1, \"y\": -1 } }");
			EdgeLocation testLocation = new EdgeLocation("{ \"direction\": \"S\", \"x\": -1, \"y\": -1 }");
			assertTrue(road.getLocation().equals(testLocation));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertEquals(1,2);
		}
	}
/*
	@Test
	public void mapTranslationTest(){
		//TODO implement
	}
	
	@Test
	public void tradeOfferTranslationTest(){
		//TradeOffer tradeOffer = new TradeOffer("");//TODO find a legitimate trade offer
	}
	
	@Test
	public void modelTranslationTest(){
		//TODO implement
	}
*/
}
