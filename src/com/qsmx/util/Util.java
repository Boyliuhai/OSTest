package com.qsmx.util;

import java.util.List;

import com.qsmx.process.CommandAndTime;

public class Util {
	public static CommandAndTime AnalysisCommand(String string){
		CommandAndTime caTime
		=new CommandAndTime(string.charAt(0), StringToInt(string.substring(1)));
		return caTime;
	}
	
	public static boolean isBeginWithP(String string){
		if(string.length()==0){
			try {
				throw new ParamException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return string.charAt(0)=='P';
		}
		return false;
	}
	
	public static int StringToInt(String string){
		int temp=0;
		for(int i=0;i<string.length();i++){
			temp+=pow(10,i)*charToint(string.charAt(string.length()-i-1));
		}
		return temp;
	}
	
	public static int pow(int base,int x){
		int temp=1;
		if(base==0){
			return 0;
		}else if(base==1){
			return 1;
		}else if(base==-1){
			if((x&1)==1){
				return -1;
			}else{
				return 1;
			}
		}else {
			if(x==0){
				return 1;
			}else if(x>0){
				//x>0
				for(int i=0;i<x;i++){
					temp*=base;
				}
			}else {
				//x<0
				return 0;
			}
		}
		return temp;
		
	}//ended pow
	
	public static int charToint(char c){
		switch(c){
		case '0':return 0;
		case '1':return 1;
		case '2':return 2;
		case '3':return 3;
		case '4':return 4;
		case '5':return 5;
		case '6':return 6;
		case '7':return 7;
		case '8':return 8;
		case '9':return 9;
		default:return 0;
		}
	}
	
	public static boolean isBeginWithH(String string){
		return string.charAt(0)=='H';
	}
	
	public static String listToString(List<String> list){
		System.out.println(list.size());
		StringBuilder builder=new StringBuilder();
		for(String string:list){
			builder.append(string);
		}
		return builder.toString();
	}
}
