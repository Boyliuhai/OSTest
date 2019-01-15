package com.qsmx.process;

public class PCB {
	/*
	 * 进程处于输入状态
	 */
	public static final String INPUTSTATE="INPUTSTATE";
	/*
	 * 进程处于输出状态
	 */
	public static final String OUTPUTSTATE="OUTPUTSTATE";
	/*
	 * 进程处于等待状态
	 */
	public static final String WAITSTATE="WAITSTATE";
	/*
	 * 进程处于执行完毕--结束状态
	 */
	public static final String ENDSTATE="ENDSTATE";
	/*
	 * 进程处于准备状态--等待CPU调度，
	 */
	public static final String READYSTATE="READYSTATE";
	/*
	 * 进程的状态
	 */
	private String stateString;
	/*
	 * 进程的id
	 */
	private String ID;
	/*
	 * 进程要执行的指令/代码
	 */
	private MyProcess process;
	
	public PCB(MyProcess process,String id) {
		this.ID=id;
		/*
		 * 进程在创建完成之后处于等待状态
		 */
		this.stateString=WAITSTATE;
		this.process = process;
	}
	public String getStateString() {
		return stateString;
	}
	public void setStateString(String stateString) {
		this.stateString = stateString;
	}
	public String getID() {
		return ID;
	}

	public void setID(String id){
		this.ID=id;
	}
	public MyProcess getProcess() {
		return process;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof PCB&&this.ID.equals(((PCB)obj).ID);
	}
}
