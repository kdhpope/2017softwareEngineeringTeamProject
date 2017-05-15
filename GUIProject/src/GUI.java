import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.FileDialog;
import java.awt.Dimension;
import java.awt.Toolkit;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
 
public class GUI extends JFrame implements ActionListener {
 
   private Button leftedit = new Button("EDIT");
   private Button leftload = new Button("LOAD"); 
   private Button leftsave = new Button("SAVE");
   private Button rightedit = new Button("EDIT");
   private Button rightload = new Button("LOAD"); 
   private Button rightsave = new Button("SAVE");
   private Button copyToRight = new Button("-->");
   private Button copyToleft = new Button("<--");
   private Button compare = new Button("COMPARE");
   private JPanel rightText = new JPanel();
   private JPanel leftText = new JPanel();
   private JTextPane rightPane = new JTextPane();
   private JTextPane leftPane = new JTextPane();
   private Dimension frameSize, screenSize;
   private JScrollPane rightScroll;
   private JScrollPane leftScroll;
   private String tmpdir;
   private String tmpdir2;
   
   public GUI() {
      setTitle("SImpleMerge");
      InitLayout();
      
      setSize(1280,720);
      setVisible(true);
      setResizable(false);
      
      centerScreenSet();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public void centerScreenSet() {
	      frameSize = getSize();
	      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
   }
   
   public void InitLayout() {
      setLayout(null);
      
      rightPane.setEditable(false);
      rightPane.setBackground(Color.lightGray);
      leftPane.setEditable(false);
      leftPane.setBackground(Color.lightGray);
      
      rightPane.setSize(100000, 100000);
      leftPane.setSize(10000, 10000);
      
      rightText.setLayout(new BorderLayout());
      rightText.add(rightPane);
      rightText.setSize(100000, 100000);
      
      leftText.setLayout(new BorderLayout());
      leftText.add(leftPane);
      leftText.setSize(100000, 100000);
      
      rightScroll = new JScrollPane(rightText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      leftScroll = new JScrollPane(leftText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      
      
      
      rightScroll.setBounds(700,80,450,550);
      leftScroll.setBounds(50,80,450,550);
      copyToleft.setBounds(550, 150, 100, 50);
      copyToRight.setBounds(550, 350, 100, 50);
      compare.setBounds(550, 250, 100, 50);
      
      leftedit.setBounds(200, 20, 150, 40);
      leftsave.setBounds(350, 20, 150, 40);
      leftload.setBounds(50, 20, 150, 40);
      
      rightedit.setBounds(850, 20, 150, 40);
      rightsave.setBounds(1000, 20, 150, 40);
      rightload.setBounds(700, 20, 150, 40);
      
      leftload.addActionListener(this);
      leftedit.addActionListener(this);
      leftsave.addActionListener(this);
      
      rightload.addActionListener(this);
      rightedit.addActionListener(this);
      rightsave.addActionListener(this);
      
      add(leftload);
      add(leftedit);
      add(leftsave);
      
      add(rightload);
      add(rightedit);
      add(rightsave);
      
      add(copyToleft);
      add(copyToRight);
      add(rightScroll);
      add(leftScroll);
      add(compare);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(leftload)) {
         FileDialog dialog = new FileDialog(this, "Load For Left", FileDialog.LOAD);
         dialog.setDirectory(".");
         dialog.setVisible(true);
         
         if(dialog.getFile() == null) return;
            
         String dfName = dialog.getDirectory() + dialog.getFile();
         tmpdir = dfName;
         String lineNumber;
         
         try {
            BufferedReader reader = new BufferedReader(new FileReader(dfName));
            leftPane.setText("");
            while((lineNumber = reader.readLine()) != null){
            	leftPane.setText(leftPane.getText()+lineNumber);
            }
            reader.close();
            
         } catch (Exception e2) {
            JOptionPane.showMessageDialog(this, "로딩 실패");
         }
      }
      else if(e.getSource().equals(leftedit)) {
         leftEditText();
      }
      else if(e.getSource().equals(leftsave)) {
         try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpdir));
            leftPane.write(writer);
            JOptionPane.showMessageDialog(this, "저장 성공");
            writer.close();
            
         } catch (Exception e2) {
            JOptionPane.showMessageDialog(this, "저장 실패");
         }
      }
      else if(e.getSource().equals(rightload)) {
         FileDialog dialog = new FileDialog(this, "Load For Right", FileDialog.LOAD);
         dialog.setDirectory(".");
         dialog.setVisible(true);
         
         if(dialog.getFile() == null) return;
            
         String dfName2 = dialog.getDirectory() + dialog.getFile();
         tmpdir2 = dfName2;
         
         try {
            BufferedReader reader = new BufferedReader(new FileReader(dfName2));
            rightPane.setText("");
            do {
               rightPane.read(reader, null);
            } while(reader.readLine() != null);
            reader.close();
            
         } catch (Exception e2) {
            JOptionPane.showMessageDialog(this, "로딩 실패");
         }
      }
      else if(e.getSource().equals(rightedit)) {
         rightEditText();
      }
      else if(e.getSource().equals(rightsave)) {
         try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpdir2));
            rightPane.write(writer);
            JOptionPane.showMessageDialog(this, "저장 성공");
            writer.close();
            
         } catch (Exception e2) {
            JOptionPane.showMessageDialog(this, "저장 실패");
         }
      }
   }
      
 
   public void rightEditText(){
      if(rightPane.isEditable() == false) {
         rightPane.setEditable(true);
         rightPane.setBackground(Color.white);
      }
      else {
         rightPane.setEditable(false);
         rightPane.setBackground(Color.lightGray);
            
      }
   
   }
   public void leftEditText() {
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