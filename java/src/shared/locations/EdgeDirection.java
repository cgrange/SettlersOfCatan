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
		if(directionStr.equalsIgnoreCase("north")){
			return EdgeDirection.North;
		}
		else if(directionStr.equalsIgnoreCase("north east")){
			return EdgeDirection.NorthEast;
		}
		else if(directionStr.equalsIgnoreCase("sout east")){
			return EdgeDirection.SouthEast;
		}
		else if(directionStr.equalsIgnoreCase("south")){
			return EdgeDirection.South;
		}
		else if(directionStr.equalsIgnoreCase("south west")){
			return EdgeDirection.SouthWest;
		}
		else if(directionStr.equalsIgnoreCase("north west")){
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

