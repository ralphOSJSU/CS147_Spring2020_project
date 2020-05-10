package guiButtonDemo;

import javax.swing.*;

public class KiloConverter extends JFrame
{
	private JPanel panel;				
	private JLabel messageLabel;		
	private JTextField kiloTextField;	
	private JButton calcButton;			
	private final int WINDOW_WIDTH = 310;
	private final int WINDOW_HEIGHT = 100;
	
	// Constructor
	public KiloConverter()
	{
		// Set the window title.
		setTitle("Kilometer Converter");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is pressed.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel and add buttons to the panel.
		buildPanel();
		
		// Add the panel to the frame's content pane.
		add(panel);
		
		// Display the Window.
		setVisible(true);
	}
	
	
	private void buildPanel()
	{
		// Create a label to display instructions.
		messageLabel = new JLabel("Enter a distance " + "in kilometers");
		
		// Create a text field 10 characters wide.
		kiloTextField = new JTextField(10);
		
		// Create a button with the caption "Calculate".
		calcButton = new JButton("Calculate");
		
		// Create a JPanel object. Think of the panel as a blank piece of paper.
		panel = new JPanel();
		
		// Add the label, text field, and button components to the panel.
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(calcButton);
	}
	
	public static void main(String[] args)
	{
		new KiloConverter();
	}
	
}