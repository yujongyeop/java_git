package cal_gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	JPanel p = new JPanel();
	JPanel p1 = new JPanel(new GridLayout(4, 4));
	JTextField tf = new JTextField(20);
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton bp = new JButton("+");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton bm = new JButton("-");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton bx = new JButton("x");
	JButton b0 = new JButton("0");
	JButton bdot = new JButton(".");
	JButton be = new JButton("=");
	JButton bd = new JButton("/");
	String[] operator = { "+", "-", "x", "/","=" };

	gui() {
		setTitle("Calculator");
		getNorth();
		getCenter();
		event();
		setSize(250,300);
		//super.pack();
		setLayout(new GridLayout(2,1));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void getNorth() {
		tf.setPreferredSize(new Dimension(250, 50));
		p.add(tf);
		tf.setText("");
		this.add(p);
	}

	void getCenter() {
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(bp);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(bm);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(bx);
		p1.add(b0);
		p1.add(bdot);
		p1.add(be);
		p1.add(bd);
		this.add(p1);
	}

	void event() { // event 
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bp.addActionListener(this);
		bm.addActionListener(this);
		bx.addActionListener(this);
		bd.addActionListener(this);
		be.addActionListener(this);

	}

	String calculate(String before, String operator) { // Calculating area
		String split_operator = "[" + operator+"]"; //Slove (Dangling meta character "+" near index 0)
		String[] arry = before.split(split_operator);
		double result = 0;
		switch (operator) {
		case "+":
			result = Double.parseDouble(arry[0]) + Double.parseDouble(arry[1]);
			break;
		case "-":
			result = Double.parseDouble(arry[0]) - Double.parseDouble(arry[1]);
			break;
		case "x":
			result = Double.parseDouble(arry[0]) * Double.parseDouble(arry[1]);
			break;
		case "/":
			result = Double.parseDouble(arry[0]) / Double.parseDouble(arry[1]);
			break;
		}
		return Double.toString(result);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ebtn = (JButton) e.getSource();
		if (Arrays.asList(operator).indexOf(ebtn.getText()) >= 0
				&& Arrays.asList(operator).indexOf(ebtn.getText()) <= 4) {
			if (tf.getText().contains("+"))
				tf.setText(calculate(tf.getText(), "+"));
			else if (tf.getText().contains("-"))
				tf.setText(calculate(tf.getText(), "-"));
			else if (tf.getText().contains("x"))
				tf.setText(calculate(tf.getText(), "x"));
			else if (tf.getText().contains("/"))
				tf.setText(calculate(tf.getText(), "/"));
			if (ebtn.getText() != "=")
				tf.setText(tf.getText() + ebtn.getText());
		} else
			tf.setText(tf.getText() + ebtn.getText());
	}
}
