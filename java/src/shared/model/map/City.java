package shared.model.map;

import shared.locations.VertexLocation;

public class City extends VertexObject {
	
	private static int pointValue = 2;

	public City(String jsonString) throws Exception {
		super(jsonString);
	}

	
	public City(int ownerIndex, VertexLocation location){
		super(ownerIndex, location);
	}
	
	@Override
	public int getPointValue() {
		// TODO Auto-generated method stub
		return 2;
	}

}