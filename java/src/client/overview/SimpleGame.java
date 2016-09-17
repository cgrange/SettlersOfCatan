package client.overview;

import java.util.List;

/**
 * A class to give simple overview game information when selecting a game
 *
 */
public class SimpleGame {
	private String title;
	private int id;
	private List<SimplePlayer> players;
	
	public String getTitle() {
		return title;
	}
	
	public int getId() {
		return id;
	}
	
	public List<SimplePlayer> getPlayers() {
		return players;
	}
		
}
