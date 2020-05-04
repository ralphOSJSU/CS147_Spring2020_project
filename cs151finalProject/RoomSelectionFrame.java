
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

	public class RoomSelectionFrame extends JFrame{
		int countRoomSelection = 0;

		private Hotel hotel;
		
		//private final static int STANDARD_COST = 60;
		//private final static int DELUX_COST = 80;
		final JList<Room> jlist = new JList<Room>();
		
		private JPanel roomSelectionPanel;
		private JPanel selectedDetailsPanel;
		private JTextArea selectedDetailsText;
		
		private JTextPane textPanel;
		
		
		
		private JCheckBox standardRoom;
		private JCheckBox deluxeRoom;
		private JCheckBox superiorRoom;
		private JCheckBox familyRoom;
		private JCheckBox suiteRoom;
		private Room room;
		
		private CardLayout roomListLayout;
		private JPanel cardPanel;
		private JPanel standardList;
		private JPanel deluxeList;
		private JPanel superiorList;
		private JPanel familyList;
		private JPanel suiteList;
		
		private int currentCard = 1;

		public RoomSelectionFrame(FormEvent e) {
			
			
			setTitle("Room Selections Frame");
			roomListLayout = new CardLayout();
			cardPanel = new JPanel();
			cardPanel.setLayout(roomListLayout);
			cardPanel.setSize(300, 300);
			
		    standardList = new JPanel();
		    deluxeList = new JPanel();
		    superiorList = new JPanel();
		    familyList = new JPanel();
		    	suiteList = new JPanel();

			JPanel[] roomArray = new JPanel[5];
			roomArray[0] = standardList;
			roomArray[1] = deluxeList;
			roomArray[2] = superiorList;
			roomArray[3] = familyList;
			roomArray[4] = suiteList;
			JTextPane standardDes = new JTextPane();
			JTextPane deluxeDes = new JTextPane();  
			JTextPane superiorDes = new JTextPane();
			JTextPane familyDes = new JTextPane();
			JTextPane suiteDes = new JTextPane();
			
			JTextPane[] textArray = new JTextPane[5];
			
			textArray[0] =  standardDes;
			textArray[0].setText("Description: A more affordable option, less space."+"\n"
			+ "1 KING BED OR 2 SINGLE BEDS" + "\n" + "Price: $85");
			
			textArray[1] = deluxeDes;
			textArray[1].setText("Description: Our most popular room, with basic facilities"+"\n"
					+"1 KING BED OR 2 SINGLE BEDS" + "\n"+ "Price: $95");
			
			textArray[2] = superiorDes;
			textArray[2].setText("Description: More Space, and equipped with a couch "+"\n"
			+ "1 KING BED OR 2 SINGLE BEDS" + "\n" + "Price: $110" );
			
			textArray[3] = familyDes;
			textArray[3].setText("Description: Even more space, with an extra bed. Ideal for small families  "+"\n"
				    + "1 KING BED AND 1 SINGLE BEDS" + "\n" + "Price: $125");
			
			textArray[4] = suiteDes; 
			textArray[4].setText("Description: Our largest room, consisting of two bedrooms, an ensuite with bath tub,"
					+ "an extra washroom, a living area, a bar table and a microwave oven "+"\n"
					+ "1 KING BED AND 1 SINGLE BEDS" + "\n" + "Price: $140");
			
			
			for(int i= 0; i<roomArray.length; i++) {
				roomArray[i].setBackground(Color.WHITE);
			}
			
			SimpleAttributeSet styleCon = new SimpleAttributeSet();
		    StyleConstants.setAlignment(styleCon, StyleConstants.ALIGN_CENTER);
			for(int i= 0; i<textArray.length; i++) {
				textArray[i].setEditable(false);
				textArray[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
				StyledDocument style = textArray[i].getStyledDocument();
				style.setParagraphAttributes(0,style.getLength(), styleCon,false);
				roomArray[i].setLayout(new BorderLayout());
				roomArray[i].add(textArray[i], BorderLayout.NORTH);
				
			}
			
			/**
			Border lineBorderStandard = BorderFactory.createLineBorder(Color.GRAY);
		    standardDes.setBorder(lineBorderStandard);
			standardDes.setEditable(false);
		    SimpleAttributeSet center = new SimpleAttributeSet();
		    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		    styleStandardes.setParagraphAttributes(0, styleStandardes.getLength(), center, false);**/
 	
			//standardDes.setLineWrap(true);
		    //standardDes.setWrapStyleWord(true);
		    //standardDes.setOpaque(false);
						
			JButton submitBtn = new JButton("Submit Confirmation");
			//JButton next = new JButton("Next");
			
			
			//JPanel buttonPanel = new JPanel();
			//buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			//buttonPanel.add(prev);//***
			//buttonPanel.add(next);//***
			//cardPanel.setSize(50, 50);	
			//roomArray[0].add(next,BorderLayout.SOUTH);
			//next.setSize(2, 2);;
			//roomArray[1].add(BorderLayout.SOUTH);
			//roomArray[2].add(next, BorderLayout.SOUTH);
			//roomArray[3].add(buttonPanel, BorderLayout.SOUTH);
			//roomArray[3].add(buttonPanel,BorderLayout.SOUTH );
			//roomArray[4].add(prev,BorderLayout.SOUTH);
			
			
			cardPanel.add(roomArray[0], "1");
			cardPanel.add(roomArray[1], "2");
			cardPanel.add(roomArray[2], "3");
			cardPanel.add(roomArray[3], "4");
			cardPanel.add(roomArray[4], "5");
			
			roomListLayout.show(cardPanel, "1");
					
			final JTextArea textArea = new JTextArea(10, 10); // formatted 
			
			JLabel title = new JLabel("ROOM SELECTION");
		    title.setHorizontalAlignment(JLabel.CENTER);

			standardRoom = new JCheckBox("Standard");
			deluxeRoom = new JCheckBox("Deluxe");
			superiorRoom = new JCheckBox ("Superior");
			familyRoom = new JCheckBox("Family");
			suiteRoom = new JCheckBox ("Suite");
			standardRoom.setSelected(true);
			
			final JCheckBox[] roomTypeCollection = new JCheckBox[5];
			roomTypeCollection[0] = standardRoom;
			roomTypeCollection[1] = deluxeRoom;
			roomTypeCollection[2] = superiorRoom;
			roomTypeCollection[3] = familyRoom;
			roomTypeCollection[4] = suiteRoom;
			
			JPanel titlePanel = new JPanel();
			titlePanel.add(title);
			
			JPanel roomPanel = new JPanel();
			roomPanel.setLayout(new GridLayout(1,5));
			roomPanel.add(standardRoom);
			roomPanel.add(deluxeRoom);
			roomPanel.add(superiorRoom);
			roomPanel.add(familyRoom);
			roomPanel.add(suiteRoom);
			JPanel typeRoomPanel = new JPanel();
			typeRoomPanel.add(roomPanel);
			
			roomSelectionPanel = new JPanel();	
		    roomSelectionPanel.setLayout(new BorderLayout(0,0));
			roomSelectionPanel.add(titlePanel, BorderLayout.NORTH);
			roomSelectionPanel.add(typeRoomPanel,  BorderLayout.SOUTH);
			
			ActionListener actListener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent actLis) {
					AbstractButton absB = (AbstractButton) actLis.getSource();
					for(int i = 0; i<roomTypeCollection.length; i++ ) {
						if(roomTypeCollection[i].isSelected()) {
							countRoomSelection++;
						}
					}
					if(absB.isSelected() && absB == roomTypeCollection[0]) {
						roomListLayout.first(cardPanel);
					}
					if(absB.isSelected() && absB == roomTypeCollection[1]) {
						roomListLayout.show(cardPanel, "2");
					}
					if(absB.isSelected() && absB == roomTypeCollection[2]) {
						roomListLayout.show(cardPanel, "3");
					}
					if(absB.isSelected() && absB == roomTypeCollection[3]) {
						roomListLayout.show(cardPanel, "4");
					}
					if(absB.isSelected() && absB == roomTypeCollection[4]) {
						roomListLayout.show(cardPanel, "5");
					}

				}
				
			};
			for(JCheckBox rCollect: roomTypeCollection) {
				rCollect.addActionListener(actListener);
			}
			
			
			textPanel = new JTextPane();
			textPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			//JLabel selectedDetailsLabel = new JLabel("SELECTED DETAILS:");
			
			//selectedDetailsText = new JTextArea(40,40);	
			selectedDetailsPanel = new JPanel();
			//selectedDetailsPanel.setSize(10, 10);
			selectedDetailsPanel.setLayout(new BorderLayout(0,0));
			//selectedDetailsPanel.add(selectedDetailsLabel,BorderLayout.NORTH);
			selectedDetailsPanel.add(textPanel,BorderLayout.CENTER);
			
					String arrivalTime = e.getCheckIn();
					String departureTime = e.getCheckOut();
					String numRoom = e.getNumberOfRooms();
					String typeRoom = e. getTypeOfRooms();
					String numAdults = e.getNumberOfAdults();
					String numChildren = e.getNumberOfChildren();
					
					textPanel.setEditable(false);
					textPanel.setText("SELECTED DETAILS: "+ "\n"+ "\n"+"Arrival Time: " + arrivalTime + "," + " " + "Departure Time: "+ departureTime + "\n"
					+ "Number of Rooms Booked: "+ numRoom + "\n" + "Type of Rooms: "+ typeRoom + "\n" + "Number of Adults: " + numAdults 
					+ "\n" + "Number of Children: "+ numChildren);
					
			
			add(roomSelectionPanel, BorderLayout.NORTH);
			add(selectedDetailsPanel, BorderLayout.EAST);
			add(cardPanel,BorderLayout.CENTER);
			add(submitBtn,BorderLayout.SOUTH);
			/**
			 hotel.attach(new ChangeListener(){
		         public void stateChanged(ChangeEvent e){
		            
		            DefaultListModel<Room> model = new DefaultListModel<Room>();
		            ArrayList<Room> rooms;
		            if(isValidDate()){
		                rooms = hotel.getAvailableRooms();
		                for(Room r : rooms)
		                {model.addElement(r);}
		            }
		            
		            //notify method
		            jlist.setModel(model);
		            if(model.size() > 0)jlist.setSelectedIndex(0);
		         }
		      });**/
			
			/**
			standardRoom.addActionListener(new ActionListener()
		      {
		         public void actionPerformed(ActionEvent e)
		         {
		            changeRooms();
		         }
		      });
			
			deluxRoom.addActionListener(new ActionListener()
		      {
		         public void actionPerformed(ActionEvent e)
		         {
		            changeRooms();
		         }
		      });
			//list of rooms
			/**
			JPanel viewPanel = new JPanel();
			viewPanel.setLayout(new BorderLayout());
			hotel.attach(new ChangeListener(){
		         public void stateChanged(ChangeEvent e){
		            
		            DefaultListModel<Room> model = new DefaultListModel<Room>();
		            ArrayList<Room> rooms;
		            
		                rooms = hotel.getRoomTypes();
		                for(Room r : rooms)
		                {model.addElement(r);}
		            
		            
		            //notify method
		            jlist.setModel(model);
		            if(model.size() > 0)jlist.setSelectedIndex(0);
		         }
		      });
			
			**/

		     // viewPanel.add(jlist);
		      
		     // viewPanel.setBackground(Color.WHITE);

			//add(new JScrollPane(textArea), BorderLayout.CENTER);
			
			
			setMinimumSize(new Dimension(600, 600));

			//setPreferredSize(new Dimension(400, 600));
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    pack();
		    setVisible(true);
		}
		
		
		/**
		public void changeRooms() {
			if (standardRoom.isSelected()) {
				hotel.changeRoomType(STANDARD_COST);
			}
			else if (deluxRoom.isSelected()) {
				hotel.changeRoomType(DELUX_COST);
			}
		}
**/
	}
	
