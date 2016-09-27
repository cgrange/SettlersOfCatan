package client.proxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpClient implements IHttpClient {
	
	private static String baseURL = "http://localhost:8081";
	private String catanCookie = "";
	private String gameCookie = "";
	
	public String getCatanCookie() {
		return catanCookie;
	}

	public String getGameCookie() {
		return gameCookie;
	}

	private String getResponseBody(HttpURLConnection connection) throws IOException {
		readCookies(connection);
		
		// Get response body input stream
		InputStream responseBody = connection.getInputStream();

		// Read response body bytes
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = responseBody.read(buffer)) != -1) {
		    baos.write(buffer, 0, length);
		}

		// Convert response body bytes to a string
		String responseBodyData = baos.toString();
		return responseBodyData;
	}
	
	private void manageCookies(String shortAddress, HttpURLConnection connection){
		String cookieValue = "";
		if(!shortAddress.contains("/user"))
		{
			cookieValue = catanCookie;
		}
		if(!shortAddress.contains("/games/"))
		{
			cookieValue = cookieValue + gameCookie;
		}
		connection.setRequestProperty("Cookie", cookieValue);
	}
	
	private void readCookies(HttpURLConnection connection)
	{
		Map<String, List<String>> headers = connection.getHeaderFields();
		if(headers.containsKey("Set-cookie"))
		{
			String setKey = headers.get("Set-cookie").get(0);
			if(setKey.contains("catan.user"))
			{
				this.catanCookie = setKey.replace(";Path=/;", "");
			}
			if(setKey.contains("catan.game"))
			{
				this.gameCookie = "; " + setKey.replace(";Path=/;", "");
			}
		}
	}

	@Override
	public String post(String postAddress, String requestBodyString) {
		try 
		{
			URL url = new URL(baseURL + postAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            manageCookies(postAddress, connection);
            OutputStream requestBody = connection.getOutputStream();
            requestBody.write(requestBodyString.getBytes());
            requestBody.close();
            
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return getResponseBody(connection);
            }
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
            return e.getMessage();
        }
		return "No return value";
	}

	@Override
	public String get(String getAddress) {
		try 
		{
			URL url = new URL(baseURL + getAddress);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
			connection.setRequestMethod("GET");
            manageCookies(getAddress, connection);

			connection.connect();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return getResponseBody(connection);
            }
		}
		catch (Exception e) {
        	System.out.println(e.getMessage());
            return e.getMessage();
        }
		return "No return value";
	}

}
