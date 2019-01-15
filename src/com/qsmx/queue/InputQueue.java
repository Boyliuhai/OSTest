package com.qsmx.queue;

import java.util.ArrayDeque;
import java.util.Queue;

import com.qsmx.process.PCB;

public class InputQueue {
	public static String idString="";
	public static Queue<PCB> InputMyprocessesQueue
	=new ArrayDeque<PCB>();
	public static synchronized void add(PCB pcb){
		/*
		 * 进程进入这个队列的状态必须为INPUTSTATE
		 */
		if(!pcb.getStateString().equals(PCB.INPUTSTATE)){
			pcb.setStateString(PCB.INPUTSTATE);
		}
		InputMyprocessesQueue.add(pcb);
		idString=idString+(pcb.getID()+"\n");
	}
	
	public static synchronized PCB remove(){
		synchronized(InputQueue.class){
			if(InputMyprocessesQueue.size()==0){
				return null;
			}else {
				PCB pcb=InputMyprocessesQueue.poll();
				idString=idString.replaceAll(pcb.getID()+"\n", "");
				return pcb;
			}
		}
		
	}
	
	public static boolean iE(){
		return InputMyprocessesQueue.isEmpty();
	}
}
