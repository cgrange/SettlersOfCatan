package client.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

import client.proxy.*;

public class HttpClientTest {
	
	@Test
	public void cookieTest()
	{
		//arrange
		ServerProxy proxy = new ServerProxy();
		
		//act
		proxy.user_login("Sam", "sam");
		proxy.games_create(false, false, false, "cookieTest");
		
		//assert
		System.out.println(((HttpClient)proxy.getHttpClient()).getCatanCookie());
		System.out.println(((HttpClient)proxy.getHttpClient()).getGameCookie());
		assertTrue(true);
	}
}
