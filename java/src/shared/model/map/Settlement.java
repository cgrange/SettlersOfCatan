package shared.model.map;

import shared.locations.VertexLocation;

public class Settlement extends VertexObject {
	
	private static int pointValue = 1;
	
	public Settlement(String jsonString) throws Exception {
		super(jsonString);
	}

	public Settlement(int ownerIndex, VertexLocation location){
		super(ownerIndex, location);
	}
	
	@Override
	public int getPointValue() {
		return pointValue;
	}

}
