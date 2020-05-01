import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

//This is the frame allowing users to select their choices for reservation
public class FormPanelReservationFrame {

	private JPanel schedulePanel;
	private JPanel roomPanel;
	private JPanel peoplePanel;
	
	private JLabel arrivalDateLabel;
	private JLabel departureDateLabel;
	private JLabel roomLabel;
	private JLabel typeRoomLabel;
	private JLabel adultLabel;
	private JLabel childrenLabel;
	
	private JTextField arrivalField;
	private JTextField departureField;
	
	private JComboBox roomCombo;
	private JRadioButton nonSmokingRadio;
	private JRadioButton smokingRadio;
	private ButtonGroup roomGroup;
	private JComboBox adultCombo;
	private JComboBox childrenCombo;
	private JButton viewAvailBtn;
	private JPanel buttonPanel;
	
	private JDateChooser dateChooserArrival;
	private JDateChooser dateChooserDeparture;
	 
	private Date departureDateChooser;
	private Date arrivalDateChooser;
	 
	private JFrame frame;
	
	public FormPanelReservationFrame() { 
		frame = new JFrame();
		frame.setTitle("Reservation Frame");

		schedulePanel = new JPanel();//panel for dates
		roomPanel = new JPanel();//panel for selecting types of room
		peoplePanel = new JPanel();//panel for selecting numbers of people
		buttonPanel = new JPanel();//panel for a button

		//drop-down list for selection
		roomCombo = new JComboBox();
		adultCombo = new JComboBox();
		childrenCombo = new JComboBox();	
		viewAvailBtn = new JButton("View availability");
		
		//Scheduling dates using JDateChooser method
		dateChooserArrival = new JDateChooser();
	    dateChooserArrival.setBounds(20, 20, 100, 20);
	    dateChooserDeparture = new JDateChooser();
	    dateChooserDeparture.setBounds(20, 20, 100, 20);
	    
	    //labels and text fields for scheduling dates
		arrivalDateLabel = new JLabel("Arrival Date: ");
		departureDateLabel = new JLabel("Departure Date: ");
		arrivalField = new JTextField(10);
		departureField = new JTextField(10);
		
		roomLabel = new JLabel("Room(s):");		
		typeRoomLabel = new JLabel("Types of room: ");
		nonSmokingRadio = new JRadioButton("Non-Smoking");
		smokingRadio = new JRadioButton("Smoking");
		
		adultLabel = new JLabel("Adults (12+):");
		childrenLabel = new JLabel("Children (2-11): ");	   
		
		//setup the panel for schedule
		schedulePanel.setBorder(BorderFactory.createTitledBorder("SET UP YOUR DATE"));
		schedulePanel.setLayout(new GridLayout(2,2));
		schedulePanel.add(arrivalDateLabel);
	    schedulePanel.add(departureDateLabel);
	    
	    //convert the chosen dates from JCalendar to string type
	    String arrivalStr  = ((JTextField)dateChooserArrival.getDateEditor().getUiComponent()).getText();	  
	    arrivalField.setText(arrivalStr);//set string dates into text field
	    arrivalField.setEditable(false);
	    arrivalField.add(dateChooserArrival);
	 		
	    Date todayDate = new Date(System.currentTimeMillis());
	    dateChooserArrival.getJCalendar().setMinSelectableDate(todayDate);//deselect all the previous dates except the current date
	    schedulePanel.add(dateChooserArrival);
	   
	    String departureStr  = ((JTextField)dateChooserArrival.getDateEditor().getUiComponent()).getText();	  
	    departureField.setText(departureStr);
	    departureField.setEditable(false);
	    departureField.add(dateChooserDeparture);
	    
	    //disable the text fields to be non-edited
	    JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooserArrival.getDateEditor();
	    editor.setEditable(false);
	    JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateChooserDeparture.getDateEditor();
	    editor2.setEditable(false);
	    
	    //deselect all the previous dates including the current date, except the date after the current date
	    Date tomorrow = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	    dateChooserDeparture.getJCalendar().setMinSelectableDate(tomorrow); 	    
	    schedulePanel.add(dateChooserDeparture);
	     
	    //setup the panel for room
	    roomPanel.setBorder(BorderFactory.createTitledBorder("SELECT THE TYPE OF YOUR ROOM(S)"));
	    DefaultComboBoxModel roomModel = new DefaultComboBoxModel();
		roomModel.addElement("Standard");
		roomModel.addElement("Deluxe");
		roomModel.addElement("Superior");
		roomModel.addElement("Family");
		roomModel.addElement("Suite");
		roomCombo.setModel(roomModel);
		roomCombo.setSelectedIndex(0);//make standard room as the first selected element
		
		//rooms radio
		nonSmokingRadio.setActionCommand("Non-Smoking");
		smokingRadio.setActionCommand("Smoking");
		roomGroup = new ButtonGroup();
		nonSmokingRadio.setSelected(true);//set the non-smoking as the first selected element
		roomGroup.add(nonSmokingRadio);
		roomGroup.add(smokingRadio);	
		
		roomPanel.setLayout(new GridLayout(5,1));
		roomPanel.add(roomLabel);
		roomPanel.add(roomCombo);
		roomPanel.add(typeRoomLabel);		
		roomPanel.add(nonSmokingRadio);
		roomPanel.add(smokingRadio);
		
		JPanel pPanel = new JPanel();//create new panel for adding the people panel
	    peoplePanel.setBorder(BorderFactory.createTitledBorder("SELECT THE NUMBER OF PEOPLE"));
	    pPanel.add(peoplePanel);
	    DefaultComboBoxModel adultModel = new DefaultComboBoxModel();//add needed elements 
		adultModel.addElement("1");
		adultModel.addElement("2");
		adultModel.addElement("3");
		adultModel.addElement("4");
		adultCombo.setModel(adultModel);
		adultCombo.setSelectedIndex(0);
		DefaultComboBoxModel childrenModel = new DefaultComboBoxModel();
		childrenModel.addElement("0");
		childrenModel.addElement("1");
		childrenModel.addElement("2");
		childrenModel.addElement("3");
		childrenCombo.setModel(childrenModel);
		childrenCombo.setSelectedIndex(0);
		
		peoplePanel.setLayout(new GridLayout(2,2));
		peoplePanel.add(adultLabel);
		peoplePanel.add(adultCombo);
		peoplePanel.add(childrenLabel);
		peoplePanel.add(childrenCombo);
		
		//add a listener to the button
	    viewAvailBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String roomTypeList = (String) roomCombo.getSelectedItem();				
				String roomType = roomGroup.getSelection().getActionCommand();
				String numAdults = (String) adultCombo.getSelectedItem();
				String numChildren = (String) childrenCombo.getSelectedItem();
				
				//obtain chosen dates as a string
				arrivalDateChooser = dateChooserArrival.getDate();
				String dateFromString = String.format("%1$td-%1$tm-%1$tY", arrivalDateChooser);	  	
				arrivalField.setText(dateFromString);
				String arrivalD = arrivalField.getText();
				
				departureDateChooser = dateChooserDeparture.getDate();
				String dateToString = String.format("%1$td-%1$tm-%1$tY", departureDateChooser);	  	
				departureField.setText(dateToString);
				String departureD = departureField.getText();
				
				boolean cont = isValidDate(); // check if both dates are valid inputs
				//valid dates continue to the next frame, then dispose the frame
				if (cont == true) {
					FormEvent ev = new FormEvent(this, arrivalDateChooser,departureDateChooser, roomTypeList, roomType, numAdults, numChildren);
					Hotel h = new Hotel();
					RoomSelectionFrame rSelectionFrame = new RoomSelectionFrame(ev,h);
				}
	
				frame.dispose();
				
			}
			
		});	
	    
	    buttonPanel.add(viewAvailBtn);

	    pPanel.add(buttonPanel);
	    pPanel.setLayout(new BorderLayout(0,0));
	    pPanel.add(peoplePanel,BorderLayout.NORTH);
	    pPanel.add(buttonPanel,BorderLayout.SOUTH);
	    //add all needed panels into the main frame
	    frame.add(schedulePanel, BorderLayout.NORTH);
	    frame.add(roomPanel, BorderLayout.CENTER);
	    frame.add(pPanel, BorderLayout.SOUTH);
	    frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		frame.pack();
		frame.setVisible(true); 
		
	}
	
	 public boolean isValidDate() {
		 //if one of the dates or both of them are not entered
		 if (departureDateChooser == null || arrivalDateChooser == null || (departureDateChooser == null && arrivalDateChooser == null)) {
			 JOptionPane.showMessageDialog(frame,
	                  "Please choose an arrival date and a departure date.", "KSR Hotel Message Error",
	                  JOptionPane.ERROR_MESSAGE);
			 return false;
		 }
		 //if both dates are the chosen on the same day
		 else if (departureDateChooser.getDate() - (arrivalDateChooser).getDate() == 0) {
			 JOptionPane.showMessageDialog(frame,
	                  "You must stay a minimum of at least one night.", "KSR Hotel Message Error",
	                  JOptionPane.ERROR_MESSAGE);
			 return false;
		 }
		 //arrival date has to come before the departure date
		 else if(departureDateChooser.before(arrivalDateChooser)){
	         JOptionPane.showMessageDialog(frame,
	                  "Check-out date is earlier than the check-in date. Please try again", "KSR Hotel Message Error",
	                  JOptionPane.ERROR_MESSAGE);
	         return false;
	      }
		 return true;
	 }
	
	
}

