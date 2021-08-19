package cal_gui;

import java.awt.BorderLayout;
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
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new GridLayout(4, 4, 10, 10));
	JTextField tf = new JTextField(20);
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
	String[] operator = { "+", "£­", "¡¿", "¡À","£½" };

	gui() {
		setTitle("Calculator");
		getNorth();
		getCenter();
		event();
		setSize(250, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void getNorth() {
		p.add(tf);
		tf.setText("");
		add(p, BorderLayout.NORTH);
	}

	void getCenter() {
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
		bon.addActionListener(this);
		boff.addActionListener(this);

	}

	String calculate(String before, String operator) { // Calculating area
		String[] arry = before.split(operator);
		long result = 0;
		switch (operator) {
		case "£«":
			result = Integer.parseInt(arry[0]) + Integer.parseInt(arry[1]);
			break;
		case "£­":
			result = Integer.parseInt(arry[0]) - Integer.parseInt(arry[1]);
			break;
		case "¡¿":
			result = Integer.parseInt(arry[0]) * Integer.parseInt(arry[1]);
			break;
		case "¡À":
			result = Integer.parseInt(arry[0]) / Integer.parseInt(arry[1]);
			break;
		}
		return Long.toString(result);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ebtn = (JButton) e.getSource();
		if (Arrays.asList(operator).indexOf(ebtn.getText()) >= 0
				&& Arrays.asList(operator).indexOf(ebtn.getText()) <= 4) {
			if (tf.getText().contains("£«"))
				tf.setText(calculate(tf.getText(), "£«"));
			else if (tf.getText().contains("£­"))
				tf.setText(calculate(tf.getText(), "£­"));
			else if (tf.getText().contains("¡¿"))
				tf.setText(calculate(tf.getText(), "¡¿"));
			else if (tf.getText().contains("¡À"))
				tf.setText(calculate(tf.getText(), "¡À"));
			if (ebtn.getText() != "£½")
				tf.setText(tf.getText() + ebtn.getText());
		} else
			tf.setText(tf.getText() + ebtn.getText());
	}
}
