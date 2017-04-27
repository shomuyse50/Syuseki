import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Syuseki {
	public static void main(String[] args){
		SyusekiMan s = new SyusekiMan();
	}
}

class SyusekiMan implements ActionListener{
	JFrame frame;
	JButton btn1;
	JPanel panel;
	JTextArea area;

	public SyusekiMan(){

		frame = new JFrame("出席アプリ");
		frame.setLocation(500,250);
		frame.setSize(500,500);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn1 = new JButton("表示");
		panel = new JPanel();
		panel.add(btn1);
		area = new JTextArea(10,30);
		//area.setLineWrap(true);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2,1));
		frame.getContentPane().setLayout(new FlowLayout());
		con.add(panel);
		con.add(area);

		frame.setVisible(true);

		btn1.addActionListener(this);
		btn1.setActionCommand("open");
	}
	public void actionPerformed(ActionEvent ae){
		String cmd = ae.getActionCommand();
	}
}