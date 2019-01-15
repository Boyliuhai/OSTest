package com.qsmx.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import com.qsmx.filemanager.FileInput;
import com.qsmx.process.PCB;
import com.qsmx.process.Times;
import com.qsmx.queue.WaitQueue;
import com.qsmx.surface.MFrame;

@SuppressWarnings("all")
public class Test {
	public static File file=new File("D:/aa.txt");
	public static void main(String[] args) throws Exception{
		MFrame frame=new MFrame();
		new SurfaceThread().start();
	}
}
