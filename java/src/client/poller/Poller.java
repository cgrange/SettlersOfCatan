package client.poller;
import shared.model.Model;

import java.util.Timer;
import java.util.TimerTask;

import client.proxy.IProxy;

/**
 * A class to periodically pull the model, using a timer
 *
 */
public class Poller {
	
	
	private static Timer t = null;
	private static IProxy proxy = null;
	private final static Object lockObject = new Object();
	
	//for testing purposes
	private static boolean hasBeenRun = false;
	
	public static boolean resetHasBeenRun()
	{
		boolean temp = hasBeenRun;
		hasBeenRun = false;
		return temp;
	}
	
	public static void setTimer(IProxy proxy){
		
		if(t == null || proxy == null)
		{
			synchronized(lockObject)
			{
				if(t==null || proxy == null)
				{
					Poller.proxy = proxy;
					
					t = new Timer();
					t.scheduleAtFixedRate(new TimerTask(){
						public void run(){
							updateModel();
						}
							}, 2000, 2000);
				}
			}
		}
		
	}
	
	/**
	 * updates the client model
	 */
	public static void updateModel(){
		hasBeenRun = true;
		Model model;
		if(Model.get() == null)
		{
			model = proxy.game_model(-1);
		}
		else {
			model = proxy.game_model(Model.get().getVersion());
		}
		if(model != null)
		{
			Model.set(model);
		}
	}
}
