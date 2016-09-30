package shared.locations;

public enum VertexDirection
{
	West, NorthWest, NorthEast, East, SouthEast, SouthWest;
	
	private VertexDirection opposite;
	public String shortName;
	
	public static VertexDirection getVertexDirection(String directionStr) throws Exception{
		if(directionStr.equalsIgnoreCase("E")){
			return VertexDirection.East;
		}
		else if(directionStr.equalsIgnoreCase("NE")){
			return VertexDirection.NorthEast;
		}
		else if(directionStr.equalsIgnoreCase("SE")){
			return VertexDirection.SouthEast;
		}
		else if(directionStr.equalsIgnoreCase("W")){
			return VertexDirection.West;
		}
		else if(directionStr.equalsIgnoreCase("SW")){
			return VertexDirection.SouthWest;
		}
		else if(directionStr.equalsIgnoreCase("NW")){
			return VertexDirection.NorthWest;
		}
		else{
			throw new Exception("the direction string is not what I expected");
		}
	}
	
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

