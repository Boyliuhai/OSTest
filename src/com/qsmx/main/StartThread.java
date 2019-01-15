package com.qsmx.main;

import com.qsmx.processchedule.*;
import com.qsmx.queue.*;
import com.qsmx.surface.MFrame;

public class StartThread extends Thread{
	public static boolean isRun=true;
	
	@Override
	public void run() {
		while(isRun){
			if(InputQueue.iE()&&OuputQueue.iE()&&ReadyQueue.iE()&&WaitQueue.iE()
					&&!Cps.isSR&&!Ips.isSR&&!Ops.isSR){
				isRun=false;
				MFrame.textField.setText("所有进程运行完毕");
				new ChangeThead().start();
				break;
			}else{
				if(!Cps.isSR){
					new Cps().start();
				}
				if(!Ips.isSR){
				new Ips().start();
				}
				if(!Ops.isSR){
					new Ops().start();
				}
			}
			if(!Cps.isSR&&!Ips.isSR&&!Ops.isSR){
				//p();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//p();
		}
	}
	
	public static void p(){
		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		System.out.println("EndQueue"+EndQueue.endPcbsq.size());
		System.out.println("WaitQueue"+WaitQueue.wMpq.size());
		System.out.println("OuputQueue"+OuputQueue.OutputMyprocessesQueue.size());
		System.out.println("InputQueue"+InputQueue.InputMyprocessesQueue.size());
		System.out.println("ReadyQueue"+ReadyQueue.readyQueue.size());
		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	}
	
	public static void ps(){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(EndQueue.idString);
		System.out.println(WaitQueue.idString);
		System.out.println(OuputQueue.idString);
		System.out.println(InputQueue.idString);
		System.out.println(ReadyQueue.idString);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
}
