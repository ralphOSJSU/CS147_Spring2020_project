package classAssignmentDemo;

import java.awt.Event.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassAssignment extends JFrame
{
	public JButton addButton;
	public JButton subButton;
	public JTextField text1;
	public JTextField text2;
	public JTextField text3;
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JPanel panel;
	
	public ClassAssignment()
	{
		// Initialize all buttons, labels, and textfields.
		addButton = new JButton("add");
		subButton = new JButton("subtract");
		label1 = new JLabel("Enter Number-1: ");
		label2 = new JLabel("Enter Number-2: ");
		label3 = new JLabel("Result = ");
		text1 = new JTextField(10);
		text2 = new JTextField(10);
		text3 = new JTextField(10);
		
		// Create a JPanel.
		panel = new JPanel();
		
		// Add all buttons, labels, and textfields to the panel.
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(addButton);
		panel.add(subButton);
		
		// Add the panel to the JFrame.
		add(panel);
		
		// Add the ActionListeners to the buttons.
		addButton.addActionListener(new AddButtonListener());
		subButton.addActionListener(new SubButtonListener());
		
		// Set the title, size, and close operation of the JFrame window.
		setTitle("Addition and Subtraction");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Make the JFrame window visible.
		setVisible(true);
	}
	
	private class AddButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			// Get the string inputs, convert to doubles, compute the result, convert result back to String.
			String input1;
			String input2;
			input1 = text1.getText();
			input2 = text2.getText();
			double num1;
			double num2;
			
			num1 = Double.parseDouble(input1);
			num2 = Double.parseDouble(input2);
			
			double result;
			result = num1 + num2;
			
			String addResult;
			addResult = Double.toString(result);
			
			// Set the text3 JTextField to the addResult.
			text3.setText(addResult);
		}
	}
	
	private class SubButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			// Get the string inputs, convert to doubles, compute the result, convert result back to String.
			String input1;
			String input2;
			input1 = text1.getText();
			input2 = text2.getText();
			double num1;
			double num2;
			
			num1 = Double.parseDouble(input1);
			num2 = Double.parseDouble(input2);
			
			double result;
			result = num1 - num2;
			
			String subResult;
			subResult = Double.toString(result);
			
			// Set the text3 JTextField to the subResult.
			text3.setText(subResult);
		}
	}
	
	public static void main(String[] args)
	{
		new ClassAssignment();
	}
	
}