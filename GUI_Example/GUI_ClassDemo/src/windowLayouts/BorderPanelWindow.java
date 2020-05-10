package windowLayouts;
import java.awt.*;
import javax.swing.*;

public class BorderPanelWindow extends JFrame
{
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 300;
	
	public BorderPanelWindow()
	{
		// Set the title bar text.
		setTitle("Border Layout");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a BorderLayout manager to the content panel.
		setLayout(new BorderLayout());
		
		// Create five buttons.
		JButton button1 = new JButton("North Button");
		JButton button2 = new JButton("South Button");
		JButton button3 = new JButton("East Button");
		JButton button4 = new JButton("West Button");
		JButton button5 = new JButton("Center Button");
		
		// Add the five buttons to the content panel.
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(button3, BorderLayout.EAST);
		add(button4, BorderLayout.WEST);
		add(button5, BorderLayout.CENTER);
		
		// Display the window.
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new BorderPanelWindow();
	}
}