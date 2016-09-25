package client.proxy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.proxy.ServerProxy;
import shared.definitions.CatanColor;
import client.overview.SimpleGame;
import client.proxy.HttpClient;

/**
 * This class is designed to test the HttpClient class, which is responsible for cookies, post requests,
 * and get requests.
 *
 */
public class HttpClientTest {
	
	/**
	 * This tests that cookies are being properly set and used
	 */
	@Test
	public void cookieTest()
	{
		//arrange
		ServerProxy proxy = new ServerProxy();

		//act
		proxy.user_login("Sam", "sam");
		proxy.games_join(0, CatanColor.ORANGE);

		//assert
		HttpClient client = ((HttpClient)proxy.getHttpClient());
		assertTrue(client.getCatanCookie() != "");
		assertTrue(client.getGameCookie() != "");
		
	}
	
	/**
	 * This tests that the HTTP Get request is working
	 */
	@Test
	public void getTest()
	{
		//arrange
		ServerProxy proxy = new ServerProxy();
		
		//act
		proxy.user_login("Sam", "sam");
		List<SimpleGame> games = proxy.games_list();
		
		//assert
		assertTrue(games.get(0).getTitle().equals("Default Game"));
	}
}
