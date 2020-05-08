package guiButtonDemo;

import javax.swing.*;		// Needed for swing classes.
import java.awt.event.*;	// Needed for ActionListener Interface


// The difference from KiloCovnerter2 is that actionPerformed debugs information to the console.
public class KiloConverter3 extends JFrame
{
	private JPanel panel;						// To reference a panel
	private JLabel messageLabel;				// To reference a label
	private JTextField kiloTextField;			// To reference a text field
	private JButton calcButton;					// To reference a button
	private final int WINDOW_WIDTH = 310;		// Window width
	private final int WINDOW_HEIGHT = 100;		// Window height
	
	// Constructor.
	public KiloConverter3()
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
		
		// This adds an action listener to the button.
		// This line gives it functionality via implemented method actionPerformed().
		calcButton.addActionListener(new CalcButtonListener());
		
		// Create a JPanel object. Think of the panel as a blank piece of paper.
		panel = new JPanel();
		
		// Add the label, text field, and button components to the panel.
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(calcButton);
	}
	
	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			final double CONVERSION = 0.6214;
			String input;		// To hold the user's input
			double miles;		// The number of miles.
			
			// Get the text entered by the user into the text field.
			input = kiloTextField.getText();
			
			// For debugging, display the text entered, and its value converted to a double.
			System.out.println("Reading " + input + " from the text field.");
			System.out.println("Converted value: " + Double.parseDouble(input));
			
			// Convert the input to miles.
			miles = Double.parseDouble(input) * CONVERSION;
			
			// Display the result.
			JOptionPane.showMessageDialog(null, input + " kinometers is " + miles + " miles.");
		}
	}
	
	public static void main(String[] args)
	{
		new KiloConverter3();
	}
	
}
