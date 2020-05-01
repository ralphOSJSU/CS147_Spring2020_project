import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

//this is the class where reservations have been made
public class RoomReservations {

	private ArrayList<RoomReservation> reservationList;
	
	/**
	 * Constructor for initializing array list of room reservations
	 */
	public RoomReservations()
	{
		reservationList = new ArrayList<RoomReservation>();
	}
	/**
	 * cancel the reserved rooms
	 * @param r
	 */
	public void cancelation(RoomReservation r)
	{
	      reservationList.remove(r);

	}
	/**
	 *  add rooms into reservation
	 * @param r
	 */
	public void add(RoomReservation r)
	{
	      reservationList.add(r); 
	}
	
	/**
	 * get iterations of reserved rooms
	 * @return the iteration of rooms in a reservation
	 */
	   public Iterator<RoomReservation> getReservations()
	   {
		   return reservationList.iterator();
	   }
}
