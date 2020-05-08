import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;			
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class RoomSelectionFrame {//implements ListSelectionListener 
					   					
	private Hotel hotel;
	final JList<Room> jlist = new JList<Room>();				
	private JPanel roomSelectionPanel;
	private JPanel selectedDetailsPanel;
	private JTextArea selectedDetailsText;
	private JTextPane textPanel;				
	private JButton doneBtn;
	
	private JRadioButton standardRoom = new JRadioButton("Standard");
	private JRadioButton deluxeRoom = new JRadioButton("Deluxe");
	private JRadioButton superiorRoom = new JRadioButton("Superior");
	private JRadioButton familyRoom = new JRadioButton("Family");
	private JRadioButton suiteRoom = new JRadioButton("Suite");
	private Room room;

	private JPanel listPanel;
	private JPanel roomListPanel;
	
	private JPanel standardList;
	private JPanel deluxeList;
	private JPanel superiorList;
	private JPanel familyList;
	private JPanel suiteList;
	private String standardR = "Standard";
	private String deluxeR = "Deluxe";
	private String familyR = "Family";
	private String superiorR = "Superior";
	private String suiteR = "Suite";
	private FormEvent ev = new FormEvent(this);
	private JFrame frame;
	private JPanel buttonPanel;
	private JButton submitBtn;
	/**
	 * constructor for displaying the list of rooms in a hotel
	 * @param e
	 * @param h
	 */
	public RoomSelectionFrame(FormEvent e, Hotel h) {
		hotel = h;
		ev = e;
		
		frame = new JFrame();//main frame created
		frame.setTitle("Room Selection Frame");
		
		listPanel = new JPanel();//panel for listing rooms
		listPanel.setBackground(Color.WHITE);				
		listPanel.setSize(new Dimension(200, 200));
		
		submitBtn = new JButton("Submit Confirmation");//submit button
		submitBtn.setActionCommand("Submit Confirmation");
		buttonPanel = new JPanel();//panel for submission button
		buttonPanel.add(submitBtn);
		doneBtn = new JButton("Done");//done button
		buttonPanel.add(doneBtn);

		JLabel title = new JLabel("ROOM SELECTION");
		title.setHorizontalAlignment(JLabel.CENTER);
		JPanel titlePanel = new JPanel();
		titlePanel.add(title);

		//radio buttons for room types
		final JRadioButton[] roomTypeCollection = new JRadioButton[5];
		roomTypeCollection[0] = standardRoom;
		roomTypeCollection[1] = deluxeRoom;
		roomTypeCollection[2] = superiorRoom;
		roomTypeCollection[3] = familyRoom;
		roomTypeCollection[4] = suiteRoom;
		
		//add radio buttons into a group to select item one at a time
		ButtonGroup roomGroup = new ButtonGroup();
		roomGroup.add(standardRoom);
		roomGroup.add(deluxeRoom);
		roomGroup.add(superiorRoom);
		roomGroup.add(familyRoom);
		roomGroup.add(suiteRoom);

		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(new GridLayout(1, 5));
		roomPanel.add(standardRoom);
		roomPanel.add(deluxeRoom);
		roomPanel.add(superiorRoom);
		roomPanel.add(familyRoom);
		roomPanel.add(suiteRoom);
		JPanel typeRoomPanel = new JPanel();
		typeRoomPanel.add(roomPanel);

		roomSelectionPanel = new JPanel();
		roomSelectionPanel.setLayout(new BorderLayout(0, 0));
		roomSelectionPanel.add(titlePanel, BorderLayout.NORTH);
		roomSelectionPanel.add(typeRoomPanel, BorderLayout.SOUTH);
		
		textPanel = new JTextPane();//Text Pane for selected detatils from form panel
		textPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		selectedDetailsPanel = new JPanel();
		selectedDetailsPanel.setLayout(new BorderLayout(0, 0));
		selectedDetailsPanel.add(textPanel, BorderLayout.CENTER);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String arrivalTime = dateFormat.format(e.getCheckIn());
		String departureTime = dateFormat.format(e.getCheckOut());
		String typeRoom = e.getRoomType();
		String smokeRoom = e.getSmokeTypeOfRooms();
		String numAdults = e.getNumberOfAdults();
		String numChildren = e.getNumberOfChildren();

		textPanel.setEditable(false);
		//display all selected information from form panel
		textPanel.setText("SELECTED DETAILS: " + "\n" + "\n" + "Arrival Time: " + arrivalTime + "," + " "
						 + "Departure Time: " + departureTime + "\n" + "Type of room booked: " + typeRoom + "\n"
				    		 + "Smoking/Nonsmoking: " + smokeRoom + "\n" + "Number of Adults: " + numAdults + "\n"
						 + "Number of Children: " + numChildren);
		
		//if 'standard' room is chosen on the form panel, 
		//'standard' room button is selected and disable all room types radio buttons
		if (typeRoom.equals("Standard")) {
			standardRoom.setSelected(true);
			for (JRadioButton b : roomTypeCollection) {
				if (b == standardRoom) {
					b.setEnabled(true);
				} else {
					b.setEnabled(false);
				}
			}
			standardRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jlist.setEnabled(standardRoom.isSelected());//enable the list from 'Standard'					
				}
			});
		} 
		//if 'Deluxe' room is chosen on the form panel, 
		//'Deluxe' room button is selected and disable all room types radio buttons
		else if (typeRoom.equals("Deluxe")) {
			deluxeRoom.setSelected(true);
			for (JRadioButton b : roomTypeCollection) {
				if (b == deluxeRoom) {
					b.setEnabled(true);
				} else {
					b.setEnabled(false);
				}
			}
			deluxeRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jlist.setEnabled(deluxeRoom.isSelected());//enable the list from 'Deluxe'		
			}
			});
		} 
		//if 'Superior' room is chosen on the form panel, 
		//'Superior' room button is selected and disable all room types radio buttons
		else if (typeRoom.equals("Superior")) {
			superiorRoom.setSelected(true);
			for (JRadioButton b : roomTypeCollection) {
				if (b == superiorRoom) {
					b.setEnabled(true);
				} else {
					b.setEnabled(false);
				}
			}
			superiorRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jlist.setEnabled(superiorRoom.isSelected());//enable the list from 'Superior'		
			}
			});
		} 
		//if 'Family' room is chosen on the form panel, 
		//'Family' room button is selected and disable all room types radio buttons
		else if (typeRoom.equals("Family")) {
			familyRoom.setSelected(true);
			for (JRadioButton b : roomTypeCollection) {
				if (b == familyRoom) {
					b.setEnabled(true);
				} else {
					b.setEnabled(false);
				}
			}						
		 familyRoom.addItemListener(new ItemListener() {
		 public void itemStateChanged(ItemEvent e) {
			 jlist.setEnabled(familyRoom.isSelected());//enable the list from 'family'
		 }
		 });
		} 
		//if 'suite' room is chosen on the form panel, 
		//'suite' room button is selected and disable all room types radio buttons
		else {
			suiteRoom.setSelected(true);
			for (JRadioButton b : roomTypeCollection) {
				if (b == suiteRoom) {
					b.setEnabled(true);
				} else {
					b.setEnabled(false);
				}
			}
			suiteRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jlist.setEnabled(suiteRoom.isSelected());//enable the list from 'suite'
			}
			});
		}
		//add listener to all room types
		standardRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				RoomsSelectionList();
			}
		});

						
		deluxeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RoomsSelectionList();
			}
		});

		superiorRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RoomsSelectionList();
			}
		});

		familyRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RoomsSelectionList();
			}
		});

		suiteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RoomsSelectionList();
			}
	    });

		listPanel.setLayout(new BorderLayout());//set up list panel for the list of rooms
		//add listener to hotel object
	    hotel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

			DefaultListModel<Room> model = new DefaultListModel<Room>();
			ArrayList<Room> rooms = hotel.getVacantRooms();//get all the list of rooms as an ArrayList
			for (Room r : rooms) {
				model.addElement(r);//add all room objects as model elements
			}
			jlist.setModel(model);//add all model elements into jlist
			jlist.setSelectedIndex(0);
			}
		});
	    
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//set the jlist items to be selected one at a time	
		
		listPanel.add(jlist, BorderLayout.CENTER);//add jlist into the panel
		//if any of the room type is selected in the form panel, make the button to display the list automatically
		if (typeRoom.equals("Standard")) {
			standardRoom.doClick();
		} else if (typeRoom.equals("Deluxe")) {
		    deluxeRoom.doClick();
		} else if (typeRoom.equals("Superior")) {
			superiorRoom.doClick();
		} else if (typeRoom.equals("Family")) {
			familyRoom.doClick();
		} else {
			suiteRoom.doClick();
		}
		//add listener to 'done' button			
		doneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new InvoiceFrame(e, hotel);//connect this button to the invoice frame
				frame.dispose();
			}
		});
		doneBtn.setEnabled(false);//disable the 'done' when users have not selected
	
		submitBtn.addActionListener(ButtonListener(e));//add listener to a submit button				
		
		frame.add(roomSelectionPanel, BorderLayout.NORTH);
		frame.add(selectedDetailsPanel, BorderLayout.EAST);
		frame.add(listPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setMinimumSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
		//displaying the list of rooms from a hotel class for each type
		private void RoomsSelectionList() {
						
			if (standardRoom.isSelected())
				hotel.vacantTypeRooms(standardR);
			else if (deluxeRoom.isSelected())
				hotel.vacantTypeRooms(deluxeR);
			else if (superiorRoom.isSelected())
				hotel.vacantTypeRooms(superiorR);
			else if (familyRoom.isSelected())
				hotel.vacantTypeRooms(familyR);
			else if (suiteRoom.isSelected())
				hotel.vacantTypeRooms(suiteR);
		}
		//add more rooms into a reservations
		private void addReservation(FormEvent e) {

			Room room = jlist.getSelectedValue();//obtain the selected item
			RoomReservation r = new RoomReservation(e, room);
			//totalRoomCost += room.getCost();
			room.addReservation(r);//add selected rooms into a reservation
			JOptionPane.showConfirmDialog(frame, "Make more reservations?", "KSR Hotel Message",
					                      JOptionPane.OK_CANCEL_OPTION);//popped up message if user wants to add more rooms

		}

		public ActionListener ButtonListener(FormEvent e) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//convert models from jlist into DefaultListModel Object type			
				DefaultListModel<Room> modelD = (DefaultListModel<Room>) jlist.getModel();
				addReservation(e);
				
				int index = jlist.getSelectedIndex();
				modelD.remove(index);//remove the selected index
				int size = modelD.getSize();

				if (size == 0) {
					submitBtn.setEnabled(false);//disable the submit button if there is zero size of items
				} else {
					if (index == modelD.getSize()) {
						index--;//decrease index of items		
					}
					jlist.setSelectedIndex(index);
					doneBtn.setEnabled(true);//if size>0, enable 'done' button
				}
			}
		};

		}

	}
