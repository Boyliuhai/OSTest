package com.qsmx.process;

import java.util.ArrayList;
import java.util.List;

public class MyProcess {
	private List<Character> commands=new ArrayList<Character>();
	private int runPosition=0;
	public MyProcess(){}
	public List<Character> getCommands() {
		return commands;
	}

	public void setCommands(List<Character> commands) {
		this.commands = commands;
	}
	
	public void addCommandChar(char commandChar){
		commands.add(commandChar);
	}
	
	public int getRunPosition() {
		return runPosition;
	}
	public void setRunPosition(int runPosition) {
		this.runPosition = runPosition;
	}
	@Override
	public String toString() {
		return commands+"";
	}
}
