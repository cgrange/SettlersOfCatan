package shared.model.map;

public class City extends VertexObject {
	
	private static int pointValue = 2;

	public City(String jsonString) throws Exception {
		super(jsonString);
	}

	@Override
	public int getPointValue() {
		return pointValue;
	}

}
