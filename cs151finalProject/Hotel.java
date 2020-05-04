import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Hotel {
	private ArrayList<Room> roomsList;
	private ArrayList<ChangeListener> listeners;
	//private ArrayList<Room> availableRooms;
	private final static int STANDARD_COST = 85;
	private final static int DELUXE_COST = 95;
	private final static int SUPERIOR_COST = 110;
	private final static int FAMILY_COST = 125;
	private final static int SUITE_COST = 140;

	public Hotel() {
		roomsList = new ArrayList<Room>();
		listeners = new ArrayList<ChangeListener>();
		for (int i = 100; i <111; i++) { // standard room
			roomsList.add(new Room(i, STANDARD_COST));
		}
		for (int i = 200; i < 211; i++) { // delux room
			roomsList.add(new Room(i, DELUXE_COST));
		}
		for (int i = 300; i < 311; i++) { // delux room
			roomsList.add(new Room(i, SUPERIOR_COST));
		}
		for (int i = 400; i < 411; i++) { // delux room
			roomsList.add(new Room(i, FAMILY_COST));
		}
		for (int i = 500; i < 511; i++) { // delux room
			roomsList.add(new Room(i, SUITE_COST));
		}
	}
	
	/**
	public void addRooms(Room room) {
		rooms.add(room);
	}**/
	
	public void attach(ChangeListener listener)
	   {
	      listeners.add(listener);
	   }
	 public Iterator<Room> roomIterator()
	   {
	      return roomsList.iterator();
	   }
	
	public ArrayList<Room> getRooms()
	   {
	      return roomsList;
	   }
	public Iterator<Room> listAllRooms() {
		return new
		         Iterator<Room>()
		         {
		            public boolean hasNext()
		            {
		               return current < roomsList.size();
		            }

		            public Room next()
		            {
		               return roomsList.get(current++);
		            }

		            public void remove()
		            {
		               throw new UnsupportedOperationException();
		            }

		            private int current = 0;
		         };
	}
	
	 /**
	public void addRooms() {

		Iterator<Room> iter = roomIterator();
		//availableRooms = new ArrayList<>();
		while(iter.hasNext())
	      {
	         Room r = iter.next();
	         if(r.getCost() == STANDARD_COST) {
	            roomTypes.add(r);
	         }
	         else if (r.getCost() == DELUX_COST) {
	        	 roomTypes.add(r);
	         }
	      }
		ChangeEvent e = new ChangeEvent(this);
	      for(ChangeListener c : listeners)
	      {
	         c.stateChanged(e);
	      }
		
	}**/
	/**
	
	public ArrayList<Room> getRoomTypes() {
		return roomTypes;
	}**/
	
	
	
	
}
