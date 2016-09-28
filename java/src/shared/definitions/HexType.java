package shared.definitions;

public enum HexType
{
	WOOD, BRICK, SHEEP, WHEAT, ORE, DESERT, WATER;
	
	public static HexType getHexType(String resource) throws Exception{
		if(resource.equalsIgnoreCase("brick")){
			return HexType.BRICK;
		}
		else if(resource.equalsIgnoreCase("ore")){
			return HexType.ORE;
		}
		else if(resource.equalsIgnoreCase("wheat")){
			return HexType.WHEAT;
		}
		else if(resource.equalsIgnoreCase("desert")){
			return HexType.DESERT;
		}
		else if(resource.equalsIgnoreCase("wood")){
			return HexType.WOOD;
		}
		else if(resource.equalsIgnoreCase("sheep")){
			return HexType.SHEEP;
		}
		else{
			throw new Exception("Not one of the 6 hex types");
		}
	}
	
}

