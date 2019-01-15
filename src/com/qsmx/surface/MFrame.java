package com.qsmx.surface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.qsmx.filemanager.FileInput;
import com.qsmx.main.StartThread;
import com.qsmx.process.PCB;
import com.qsmx.process.Times;
import com.qsmx.queue.EndQueue;
import com.qsmx.queue.InputQueue;
import com.qsmx.queue.OuputQueue;
import com.qsmx.queue.ReadyQueue;
import com.qsmx.queue.WaitQueue;

public class MFrame extends JFrame implements ActionListener{
	public static boolean isStart=false;
	private static final long serialVersionUID = 3937283555052332833L;
	private JButton startButton=new JButton("开始调度");
	private JButton stopButton =new JButton("暂停调度");

	JLabel cpuJLabel=new JLabel("cpu调度时间:");
	JTextField cpuTimes=new JTextField(""+Times.CPUTIME);

	JLabel enterJLabel=new JLabel("输入调度时间:");	
	JTextField enterTimes=new JTextField(""+Times.INPUTSCHEDULETIME);

	JLabel outJLabel=new JLabel("输出调度时间:");
	JTextField outTimes=new JTextField(""+Times.OUTPUTSCHEDULETIME);

	public static JTextField textField=new JTextField();

	public static JTextArea Wait=new JTextArea(10,10);
	public static JTextArea Ready=new JTextArea(10,10);
	public static JTextArea Input=new JTextArea(10,10);
	public static JTextArea Output=new JTextArea(10,10);
	public static JTextArea End=new JTextArea(10,10);

	public MFrame(){
		setLayout(new BorderLayout());
		JPanel threePanel=new JPanel();
		JPanel fourJPanel=new JPanel();
		threePanel.setLayout(new GridLayout(4, 1));
		add(threePanel,BorderLayout.NORTH);
		add(fourJPanel,BorderLayout.SOUTH);
		JPanel buttonPanel=new JPanel();
		JPanel timePanel  =new JPanel();
		JPanel currentJPanel=new JPanel();
		JPanel wordJPanel=new JPanel();
		threePanel.add(buttonPanel);
		threePanel.add(timePanel);
		threePanel.add(currentJPanel);
		threePanel.add(wordJPanel);
		buttonPanel.setLayout(new GridLayout(1, 6));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		timePanel.setLayout(new GridLayout(1, 6));
		timePanel.add(cpuJLabel);
		timePanel.add(cpuTimes);
		timePanel.add(enterJLabel);
		timePanel.add(enterTimes);
		timePanel.add(outJLabel);
		timePanel.add(outTimes);
		cpuTimes.setEditable(false);
		enterTimes.setEditable(false);
		outTimes.setEditable(false);
		currentJPanel.setLayout(new GridLayout(1, 3));
		currentJPanel.add(new JLabel("当前运行的进程"));
		currentJPanel.add(textField);
		currentJPanel.add(new JLabel());
		wordJPanel.setLayout(new GridLayout(1,5));
		wordJPanel.add(new JLabel("后备就绪队列"));
		wordJPanel.add(new JLabel("就绪队列"));
		wordJPanel.add(new JLabel("输入等待队列"));
		wordJPanel.add(new JLabel("输出等待队列"));
		wordJPanel.add(new JLabel("其他队列"));
		fourJPanel.setLayout(new BorderLayout());
		JPanel f1=new JPanel();
		fourJPanel.add(f1,BorderLayout.CENTER);
		f1.setLayout(new GridLayout(1,5,10,10));

		f1.add(Wait);
		f1.add(Ready);
		f1.add(Input);		
		f1.add(Output);
		f1.add(End);
		
		setSize(700,400);
		setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton){
			if(!isStart){
				isStart=true;
				StartThread.isRun=true;
				if(InputQueue.iE()&&OuputQueue.iE()&&ReadyQueue.iE()&&WaitQueue.iE()&&EndQueue.endPcbsq.isEmpty()){
					List<PCB> list = null;
					try {
						list = FileInput.getProcess();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					for(PCB pcb:list){
						WaitQueue.add(pcb);
						System.out.println(pcb.getID());
						for(Character c:pcb.getProcess().getCommands()){
							System.out.print(c);
						}
						System.out.println();
					}
					new StartThread().start();
				}else {
					new StartThread().start();
				}

			}

		}
		if(e.getSource()==stopButton){
			isStart=false;
			StartThread.isRun=false;
		}
	}

}

