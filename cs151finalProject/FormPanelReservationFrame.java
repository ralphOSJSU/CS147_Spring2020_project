
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

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
	
	private FormListener formListener; 
	private JFrame frame;
	
	public FormPanelReservationFrame() { 
		frame = new JFrame();
		frame.setTitle("Reservation Frame");
        //frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); 

		
		schedulePanel = new JPanel();
		roomPanel = new JPanel();
		peoplePanel = new JPanel();
		roomCombo = new JComboBox();
		adultCombo = new JComboBox();
		childrenCombo = new JComboBox();
		
		viewAvailBtn = new JButton("View availability");
		buttonPanel = new JPanel();
		
		dateChooserArrival = new JDateChooser();
	    dateChooserArrival.setBounds(20, 20, 100, 20);
	    dateChooserDeparture = new JDateChooser();
	    dateChooserDeparture.setBounds(20, 20, 100, 20);


		
		arrivalDateLabel = new JLabel("Arrival Date: ");
		departureDateLabel = new JLabel("Departure Date: ");
		arrivalField = new JTextField(10);
		departureField = new JTextField(10);
		
		roomLabel = new JLabel("Room(s):");
		typeRoomLabel = new JLabel("Types of room(s): ");	   
		
		typeRoomLabel = new JLabel("Types of room: ");
		nonSmokingRadio = new JRadioButton("Non-Smoking");
		smokingRadio = new JRadioButton("Smoking");
		
		adultLabel = new JLabel("Adults (12+):");
		childrenLabel = new JLabel("Children (2-11): ");	   
		

		//setup the panel for schedule
		schedulePanel.setBorder(BorderFactory.createTitledBorder("SET UP YOUR DATE"));
		//BoxLayout layoutSchedule = new BoxLayout(schedule, BoxLayout.X_AXIS);
		//schedule.setLayout(layoutSchedule);
		schedulePanel.setLayout(new GridLayout(2,2));
		schedulePanel.add(arrivalDateLabel);
	    schedulePanel.add(departureDateLabel);
	  
	   
	   // Calendar cal = Calendar.getInstance();
	  // arrivalField = new JTextField(30);
	    String arrivalStr  = ((JTextField)dateChooserArrival.getDateEditor().getUiComponent()).getText();	  
	    arrivalField.setText(arrivalStr);
	    arrivalField.add(dateChooserArrival);
	 	
	 	
	 	
	    Date todayDate = new Date(System.currentTimeMillis());
	   // Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
	    dateChooserArrival.getJCalendar().setMinSelectableDate(todayDate);  
	    schedulePanel.add(dateChooserArrival);
	   
	    //cal.add(Calendar.DATE, 7); 
	    //departureField = new JTextField(dt.format(cal.getTime()));
	    String departureStr  = ((JTextField)dateChooserArrival.getDateEditor().getUiComponent()).getText();	  
	    departureField.setText(departureStr);
	    departureField.add(dateChooserDeparture);
	    
	    Date tomorrow = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24));
	    dateChooserDeparture.getJCalendar().setMinSelectableDate(tomorrow); 
	    
	    schedulePanel.add(dateChooserDeparture);
	   
	   
	 
	    
	    //setup the panel for room
	    roomPanel.setBorder(BorderFactory.createTitledBorder("SELECT THE NUMBER AND TYPE OF YOUR ROOM(S)"));
	    DefaultComboBoxModel roomModel = new DefaultComboBoxModel();
		roomModel.addElement("1");
		roomModel.addElement("2");
		roomModel.addElement("3");
		roomModel.addElement("4");
		roomModel.addElement("5");
		roomCombo.setModel(roomModel);
		roomCombo.setSelectedIndex(0);
		//room radio
		nonSmokingRadio.setActionCommand("Non-Smoking");
		smokingRadio.setActionCommand("Smoking");
		roomGroup = new ButtonGroup();
		smokingRadio.setSelected(true);
		roomGroup.add(nonSmokingRadio);
		roomGroup.add(smokingRadio);	
		
		roomPanel.setLayout(new GridLayout(5,1));
		roomPanel.add(roomLabel);
		roomPanel.add(roomCombo);
		roomPanel.add(typeRoomLabel);
		roomPanel.add(smokingRadio);
		roomPanel.add(nonSmokingRadio);
		
		JPanel pPanel = new JPanel();
	    peoplePanel.setBorder(BorderFactory.createTitledBorder("SELECT THE NUMBER OF PEOPLE"));
	    pPanel.add(peoplePanel);
	    DefaultComboBoxModel adultModel = new DefaultComboBoxModel();
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

	  
	    //Boolean value = true;
		//if((arrivalField.getText().isEmpty() || departureField.getText().isEmpty()) || (arrivalField.getText().isEmpty() && departureField.getText().isEmpty())){
			//value = false;
			//viewAvailBtn.setEnabled(false);
		//}
	    
	  // if((arrivalField.getText().length()<=0 || departureField.getText().length()<=0) ||(arrivalField.getText().length()<=0 && departureField.getText().length()<=0)){
			//arrivalD: false; //departureD: false f&f-> f
			//value = true;
			//viewAvailBtn.setEnabled(false);
			
		//}  	   
/**
	    ButtonModel model = viewAvailBtn.getModel();
	    Document doc1 = arrivalField.getDocument();
	    Document doc2 = departureField.getDocument();
	    ButtonEnablement btnEnablement = new ButtonEnablement(model);
	    //btnEnablement.
	    btnEnablement.addDocument(doc1);
		btnEnablement.addDocument(doc2);
		btnEnablement.documentChanged();
		btnEnablement.documentChanged();**/

	    viewAvailBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String numRoom = (String) roomCombo.getSelectedItem();				
				String roomType = roomGroup.getSelection().getActionCommand();
				String numAdults = (String) adultCombo.getSelectedItem();
				String numChildren = (String) childrenCombo.getSelectedItem();
				
				arrivalDateChooser = dateChooserArrival.getDate();
				String dateFromString = String.format("%1$td-%1$tm-%1$tY", arrivalDateChooser);	  	
				arrivalField.setText(dateFromString);
				String arrivalD = arrivalField.getText();
				
				departureDateChooser = dateChooserDeparture.getDate();
				String dateToString = String.format("%1$td-%1$tm-%1$tY", departureDateChooser);	  	
				departureField.setText(dateToString);
				String departureD = departureField.getText();
				//FormEvent ev = new FormEvent(this, arrivalD, departureD, numRoom, roomType, numAdults, numChildren);
				FormEvent ev = new FormEvent(this, arrivalD, departureD, numRoom, roomType, numAdults, numChildren);
				if(formListener != null) {
					formListener.formEventOccurred(ev);
					
					} 
				RoomSelectionFrame rSelectionFrame = new RoomSelectionFrame(ev);
				
				frame.dispose();
				
				// Boolean value = false;
				//boolean val = (arrivalD.isEmpty() && departureD.isEmpty());
				//if(!(arrivalD.isEmpty() && departureD.isEmpty()) ){
					//arrivalD: false; //departureD: false f&f-> f
					//value = true;
					//viewAvailBtn.setEnabled(false);
				//}
			   
				//else {
					//value = true;
					//
					
					
				//}
				//btnEnablement.documentChanged();
				//String cmd = e.getActionCommand();
				//if(cmd.equals("Open")) {
					//frame.dispose();
					//
				//}
				
				
			}
			
		});	
	    
	    buttonPanel.add(viewAvailBtn);
	    pPanel.add(buttonPanel);
	    pPanel.setLayout(new BorderLayout(0,0));
	    pPanel.add(peoplePanel,BorderLayout.NORTH);
	    pPanel.add(buttonPanel,BorderLayout.SOUTH);
	   
	    frame.add(schedulePanel, BorderLayout.NORTH);
	    frame.add(roomPanel, BorderLayout.CENTER);
	    frame.add(pPanel, BorderLayout.SOUTH);
		//btnEnablement.documentChanged();
	    frame.setPreferredSize(new Dimension(400,400));
		//setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		frame.pack();
		frame.setVisible(true); 
		
	}
	
	 public void isValidDate() {
		 if(departureDateChooser.before(arrivalDateChooser)){
	         JOptionPane.showMessageDialog(frame,
	                  "Checkout date earlier than checkin date. Please try again", "MaGeC Hotel Message",
	                  JOptionPane.WARNING_MESSAGE); 
	      }
		 
	 }
	
	
	 
	 Date departureDateChooser;
	 Date arrivalDateChooser;
}

