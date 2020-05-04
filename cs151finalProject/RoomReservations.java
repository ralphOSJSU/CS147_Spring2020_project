import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class RoomReservations {

	private ArrayList<RoomReservation> reservationList;

	   public RoomReservations()
	   {
	      reservationList = new ArrayList<RoomReservation>();
	   }
	   public void cancel(RoomReservation r)
	   {

	      reservationList.remove(r);

	   }
	   
	   public void add(RoomReservation r)
	   {
	      reservationList.add(r);

	      // sort the list according to the start dates
	      if(reservationList.size()>1){
	         Collections.sort(reservationList,new Comparator<RoomReservation>(){
	            public int compare(RoomReservation r1, RoomReservation r2)
	            {
	               if(!(r1.getArrivalTime().equals(r2.getArrivalTime())))
	                  return  -1;
	               else
	                  return 1;
	            }});
	      }
	   }

	   public Iterator<RoomReservation> getReservations()
	   {
	      return reservationList.iterator();
	   }
}
