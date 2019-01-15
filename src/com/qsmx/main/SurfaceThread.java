package com.qsmx.main;

import com.qsmx.queue.EndQueue;
import com.qsmx.queue.InputQueue;
import com.qsmx.queue.OuputQueue;
import com.qsmx.queue.WaitQueue;
import com.qsmx.surface.MFrame;


public class SurfaceThread extends Thread{
//O	public static int i=0;
	@Override
	public void run() {
		while(true){
			MFrame.End.setText(EndQueue.idString);
			MFrame.Wait.setText(WaitQueue.idString);
			MFrame.Input.setText(InputQueue.idString);
			MFrame.Output.setText(OuputQueue.idString);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
