package windowLayouts;
import java.awt.FlowLayout;
import javax.swing.*;

public class FlowWindow extends JFrame
{
	private final int WINDOW_WIDTH = 200;	// Window width.
	private final int WINDOW_HEIGHT = 105;	// Window height.
	
	// Constructor
	public FlowWindow()
	{
		// Set the title bar text.
		setTitle("Flow Layout");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a FlowLayout manager to the content pane. 
		// By default, the layout of the JFrame is Border Layout.
		// This changes the buttons positions depending on the size of the window.
		setLayout(new FlowLayout());
		
		// Create three buttons.
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		
		// Add the three buttons to the content pane (the frame).
		add(button1);
		add(button2);
		add(button3);
		
		// Display the window.
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new FlowWindow();
	}
	
}