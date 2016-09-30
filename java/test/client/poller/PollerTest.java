package client.poller;

import client.poller.*;
import static org.junit.Assert.*;
import client.proxy.*;
import org.junit.Test;


public class PollerTest {

	@Test
	public void PollerTest() throws Exception {
		assertFalse(Poller.resetHasBeenRun());
		Poller.setTimer(new MockProxy());
		
		Thread.sleep(3000);
		assertTrue(Poller.resetHasBeenRun());
		assertFalse(Poller.resetHasBeenRun());
	}
}

