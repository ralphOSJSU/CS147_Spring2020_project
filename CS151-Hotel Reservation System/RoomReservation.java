import java.util.Date;

//this is the class where a user can extract rooms from their reservations
public class RoomReservation {
	private FormEvent userForm;
	private Room room;
	/**
	 * constructor for initializing form event and room
	 * @param userForm
	 * @param room
	 */
	public RoomReservation(FormEvent userForm, Room room) {
		this.userForm = userForm;
		this.room = room;
		
	}
	/**
	 * get the arrival time from form event
	 * @return arrival time as date type
	 */
	public Date getArrivalTime() {
		return userForm.getCheckIn();
	}
	/**
	 * get the departure time from form event
	 * @return departure time as date type
	 */
	public Date getDepartureTime() {
		return userForm.getCheckOut();
	}
	/**
	 * get smoking type room from form event
	 * @return smoking/nonsmoking type of room from form panel
	 */
	public String getSmokingNonSmoking() {
		return userForm.getSmokeTypeOfRooms();
	}
	/**
	 * get the number of adults
	 * @return the number of adults from form panel
	 */
	public String getAdultNum() {
		return userForm.getNumberOfAdults();
	}
	/**
	 * get the number of children
	 * @return the number of children from form panel
	 */
	public String getChildrenNum() {
		return userForm.getNumberOfChildren();
	}
	/**
	 * get the price of rooms
	 * @return the cost of rooms
	 */
	public int getPrice() {
		return room.getCost();
	}
	/**
	 * get the number of rooms
	 * @return the number of rooms
	 */
	public int getRoomNumber() {
		return room.getRoomNum();
	}
	/**
	 * get the type of rooms
	 * @return the type of rooms
	 */
	public String getRoomType() {
		return room.getType();
	}
	/**
	 * display all the properties of rooms as string 
	 */
	
	public String toString()
	 {
		StringBuilder sb = new StringBuilder();
	    sb.append("-");
	    sb.append("Room #" + "");
	    sb.append(getRoomNumber() + ",").append(System.getProperty("line.separator")); 
	    sb.append("Price:" +" " + "$");
	    sb.append(getPrice() + " ,").append(System.getProperty("line.separator")); 
	    sb.append("Type of room: " + " "); 
	    sb.append(getRoomType() + ",").append(System.getProperty("line.separator")); 
	    sb.append("Smoking/Nonsmoking: " + " "); 
	    sb.append(getSmokingNonSmoking()+ ", ").append(System.getProperty("line.separator"));
	    sb.append("Checkin: " + " ");
	    sb.append(getArrivalTime() + ", ").append(System.getProperty("line.separator"));
	    sb.append("Checkout: "+ " ");
	    sb.append(getDepartureTime() + ", ").append(System.getProperty("line.separator"));
	    sb.append("Number of adults: " + " ");
	    sb.append(getAdultNum() + ", ").append(System.getProperty("line.separator"));
	    sb.append("Number of children: " + " ");
	    sb.append(getChildrenNum()).append(System.getProperty("line.separator"));

	    return sb.toString();
	    
	   
	 }

}
