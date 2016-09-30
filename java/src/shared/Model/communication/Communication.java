package shared.model.communication;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shared.model.Model;
import shared.model.communication.MessageLine;
import shared.model.players.Player;

public class Communication {

	private List<MessageLine> chatList;
	private List<MessageLine> logList;
	
// ================================== BEGIN CONSTRUCTOR HELPER FUNCTIONS ======================================
	
	 private void deserializeChatList(JsonObject chatObj) throws Exception{
		 chatList = new ArrayList<MessageLine>();
		 JsonArray linesArray = chatObj.get("lines").getAsJsonArray();
	   		for(int i = 0; i < linesArray.size(); i++){
	   			JsonObject lineObject = linesArray.get(i).getAsJsonObject();
	   			String message = lineObject.get("message").getAsString();
	   			String source = lineObject.get("source").getAsString();
	   			MessageLine temp = new MessageLine(source, message);
	   			chatList.add(temp);
		   }
	   }
	   
	   private void deserializeLogList(JsonObject logObj) throws Exception{
		   logList = new ArrayList<MessageLine>();
		   JsonArray linesArray = logObj.get("lines").getAsJsonArray();
		   for(int i = 0; i < linesArray.size(); i++){
			   JsonObject lineObject = linesArray.get(i).getAsJsonObject();
			   String message = lineObject.get("message").getAsString();
			   String source = lineObject.get("source").getAsString();
			   MessageLine temp = new MessageLine(source, message);
			   logList.add(temp);
		   }
	   }
	   
// ================================= END CONSTRUCTOR HELPER FUNCTIONS =========================================
	  
	   public Communication(String chatJson, String logJson) throws Exception{		   
		   JsonParser jsonParser = new JsonParser();
		   
		   JsonObject chatObj = jsonParser.parse(chatJson).getAsJsonObject();
		   deserializeChatList(chatObj);

		   JsonObject logObj = jsonParser.parse(logJson).getAsJsonObject();
		   deserializeLogList(logObj);
	   }
	   
	   /**
	 * Adds a line to the Chat List
	 * @param line the chat line to add
	 */
	public void addChatLine(MessageLine line){
		chatList.add(line);
	}

	public List <MessageLine> getChatList(){
		return chatList;
	}

	/**
	 * Adds a line to the Log List
	 * @param line the log line to add
	 */
	public void addLogLine(MessageLine line){
		logList.add(line);
	}

	public List <MessageLine> getLogList(){
		return logList;
	}


}