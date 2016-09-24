package shared.locations;

public enum VertexDirection
{
	West, NorthWest, NorthEast, East, SouthEast, SouthWest;
	
	private VertexDirection opposite;
	public String shortName;
	
	static
	{
		West.opposite = East;
		NorthWest.opposite = SouthEast;
		NorthEast.opposite = SouthWest;
		East.opposite = West;
		SouthEast.opposite = NorthWest;
		SouthWest.opposite = NorthEast;
	}
	
	static
	{
		West.shortName = "W";
		NorthWest.shortName = "NW";
		NorthEast.shortName = "NE";
		East.shortName = "E";
		SouthEast.shortName = "SE";
		SouthWest.shortName = "SW";
	}
	
	public VertexDirection getOppositeDirection()
	{
		return opposite;
	}
}

