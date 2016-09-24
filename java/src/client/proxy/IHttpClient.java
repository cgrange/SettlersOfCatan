package client.proxy;

public interface IHttpClient {
	
	/**
	 * Creates a post request at the given post location with the given request body
	 * @param postAddress The shortened command location to post at
	 * @param requestBody The body of the Post request
	 * @return The return result from the server
	 */
	public String post(String postAddress, String requestBody);
	
	/**
	 * The location to post at
	 * @param getAddress the location to get from
	 * @return the result of the get request
	 */
	public String get(String getAddress);

}
