package shared.model.map;

public class Settlement extends VertexObject {
	
	private static int pointValue = 1;
	
	public Settlement(String jsonString) throws Exception {
		super(jsonString);
	}

	@Override
	public int getPointValue() {
		return pointValue;
	}

}
