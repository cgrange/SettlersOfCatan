package shared.model.communication;

import java.util.List;
import shared.model.communication.MessageLine;

public class Communication {

	private List<MessageLine> chatList;
	private List<MessageLine> logList;

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