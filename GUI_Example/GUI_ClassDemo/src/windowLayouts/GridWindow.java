package windowLayouts;
import java.awt.*;
import javax.swing.*;

public class GridWindow extends JFrame
{
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 200;
	
	public GridWindow()
	{
		// Set the title bar text.
		setTitle("Grid Layout");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a GridLayout manager to the content panel. 2 rows, 3 columns.
		setLayout(new GridLayout(2,3));
		
		// Create six buttons.
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");
		JButton button4 = new JButton("Button4");
		JButton button5 = new JButton("Button5");
		JButton button6 = new JButton("Button6");
		
		// Add the six buttons to the content panel.
		add(button1);		// Goes into row 1, column 1
		add(button2);		// Goes into row 1, column 2
		add(button3);		// Goes into row 1, column 3
		add(button4);		// Goes into row 2, column 1
		add(button5);		// Goes into row 2, column 2
		add(button6);		// Goes into row 2, column 3
		
		// Display the window.
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GridWindow();
	}
}
