package com.qsmx.process;

public class Times {
	/*
	 * cpu���ȵ�ʱ��
	 */
	public static int CPUTIME=500;
	
	/*
	 * cpuָ��ִ��ʱ��
	 */
	public static int CPUSCOMMANDTIME=50;
	
	/*
	 * ������̵��ȵ�ʱ��
	 */
	public static int INPUTSCHEDULETIME=1000;
	
	/*
	 * �������ָ��ִ��ʱ��
	 */
	public static int INPUTCOMMANDTIME=100;
	
	/*
	 * ������̵��ȵ�ʱ��
	 */
	public static int OUTPUTSCHEDULETIME=800;
	
	/*
	 * �������ָ��ִ�е�ʱ��
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
