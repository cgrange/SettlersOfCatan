package test;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.model.players.Player;
import shared.model.resources.Bank;
import shared.model.resources.TradeOffer;

public class TradeOfferTest {
	
	@Test
	public void test() {
		TradeOffer trade = new TradeOffer("{ \"sender\":1, \"receiver\":2, \"offer\":{ \"brick\":5, \"ore\":4, \"sheep\":3, \"wheat\":2, \"wood\":1 } }");
		assertTrue(trade.getSender().equals(Player.get(1)));
		assertTrue(trade.getReceiver().equals(Player.get(2)));
		assertTrue(trade.getSenderGive().equals(new Bank("{ \"brick\":5, \"ore\":4, \"sheep\":3, \"wheat\":2, \"wood\":1 }")));
	}

}
