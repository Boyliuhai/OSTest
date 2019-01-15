package com.qsmx.main;

import com.qsmx.surface.MFrame;


public class ChangeThead extends Thread{
	private static int i=0;
	@Override
	public void run() {
		while(i<20){
			MFrame.textField.setText("所有进程运行完毕");
			MFrame.Ready.setText("");
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
