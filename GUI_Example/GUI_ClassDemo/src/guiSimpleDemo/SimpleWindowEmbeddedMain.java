package guiSimpleDemo;

import javax.swing.JFrame;

public class SimpleWindowEmbeddedMain extends JFrame
{
	// Constructor. No longer needs to create new JFrame because extends it.
	public SimpleWindowEmbeddedMain()
	{
		final int WINDOW_WIDTH = 350;		// Window width in pixels.
		final int WINDOW_HEIGHT = 250;		// Window height in pixels.
		
		// Set the title.
		setTitle("A Simple Window");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the window.
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		SimpleWindowEmbeddedMain myWindow = new SimpleWindowEmbeddedMain();
	}
}
