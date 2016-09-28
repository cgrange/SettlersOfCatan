package shared.definitions;

public enum ResourceType
{
	WOOD, BRICK, SHEEP, WHEAT, ORE;
	
	public static ResourceType getResourceType(String resourceStr) throws Exception{
		if(resourceStr.equalsIgnoreCase("brick")){
			 return BRICK;
		}
		else if(resourceStr.equalsIgnoreCase("ore")){
			return ORE;
		}
		else if(resourceStr.equalsIgnoreCase("wheat")){
			return WHEAT;
		}
		else if(resourceStr.equalsIgnoreCase("sheep")){
			return SHEEP;
		}
		else if(resourceStr.equalsIgnoreCase("wood")){
			return WOOD;
		}
		else{
			throw new Exception("It is not one of the main resource types. Idk what will be sent if it's undefined");
		}
	}
}



