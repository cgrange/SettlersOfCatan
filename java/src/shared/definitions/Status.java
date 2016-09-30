package shared.definitions;

public enum Status
{
	ROLLING, ROBBING, PLAYING, FIRSTROUND, SECONDROUND;
	
	public static Status getStatus(String statusString) throws Exception{
		if(statusString.equalsIgnoreCase("rolling")){
			return Status.ROLLING;
		}
		else if(statusString.equalsIgnoreCase("robbing")){
			return Status.ROBBING;
		}
		else if(statusString.equalsIgnoreCase("playing")){
			return Status.PLAYING;
		}
		else if(statusString.equalsIgnoreCase("firstround")){
			return Status.FIRSTROUND;
		}
		else if(statusString.equalsIgnoreCase("secondround")){
			return Status.SECONDROUND;
		}
		else{
			throw new Exception("the status was not one of our 5 expected values");
		}
	}
}
