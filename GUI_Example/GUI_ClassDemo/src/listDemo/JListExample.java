package listDemo;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class JListExample extends JFrame
{
	private JList dayList;
	private String[] days = {"Monday", "Tuesday", "Wednesday"};
	private JButton but;
	private JTextField text;
	private JPanel panel;
	
	public JListExample()
	{
		setTitle("List Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dayList = new JList(days);
		add(dayList, BorderLayout.NORTH);
		but = new JButton("CLEAR");
		text = new JTextField(10);
		panel = new JPanel();
		panel.add(but);
		panel.add(text);
		add(panel, BorderLayout.SOUTH);
		dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dayList.addListSelectionListener(new ListListener());
		but.addActionListener(new ButListener());
		
		pack();
		setVisible(true);		
	}
	
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			// Get the selected month.
			String selection = ((String)dayList.getSelectedValue());
			
			// Put the selected month into the textField.
			text.setText(selection);
		}
	}
	
	private class ButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			text.setText("");
		}
	}
	
	public static void main(String[] args)
	{
		new JListExample();
	}
}