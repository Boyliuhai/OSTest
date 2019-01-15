package com.qsmx.filemanager;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qsmx.main.Test;
import com.qsmx.process.CommandAndTime;
import com.qsmx.process.MyProcess;
import com.qsmx.process.PCB;
import com.qsmx.util.Util;

public class FileInput {
	public static List<PCB> getProcess() throws FileNotFoundException{
		List<PCB> pcbs=new ArrayList<PCB>();
		Scanner scanner=new Scanner(
				new BufferedInputStream(
						new FileInputStream(
								Test.file
								)));
		String tempString=null;
		MyProcess process=null;
		String id=null;
		while(!"H00..".equals(tempString)){
			tempString=scanner.nextLine();
			if(Util.isBeginWithP(tempString)){
				if(process!=null){
					pcbs.add(new PCB(process,id));
				}
				//如果这个字符串的开始字符为P
				//那么这个字符串为创建 一个进程的字符串标识符
				process=new MyProcess();
				id=tempString;
			}else if(Util.isBeginWithH(tempString)){
				process.addCommandChar('H');
				pcbs.add(new PCB(process,id));
				process=null;
			}else{
				CommandAndTime caTime=Util.AnalysisCommand(tempString);
				char commandChar=caTime.getCommandChar();
				int commandTimesInt=caTime.getCommandTime();
				for(int i=0;i<commandTimesInt;i++){
					process.addCommandChar(commandChar);
				}
			}				
		}		
		if(process!=null){			
			process.addCommandChar('H');
			pcbs.add(new PCB(process,id));
		}
		return pcbs;
	}
	
}
