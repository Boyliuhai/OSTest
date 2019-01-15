package com.qsmx.process;

public class PCB {
	/*
	 * ���̴�������״̬
	 */
	public static final String INPUTSTATE="INPUTSTATE";
	/*
	 * ���̴������״̬
	 */
	public static final String OUTPUTSTATE="OUTPUTSTATE";
	/*
	 * ���̴��ڵȴ�״̬
	 */
	public static final String WAITSTATE="WAITSTATE";
	/*
	 * ���̴���ִ�����--����״̬
	 */
	public static final String ENDSTATE="ENDSTATE";
	/*
	 * ���̴���׼��״̬--�ȴ�CPU���ȣ�
	 */
	public static final String READYSTATE="READYSTATE";
	/*
	 * ���̵�״̬
	 */
	private String stateString;
	/*
	 * ���̵�id
	 */
	private String ID;
	/*
	 * ����Ҫִ�е�ָ��/����
	 */
	private MyProcess process;
	
	public PCB(MyProcess process,String id) {
		this.ID=id;
		/*
		 * �����ڴ������֮���ڵȴ�״̬
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
