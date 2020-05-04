import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class MainFrame {
	
	private JButton booking ;
	private JButton canceling;
	private JPanel northPanel;
	private JLabel northLabel;
	private JPanel southUpperPanel;
	private JPanel southLowerPanel;
	private JFrame frame;

	public MainFrame(){
		frame = new JFrame();
	//super("KSR Reservation System");
	frame.setTitle("KSR Reservation System");
	booking = new JButton("Reserving Your Room(s)");
	canceling = new JButton("Canceling/Viewing Your Booking");
	northLabel = new JLabel("Welcome to KSR Reservation System");
    northLabel.setFont(new Font("Serif", Font.PLAIN, 24));
    northLabel.setHorizontalAlignment(JLabel.CENTER);


	northPanel = new JPanel();  
	southUpperPanel = new JPanel();
	southLowerPanel = new JPanel();
	
	northPanel.setLayout(new BorderLayout());
	northPanel.add(northLabel, BorderLayout.NORTH);	
	Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);
    northPanel.setBorder(lineBorder);	
 	
	//southPanel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
    southUpperPanel.setLayout(new BorderLayout(0,0));
    southUpperPanel.setSize(400, 400);
    booking.setPreferredSize(new Dimension(200, 200));
    	southUpperPanel.add(booking, BorderLayout.CENTER);	
   // southPanel.add(canceling,BorderLayout.SOUTH);
    	southLowerPanel.setLayout(new BorderLayout(0,0));
    southLowerPanel.setSize(400, 400);

    // southLowerPanel.setPreferredSize(new Dimension(400,300));
   // canceling.setSize(200, 200);
    canceling.setPreferredSize(new Dimension(200, 200));
    southLowerPanel.add(canceling, BorderLayout.CENTER);	
	
	//booking.setPreferredSize(new Dimension(40, 40));
	
	frame.add(northPanel, BorderLayout.NORTH);
	frame.add(southUpperPanel, BorderLayout.CENTER);
	frame.add(southLowerPanel, BorderLayout.SOUTH);
	
	
	booking.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new FormPanelReservationFrame();
			
		}
	});
	
	frame.setSize(600,600);
	frame.setResizable(false);  
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
		
}
}
