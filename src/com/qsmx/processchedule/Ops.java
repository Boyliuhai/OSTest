package com.qsmx.processchedule;

import java.util.List;

import com.qsmx.process.PCB;
import com.qsmx.process.Times;
import com.qsmx.queue.InputQueue;
import com.qsmx.queue.OuputQueue;
import com.qsmx.queue.WaitQueue;

public class Ops extends Thread{
	public static boolean isSR=false;
	public static void Schedule(){
		isSR=true;
		/*
		 * 判断输出队列是否为空
		 * 如果不为空则进行调度
		 */
		if(!OuputQueue.OutputMyprocessesQueue.isEmpty()){
			PCB pcb=OuputQueue.remove();
			int runPosition=pcb.getProcess().getRunPosition();
			List<Character> commands=pcb.getProcess().getCommands();
			long fir=System.currentTimeMillis();
			while(System.currentTimeMillis()-fir<Times.OUTPUTSCHEDULETIME){
				char tempchar=commands.get(runPosition);
				if(tempchar=='C'){
					WaitQueue.add(pcb);
					pcb=null;
					break;
				}
				if(tempchar=='I'){
					InputQueue.add(pcb);
					pcb=null;
					break;
				}
				if(tempchar=='O'){
					runPosition++;
					pcb.getProcess().setRunPosition(runPosition);
					sleep(Times.OUTPUTCOMMANDTIME);
				}
				if(tempchar=='W'){
					WaitQueue.add(pcb);
					pcb=null;
					break;
				}
				if(tempchar=='H'){
					WaitQueue.add(pcb);
					pcb=null;
					break;
				}
			}
			
			if(pcb!=null){
				OuputQueue.add(pcb);
			}
		}//end -----if(!OuputQueue.OutputMyprocessesQueue.isEmpty())
		isSR=false;
	}
	public static void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		Schedule();
	}
}
