import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Syuseki {
	public static void main(String[] args){
		SyusekiMan s = new SyusekiMan();
	}
}

class SyusekiMan implements ActionListener{
	JFrame frame;
	JButton btn1;
	JButton btn2;
	JPanel panel;
	JTextField field;
	JTextArea area;
	JFileChooser fc;
	String textdata;
	

	public SyusekiMan(){

		frame = new JFrame("出席アプリ");
		frame.setLocation(500,250);
		frame.setSize(500,500);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn1 = new JButton("保存");
		btn2 = new JButton("追加");
		panel = new JPanel();
		panel.add(btn1);
		panel.add(btn2);
		field = new JTextField(10);
		area = new JTextArea(10,30);
		
		//area.setLineWrap(true);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2,1));
		frame.getContentPane().setLayout(new FlowLayout());
		con.add(panel);
		con.add(field);
		con.add(area);
		

		frame.setVisible(true);

		btn1.addActionListener(this);
		btn1.setActionCommand("Save");
		btn2.addActionListener(this);
		btn2.setActionCommand("tuika");
	}
	public void actionPerformed(ActionEvent ae){
		String cmd = ae.getActionCommand();

		if(cmd.equals("Save")){
			fc = new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			int ret = fc.showSaveDialog(frame);
			if(ret == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();

				textdata = file.getAbsolutePath();
			}
			try{
				File f = new File(textdata);
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				String data = area.getText();

				pw.println(data);

				pw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}