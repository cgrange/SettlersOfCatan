package client.overview;

import shared.definitions.CatanColor;

/**
 * A simple class to give overview information about players in a game overview
 *
 */
public class SimplePlayer {
	private CatanColor color;
	private String name;
	private int id;
	
	public SimplePlayer(String jsonString)
	{
		//TODO: Implement
		color = CatanColor.BLUE;
		name = "";
		id = 0;
	}
	
	public CatanColor getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
}
