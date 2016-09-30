package shared.model.communication;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.model.communication.Communication;

public class CommunicationDeserializationTest {

	@Test
	public void test() {
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

}
