package shared.Model.communication;

import shared.Model.MessageLine;

public class Communication {

	private chatList List <MessageLine>;
	private logList List <MessageLine>;

	/**
	 * Adds a line to the Chat List
	 * @param line the chat line to add
	 */
	public void addChatLine(MessageLine line){

	}

	public List <MessageLine> getChatList(){
		return chatList;
	}

	/**
	 * Adds a line to the Log List
	 * @param line the log line to add
	 */
	public void addLogLine(MessageLine line){

	}

	public List <MessageLine> getLogList(){
		return logList;
	}


}