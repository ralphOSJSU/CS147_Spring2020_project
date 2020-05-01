import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


//this is the main frame class that enables user to make a reservation
public class MainFrame {
	
	private JButton booking ;
	private JPanel northPanel;
	private JLabel northLabel;
	private JPanel southPanel;
	private JFrame frame;//main frame created
	
	public MainFrame(Hotel h){
	frame = new JFrame(); 
	frame.setTitle("KSR Reservation System");//System's title
	
	booking = new JButton("Reserving Your Room(s)");
	
	northLabel = new JLabel("Welcome to KSR Reservation System");//hotel's greeting
    northLabel.setFont(new Font("Serif", Font.PLAIN, 24));
    northLabel.setHorizontalAlignment(JLabel.CENTER);


	northPanel = new JPanel();//north panel for greeting
	southPanel = new JPanel();//south panel for a booking button
	
	northPanel.setLayout(new BorderLayout());
	northPanel.add(northLabel, BorderLayout.NORTH);//add the greeting label into the north panel
	Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);
    northPanel.setBorder(lineBorder);	
 	
	
    southPanel.setLayout(new BorderLayout(0,0));
    southPanel.setSize(400, 400);
    booking.setPreferredSize(new Dimension(200, 200));
    	southPanel.add(booking, BorderLayout.CENTER);//add a booking button into the south panel
  
	//add both panels into the main frame
	frame.add(northPanel, BorderLayout.NORTH);
	frame.add(southPanel, BorderLayout.CENTER);
	
	//add a listener for a booking button connected to the form panel
	booking.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new FormPanelReservationFrame();
			
		}
	});

	
	frame.setSize(600,600);//size of the main frame
	frame.setResizable(false);  //no resizable frame
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
		
}
}
