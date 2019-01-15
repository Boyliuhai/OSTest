package com.qsmx.util;

public class ParamException extends Exception{

	private static final long serialVersionUID = -3518930400703421807L;
	private String string;
	public ParamException(){
		string="param error";
	}
	@Override
	public String toString() {
		return string;
	}
}
