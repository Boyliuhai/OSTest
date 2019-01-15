package com.qsmx.process;

public class CommandAndTime {
	private char commandChar;
	private int commandTime;
	public CommandAndTime(char commandChar,int commandTime){
		this.commandChar=commandChar;
		this.commandTime=commandTime;
	}
	public char getCommandChar(){
		return this.commandChar;
	}
	public int getCommandTime(){
		return this.commandTime;
	}
	
	public void setCommandTime(int CommandTime){
		this.commandTime=CommandTime;
	}
	public void setCommandChar(char CommandChar){
		this.commandChar=CommandChar;
	}
}
