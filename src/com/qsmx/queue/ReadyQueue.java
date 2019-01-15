package com.qsmx.queue;

import java.util.ArrayDeque;
import java.util.Queue;

import com.qsmx.process.PCB;

public class ReadyQueue {
	public static String idString="";
	public static Queue<PCB> readyQueue
	=new ArrayDeque<PCB>();
	public static synchronized void add(PCB pcb){
		/*
		 * 进程进入这个队列的状态必须为READYSTATE
		 */
		if(!pcb.getStateString().equals(PCB.READYSTATE)){
			pcb.setStateString(PCB.READYSTATE);
		}
		readyQueue.add(pcb);
		
		idString=idString+(pcb.getID()+"\n");
	}
	
	public static synchronized PCB remove(){
		synchronized(ReadyQueue.class){
			if(readyQueue.size()==0){
				return null;
			}else {
				PCB pcb=readyQueue.poll();
				idString=idString.replaceAll(pcb.getID()+"\n", "");
				return pcb;
			}
		}	
	}
	public static boolean iE(){
		return readyQueue.isEmpty();
	}
}
