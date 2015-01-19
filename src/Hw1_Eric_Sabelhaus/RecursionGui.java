package Hw1_Eric_Sabelhaus;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;


public class RecursionGui extends JFrame {

	/**
	 * Generate Swing objects
	 */
	private static final long serialVersionUID = 1L;
	private JTextField myInteger = new JTextField();
	private JRadioButton myRadio = new JRadioButton();
	private JTextField output = new JTextField();
	private JButton submit = new JButton("Submit");
	
	//Instantiate GUI 
	public RecursionGui(){
		JPanel textPanel = new JPanel(new GridLayout(4,2));
		textPanel.add(new JLabel("Integer:"));
		textPanel.add(myInteger);
		textPanel.add(new JLabel("Check Box For Iterative:"));
		textPanel.add(myRadio);
		textPanel.add(new JLabel("Answer:"));
		textPanel.add(output);
		textPanel.setBorder(new TitledBorder("Enter Number"));

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(submit);
		
		add(textPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		submit.addActionListener(new ButtonListener());
	}
	
	//Instantiate action listener to execute code from GUI
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = myInteger.getText();
			double thisDouble;
			double init = 1;
			try {
				thisDouble = Double.parseDouble(input);
				//Break if 0 is passed as an argument
				if (thisDouble < 0) {
					JOptionPane.showMessageDialog ( null, "USER ERROR!!!");
					output.setText("Please enter a value greater than or equal to 0");
				} else {
					//check whether we should calculate the number iteratively or recursively
					if (myRadio.isSelected()){
						//print and output number for iterative method
						System.out.println("Iterative: " + Double.toString(seriesIter(thisDouble)));
						output.setText(Double.toString(seriesIter(thisDouble)));
					} else {
						//print and output number for recursive method
						System.out.println("Recursive: " + Double.toString(seriesRec(thisDouble, init)));
						output.setText(Double.toString(seriesRec(thisDouble, init)));
					}
				}
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog ( null, "ERROR");
				output.setText("Please Enter whole number");
			}

		}

	}
	
	//Iterative loop
	public double seriesIter(double m) {
		double n = 1;
		while(m > 1){
			n = n + (1/Math.pow(2, m));
			m--;
		}
		return n;
	}
	
	//Recursive loop
	public double seriesRec(double n, double o) {
		if (n == 1) return o;
		return seriesRec(n-1, (o + 1 / Math.pow(2,n)));
	}

	/**
	 * execute the recursion GUI on start
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursionGui frame = new RecursionGui();
		frame.pack();
		frame.setTitle("Math Gui");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(500,200);
	}

}
