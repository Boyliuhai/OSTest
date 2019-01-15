package com.qsmx.processchedule;

import java.util.List;

import com.qsmx.process.PCB;
import com.qsmx.process.Times;
import com.qsmx.queue.EndQueue;
import com.qsmx.queue.InputQueue;
import com.qsmx.queue.OuputQueue;
import com.qsmx.queue.ReadyQueue;
import com.qsmx.queue.WaitQueue;
import com.qsmx.surface.MFrame;

//CPU的进程调度
public class Cps extends Thread{
	public static boolean isSR=false;
	public static  void Schedule(){
		
		//	System.out.println("cpu被调度");
		isSR=true;
		/*判断就绪队列是否为空，
		 * 如果不为空，则进行调度
		 * 否则判断等待队列是否为空
		 */
		MFrame.textField.setText("");
		if(ReadyQueue.readyQueue.size()!=0){
			PCB pcb=ReadyQueue.remove();
			MFrame.textField.setText(pcb.getID());
			MFrame.Ready.setText(pcb.getID());
			int runPosition=pcb.getProcess().getRunPosition();
			List<Character> commandChars=pcb.getProcess().getCommands();
			long fir=System.currentTimeMillis();
			while(System.currentTimeMillis()-fir<Times.CPUTIME){
				char tempchar=commandChars.get(runPosition);
				if(tempchar=='C'){
					runPosition++;
					pcb.getProcess().setRunPosition(runPosition);
					sleep(Times.CPUSCOMMANDTIME);
				}
				if(tempchar=='I'){
					InputQueue.add(pcb);
					
					pcb=null;
					break;
				}
				if(tempchar=='O'){
					OuputQueue.add(pcb);
					
					pcb=null;
					break;
				}
				if(tempchar=='W'){
					runPosition++;
					pcb.getProcess().setRunPosition(runPosition);
					sleep(Times.CPUSCOMMANDTIME);
				}
				if(tempchar=='H'){
					EndQueue.add(pcb);
					
					pcb=null;
					break;
				}
			}
			
			if(pcb!=null){
				WaitQueue.add(pcb);
				
			}
		}else {
			if(!WaitQueue.wMpq.isEmpty()){
				PCB pcb=WaitQueue.remove();
				ReadyQueue.add(pcb);
			}
		}/*end------if(ReadyQueue.readyQueue.size()!=0)*/

		isSR=false;
		MFrame.textField.setText("");
		MFrame.Ready.setText("");
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
