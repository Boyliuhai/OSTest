package com.qsmx.queue;

import java.util.ArrayDeque;
import java.util.Queue;

import com.qsmx.process.PCB;

public class OuputQueue {
	public static String idString="";
	public static Queue<PCB> OutputMyprocessesQueue
	=new ArrayDeque<PCB>();
	public static synchronized void add(PCB pcb){
		/*
		 * 进程进入这个队列的状态必须为OUTPUTSTATE
		 */
		if(!pcb.getStateString().equals(PCB.OUTPUTSTATE)){
			pcb.setStateString(PCB.OUTPUTSTATE);
		}
		OutputMyprocessesQueue.add(pcb);
		idString=idString+(pcb.getID()+"\n");
	}
	
	public static synchronized PCB remove(){
		synchronized(OuputQueue.class){
			if(OutputMyprocessesQueue.size()==0){
				return null;
			}else {
				PCB pcb=OutputMyprocessesQueue.poll();
				idString=idString.replaceAll(pcb.getID()+"\n", "");
				return pcb;
			}
		}
		
	}
	
	public static boolean iE(){
		return OutputMyprocessesQueue.isEmpty();
	}
}
