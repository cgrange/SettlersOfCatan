package client.proxy;

public class MockClient implements IHttpClient {
	
	String lastAddress = "";
	String lastBody = "";

	public String getLastAddress() {
		return lastAddress;
	}

	public String getLastBody() {
		return lastBody;
	}

	@Override
	public String post(String postAddress, String requestBody) {
		lastAddress = postAddress;
		lastBody = requestBody;
		return null;
	}

	@Override
	public String get(String getAddress) {
		lastAddress = getAddress;
		lastBody = "";
		return null;
	}

}
