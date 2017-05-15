

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame mainFrame = new JFrame("main frame");
	private Button leftedit = new Button("edit");
	private Button leftload = new Button("load"); 
	private Button leftsave = new Button("save");
	private Button rightedit = new Button("edit");
	private Button rightload = new Button("load"); 
	private Button rightsave = new Button("save");
	private Button copyToRight = new Button("-->");
	private Button copyToleft = new Button("<--");
	private Button compare = new Button("comapre");
	private JTextPane rightPane = new JTextPane();
	private JTextPane leftPane = new JTextPane();
	private JScrollPane rightScroll;
	private JScrollPane leftScroll;
	
	
	public GUI(){
		mainFrame.setSize(1280,720);
		mainFrame.setLayout( null);
		mainFrame.setResizable(false);
		
		
		
		leftedit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				leftSetText();
			}
		});
		rightedit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rightSetText();
			}
		});
		
		rightPane.setText("right");
		leftPane.setText("left");
		
		rightPane.setEditable(true);
		leftPane.setEditable(true);
		
		rightScroll = new JScrollPane(rightPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		leftScroll = new JScrollPane(leftPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		rightScroll.setBounds(700,80,450,600);
		leftScroll.setBounds(50,80,450,600);
		copyToleft.setBounds(550, 150, 100, 50);
		copyToRight.setBounds(550, 350, 100, 50);
		compare.setBounds(550, 250, 100, 50);
		
		leftedit.setBounds(50, 20, 150, 40);
		leftsave.setBounds(200, 20, 150, 40);
		leftload.setBounds(350, 20, 150, 40);
		
		rightedit.setBounds(700, 20, 150, 40);
		rightsave.setBounds(850, 20, 150, 40);
		rightload.setBounds(1000, 20, 150, 40);
		
		
		mainFrame.add(leftedit);
		mainFrame.add(leftsave);
		mainFrame.add(leftload);
		mainFrame.add(rightedit);
		mainFrame.add(rightsave);
		mainFrame.add(rightload);
		mainFrame.add(copyToleft);
		mainFrame.add(copyToRight);
		mainFrame.add(rightScroll);
		mainFrame.add(leftScroll);
		mainFrame.add(compare);
		
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	

	public void rightSetText(){
		if(rightPane.isEditable() == false) {
			rightPane.setEditable(true);
			rightPane.setBackground(Color.white);
		}
		else {
			rightPane.setEditable(false);
			rightPane.setBackground(Color.lightGray);
				
		}
	
	}
	public void leftSetText(){
		if(leftPane.isEditable() == false){
			leftPane.setEditable(true);
			leftPane.setBackground(Color.white);
		}
		else {
			leftPane.setEditable(false);
			leftPane.setBackground(Color.LIGHT_GRAY);
		}
	}
	
	
	
}