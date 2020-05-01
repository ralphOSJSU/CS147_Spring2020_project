import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

	//this is the class where users can cancel their reservations
	public class CancelingFrame extends JFrame
	{ 
	   private Hotel hotel = new Hotel();   
	   private final JFrame frame = new JFrame();
	   private final JPanel messagePanel = new JPanel();
	   private final JPanel reserveListPanel = new JPanel();
	   private final JPanel cancelBtnPanel = new JPanel();
	   private final JScrollPane reserveListScrollPane ;
	   private final JButton cancelButton = new JButton("Cancel Reservation");
	   private final JList<RoomReservation> jlist = new JList<RoomReservation>(); 
	   private DefaultListModel<RoomReservation> model = new DefaultListModel<RoomReservation>();
	  
	   /**
	    * constructor for displaying the canceling frame
	    * @param h
	    */
	 public CancelingFrame(Hotel h)
	 {
	    
	      setTitle("KSR Hotel Reservation Viewing Frame");
	      setSize(new Dimension(600,600));

	      messagePanel.setLayout(new BorderLayout());
	      JLabel label = new JLabel("Here is the overview of your reservation .Please select" +
	      							 "on an item for cancelation");
	      
	      messagePanel.add(label,BorderLayout.NORTH);
	      Border messageBorder = BorderFactory.createLineBorder(Color.GRAY);
	      messagePanel.setBorder(messageBorder);
	      //get the selected list of rooms that are added into a reservation
	      Iterator<Room> it =h.roomIterator();
	      while (it.hasNext()) {

				Room r = it.next();
				RoomReservations rs = r.getReservations();
				Iterator<RoomReservation> iter = rs.getReservations();
				while (iter.hasNext()) {
					RoomReservation re = iter.next();
					model.addElement(re);
				}
				
			}
	      jlist.setModel(model);
   
		  reserveListScrollPane= new JScrollPane(jlist);
	      reserveListPanel.setLayout(new BorderLayout());
	      reserveListPanel.add(reserveListScrollPane, BorderLayout.CENTER);
	      cancelButton.setEnabled(true);
	      //add listener to a canceling button
	      cancelButton.addActionListener(new ActionListener()
	      {
	         public void actionPerformed(ActionEvent e)
	         {
	            //user can select the index to remove rooms in their reservation   
	        	 	RoomReservation reserve = jlist.getSelectedValue();
	        	 	if(reserve != null){
	        	 		int index = jlist.getSelectedIndex();
	        	 		model.remove(index);
	        	 		hotel.CancelingReservation(reserve);
	        	 		
	        	 	}
	        	 	else {
	        	 		setEnabled(false);
	        	 	}
	        	 	
	         }
	      });


	      cancelBtnPanel.add(cancelButton, BorderLayout.SOUTH);
	      Border cancelBorder = BorderFactory.createLineBorder(Color.GRAY);
	      cancelBtnPanel.setBorder(cancelBorder);

	      add(messagePanel, BorderLayout.NORTH);
	      add(reserveListPanel, BorderLayout.CENTER);
	      
	      add(cancelBtnPanel, BorderLayout.SOUTH);
	      
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	      setVisible(true);
	   }
			
	}

	 
	   
	




