package sliderGUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class TempConverter extends JFrame
{
	private JLabel label1, label2;		// Message labels	
	private JTextField fahrenheitTemp;	// Fahrenheit temp
	private JTextField celciusTemp;		// Celcius temp
	private JPanel fpanel;				// Fahrenheit panel
	private JPanel cpanel;				// Celcius panel
	private JPanel sliderPanel;			// Slider panel
	private JSlider slider;				// Temperature adjuster
	
	
	// Constructor
	public TempConverter()
	{
		// Set the title.
		setTitle("Temperatures");
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the message labels.
		label1 = new JLabel("Fahrenheit: ");
		label2 = new JLabel("Celsius: ");
		
		// Create the read-only text fields so that user cannot edit it.
		fahrenheitTemp = new JTextField("32.0", 10);
		fahrenheitTemp.setEditable(false);			
		celciusTemp = new JTextField("0.0", 10);
		celciusTemp.setEditable(false);
		
		// Create the slider.
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		slider.setMajorTickSpacing(20);		// Major tick every 20
		slider.setMinorTickSpacing(5);     	// Minor tick every 5
		slider.setPaintTicks(true);			// Display tick marks
		slider.setPaintLabels(true);		// Display numbers
		slider.addChangeListener(new SliderListener());
		
		// Create panels and place the components in them.
		fpanel = new JPanel();
		fpanel.add(label1);
		fpanel.add(fahrenheitTemp);
		cpanel = new JPanel();
		cpanel.add(label2);
		cpanel.add(celciusTemp);
		sliderPanel = new JPanel();
		sliderPanel.add(slider);
		
		// Create a GridLayout manager. This makes 3 rows, 1 column.
		setLayout(new GridLayout(3,1));
		
		// Add the panels to the content pane.
		add(fpanel);
		add(cpanel);
		add(sliderPanel);
		
		// Pack and display the frame.
		pack();
		setVisible(true);	
	}
	
	private class SliderListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			double fahrenheit, celsius;
			
			// Get the slider value.
			celsius = slider.getValue();
			
			// Convert the value to fahrenheit
			fahrenheit = (9.0 / 5.0) * celsius + 32.0;
			
			// Store the celsius temp in its display field.
			celciusTemp.setText(Double.toString(celsius));
			
			// Store the fahrenheit temp in its display field.
			fahrenheitTemp.setText(String.format("%.1f", fahrenheit));
		}
		
	}
	
	public static void main(String[] args)
	{
		new TempConverter();
	}
}
