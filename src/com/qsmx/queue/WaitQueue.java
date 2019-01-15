package com.qsmx.queue;

import java.util.ArrayDeque;
import java.util.Queue;

import com.qsmx.process.PCB;

public class WaitQueue {
	public static String idString="";
	public static Queue<PCB> wMpq
	=new ArrayDeque<PCB>();
	public static synchronized void add(PCB pcb){
		/*
		 * 进程进入这个队列的状态必须为WAITSTATE
		 */
		if(!pcb.getStateString().equals(PCB.WAITSTATE)){
			pcb.setStateString(PCB.WAITSTATE);
		}		
		wMpq.add(pcb);
		idString=idString+(pcb.getID()+"\n");
	}

	public static synchronized PCB remove(){
		synchronized(WaitQueue.class){
			if(wMpq.size()==0){
				return null;
			}else {
				//System.out.println("before pop--"+wMpq.size());
				PCB pcb=wMpq.poll();
				//System.out.println("after pop--"+wMpq.size());
				idString=idString.replaceAll(pcb.getID()+"\n", "");
				return pcb;
			}
		}
	}
	
	public static boolean iE(){
		return wMpq.isEmpty();
	}
}
