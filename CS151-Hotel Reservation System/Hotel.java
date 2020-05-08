import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//this is a class Hotel that stores all the list of initialized rooms
public class Hotel {
	
	private ArrayList<Room> roomsList;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	private ArrayList<Room> vacantRooms;
	private final static int STANDARD_COST = 85;
	private final static int DELUXE_COST = 95;
	private final static int SUPERIOR_COST = 110;
	private final static int FAMILY_COST = 125;
	private final static int SUITE_COST = 140;
	private  String Standard = "Standard";
	private  String Deluxe = "Deluxe";
	private  String Superior = "Superior";
	private 	 String Family =  "Family";
	private  String Suite = "Suite";

	/**
	 * construct rooms with different types and prices
	 */
	public Hotel() {
		roomsList = new ArrayList<Room>();
		for (int i = 100; i <=110; i++) { // standard room
			roomsList.add(new Room(i, STANDARD_COST, Standard, new RoomReservations()));
		}
		for (int i = 200; i <= 210; i++) { // deluxe room
			roomsList.add(new Room(i, DELUXE_COST, Deluxe, new RoomReservations()));
		}
		for (int i = 300; i <= 310; i++) { // superior room
			roomsList.add(new Room(i, SUPERIOR_COST, Superior, new RoomReservations()));
		}
		for (int i = 400; i <= 410; i++) { // family room
			roomsList.add(new Room(i, FAMILY_COST, Family, new RoomReservations()));
		}
		for (int i = 500; i <= 510; i++) { // suite room
			roomsList.add(new Room(i, SUITE_COST, Suite, new RoomReservations()));
		}
	}
	
	/**
    		Adds a change listener to the hotel.
    		@param listener the change listener to add
	 */
	public void addChangeListener(ChangeListener listener)
	   {
	      listeners.add(listener);
	   }
	/**
	 * iterate through all the list of rooms
	 * @return iteration of all rooms
	 */
	 public Iterator<Room> roomIterator()
	   {
	      return roomsList.iterator();
	   }
	
	/**
	 * show vacancy of chosen type of rooms
	 * @param roomType
	 */
	 public void vacantTypeRooms(String roomType)
	   {
	      Iterator<Room> iter = roomIterator();
	      vacantRooms = new ArrayList<Room>();
	      while(iter.hasNext())
	      {
	         Room room = iter.next();
	         if(room.isType(roomType)) { 
	            vacantRooms.add(room);//add vacant rooms to that type if matches
	         }
	      }
	      ChangeEvent e = new ChangeEvent(this);
	      for(ChangeListener c : listeners)
	      {
	         c.stateChanged(e);
	      }
	   }
	 /**
	  * get the list of vacancies 
	  * @return the vacant rooms
	  */
	 public ArrayList<Room> getVacantRooms()
	   {
	      return vacantRooms;
	   }
	 

	 /**
	  * Cancel rooms that are added into the reservation
	  * @param r
	  */
	public void CancelingReservation(RoomReservation r)
	   {
	      Iterator<Room> iter = roomIterator();
	      while(iter.hasNext())
	      {
	         Room room = iter.next();
	         if(room.getRoomNum() == r.getRoomNumber()) {
	            room.ReservationCancelation(r); 
	            return;
	         }
	      }
	   }
	
	/**
	 * Format the rooms for invoice
	 * @param formatter
	 * @return the formatted strings of booked rooms
	 */
	public String format(InvoiceFormatter formatter)
	   {
			String r = formatter.formatHeader();
			String r1 = formatter.formatDate();
			String r2 = formatter.formatBooking();
			String r3 = formatter.formatFooter();
			return r1 + r + r2 + r3;
		}
	   
	
}

