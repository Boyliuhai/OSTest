package com.qsmx.queue;

import java.util.ArrayDeque;
import java.util.Queue;

import com.qsmx.process.PCB;

public class EndQueue {
	public static String idString="";
	public static Queue<PCB> endPcbsq = new ArrayDeque<PCB>();
	public static synchronized void add(PCB pcb) {
		/*
		 * 进程进入这个队列的状态必须为ENDSTATE
		 */
		if (!pcb.getStateString().equals(PCB.ENDSTATE)) {
			pcb.setStateString(PCB.ENDSTATE);
		}
		//System.out.println("EndQueue---before add----"+endPcbsq.size());
		endPcbsq.add(pcb);
		//System.out.println("EndQueue---after add----"+endPcbsq.size());
		idString=idString+(pcb.getID()+"\n");
	}
}
