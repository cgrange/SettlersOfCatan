package shared.definitions;

import java.awt.Color;

public enum CatanColor
{
	RED, ORANGE, YELLOW, BLUE, GREEN, PURPLE, PUCE, WHITE, BROWN;
	
	private Color color;
	
	static
	{
		RED.color = new Color(227, 66, 52);
		ORANGE.color = new Color(255, 165, 0);
		YELLOW.color = new Color(253, 224, 105);
		BLUE.color = new Color(111, 183, 246);
		GREEN.color = new Color(109, 192, 102);
		PURPLE.color = new Color(157, 140, 212);
		PUCE.color = new Color(204, 136, 153);
		WHITE.color = new Color(223, 223, 223);
		BROWN.color = new Color(161, 143, 112);
	}
	
	public static CatanColor getCatanColor(String colorStr) throws Exception{
		if(colorStr.equalsIgnoreCase("red")){
			return CatanColor.RED;
		}
		else if(colorStr.equalsIgnoreCase("orange")){
			return CatanColor.ORANGE;
		}
		else if(colorStr.equalsIgnoreCase("yellow")){
			return CatanColor.YELLOW;
		}
		else if(colorStr.equalsIgnoreCase("green")){
			return CatanColor.GREEN;
		}
		else if(colorStr.equalsIgnoreCase("blue")){
			return CatanColor.BLUE;
		}
		else if(colorStr.equalsIgnoreCase("purple")){
			return CatanColor.PURPLE;
		}
		else if(colorStr.equalsIgnoreCase("puce")){
			return CatanColor.PUCE;
		}
		else if(colorStr.equalsIgnoreCase("white")){
			return CatanColor.WHITE;
		}
		else if(colorStr.equalsIgnoreCase("brown")){
			return CatanColor.BROWN;
		}
		else{
			throw new Exception("the color is not one of the 9 approved colors");
		}
	}
	
	public Color getJavaColor()
	{
		return color;
	}
}

