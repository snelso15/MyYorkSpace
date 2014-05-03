package edu.ycp.cs320.myYorkSpace.client;

import com.google.gwt.user.client.Command;

public class MenuCommand implements Command {

	public MenuCommand(String cmd){
		if (cmd != "home" && cmd != "message" && cmd != "friends" && cmd != "events"){
			throw new unsupportedOperationException
		}
	}
	@Override
	public void execute() {
		

	}

}
