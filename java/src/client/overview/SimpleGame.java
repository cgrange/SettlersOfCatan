package client.overview;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * A class to give simple overview game information when selecting a game
 *
 */
public class SimpleGame {
	private String title;
	private int id;
	private List<SimplePlayer> players;
	
	public SimpleGame(String jsonString)
	{
		if(jsonString == null)
		{
			return;
		}
		JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
		title = jsonObject.get("title").getAsString();
		id = jsonObject.get("id").getAsInt();
		JsonArray playerArray = jsonObject.get("players").getAsJsonArray();
		players = new ArrayList<SimplePlayer>();
		for(JsonElement player:playerArray)
		{
			players.add(new SimplePlayer(player.toString()));
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getId() {
		return id;
	}
	
	public List<SimplePlayer> getPlayers() {
		return players;
	}

	@Override
	public String toString() {
		return "SimpleGame [title=" + title + ", id=" + id + ", players=" + players + "]";
	}
		
	
}
