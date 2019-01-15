package com.qsmx.processchedule;

import java.util.List;

import com.qsmx.process.PCB;
import com.qsmx.process.Times;
import com.qsmx.queue.EndQueue;
import com.qsmx.queue.InputQueue;
import com.qsmx.queue.OuputQueue;
import com.qsmx.queue.WaitQueue;

public class Ips extends Thread{
	public static boolean isSR=false;

	public static void Schedule(){
		//System.out.println("输入进程被调度");
		isSR=true;
		if(!InputQueue.InputMyprocessesQueue.isEmpty()){
			PCB pcb=InputQueue.remove();
			int runPosition=pcb.getProcess().getRunPosition();
			List<Character> commands=pcb.getProcess().getCommands();
			long fir=System.currentTimeMillis();
			while(System.currentTimeMillis()-fir<Times.INPUTSCHEDULETIME){
				char tempChar=commands.get(runPosition);
				if(tempChar=='C'){
					WaitQueue.add(pcb);
					pcb=null;
					break;
				}
				if(tempChar=='I'){
					runPosition++;
					pcb.getProcess().setRunPosition(runPosition);
					sleep(Times.INPUTCOMMANDTIME);
				}
				if(tempChar=='O'){
					OuputQueue.add(pcb);
					pcb=null;
					break;
				}
				if(tempChar=='W'){
					WaitQueue.add(pcb);
					pcb=null;
					break;
				}
				if(tempChar=='H'){
					EndQueue.add(pcb);
					pcb=null;
					break;
				}
			}//end while
			
			if(pcb!=null){
				InputQueue.add(pcb);
			}
		}
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
