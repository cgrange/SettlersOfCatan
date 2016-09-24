package shared.locations;

public enum EdgeDirection
{
	
	NorthWest, North, NorthEast, SouthEast, South, SouthWest;
	
	private EdgeDirection opposite;
	public String shortName;
	
	static
	{
		NorthWest.opposite = SouthEast;
		North.opposite = South;
		NorthEast.opposite = SouthWest;
		SouthEast.opposite = NorthWest;
		South.opposite = North;
		SouthWest.opposite = NorthEast;
	}
	
	static
	{
		North.shortName = "N";
		NorthWest.shortName = "NW";
		NorthEast.shortName = "NE";
		South.shortName = "S";
		SouthEast.shortName = "SE";
		SouthWest.shortName = "SW";
	}
	
	public EdgeDirection getOppositeDirection()
	{
		return opposite;
	}
}

