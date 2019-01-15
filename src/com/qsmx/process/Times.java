package com.qsmx.process;

public class Times {
	/*
	 * cpu调度的时间
	 */
	public static int CPUTIME=500;
	
	/*
	 * cpu指令执行时间
	 */
	public static int CPUSCOMMANDTIME=50;
	
	/*
	 * 输入进程调度的时间
	 */
	public static int INPUTSCHEDULETIME=1000;
	
	/*
	 * 输入进程指令执行时间
	 */
	public static int INPUTCOMMANDTIME=100;
	
	/*
	 * 输出进程调度的时间
	 */
	public static int OUTPUTSCHEDULETIME=800;
	
	/*
	 * 输出进程指令执行的时间
	 */
	public static int OUTPUTCOMMANDTIME=80;
	
	public static void setAll(double cs,double cc,double is,double ic,double os,double oc){
		CPUTIME*=cs;
		CPUSCOMMANDTIME*=cc;
		INPUTSCHEDULETIME*=is;
		INPUTCOMMANDTIME*=ic;
		OUTPUTSCHEDULETIME*=os;
		OUTPUTCOMMANDTIME*=oc;
	}
	
	public static void setAll(double all){
		setAll(all,all,all,all,all,all);
	}
	
	public static void setAll(int cs,int cc,int is,int ic,int os,int oc){
		CPUTIME=cs;
		CPUSCOMMANDTIME=cc;
		INPUTSCHEDULETIME=is;
		INPUTCOMMANDTIME=ic;
		OUTPUTSCHEDULETIME=os;
		OUTPUTCOMMANDTIME=oc;
	}
}
