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
	
	public static EdgeDirection getEdgeDirection(String directionStr) throws Exception{
		if(directionStr.equalsIgnoreCase("N")){
			return EdgeDirection.North;
		}
		else if(directionStr.equalsIgnoreCase("NE")){
			return EdgeDirection.NorthEast;
		}
		else if(directionStr.equalsIgnoreCase("SE")){
			return EdgeDirection.SouthEast;
		}
		else if(directionStr.equalsIgnoreCase("S")){
			return EdgeDirection.South;
		}
		else if(directionStr.equalsIgnoreCase("SW")){
			return EdgeDirection.SouthWest;
		}
		else if(directionStr.equalsIgnoreCase("NW")){
			return EdgeDirection.NorthWest;
		}
		else{
			throw new Exception("the direction string is not what I expected");
		}
	}
	
	public EdgeDirection getOppositeDirection()
	{
		return opposite;
	}
	
}

