package cal_gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui extends JFrame{
	gui(){
		setTitle("°è»ê±â");
		getNorth();
		getCenter();
		
		setSize(250,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void getNorth() {
		JPanel p = new JPanel();
		JTextField tf = new JTextField(20);
		p.add(tf);
		add(p,BorderLayout.NORTH);
	}
	
	void getCenter() {
		JPanel panel = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel(new GridLayout(4,4,10,10));
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bp = new JButton("£«");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bm = new JButton("£­");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bx = new JButton("¡¿");
		JButton b0 = new JButton("0");
		JButton bdot = new JButton(".");
		JButton be = new JButton("£½");
		JButton bd = new JButton("¡À");
		JButton bon = new JButton("on");
		JButton boff = new JButton("off");
		p1.add(bon);
		p1.add(boff);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(bp);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(bm);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(bx);
		p2.add(b0);
		p2.add(bdot);
		p2.add(be);
		p2.add(bd);
		panel.add(p1);
		panel.add(p2);
		add(panel, BorderLayout.CENTER);
	}

}
