public class Room  {
	
	private int roomNum;
	private int cost;
	private RoomReservations reservations;
	private String roomType;
	
	/**
	 * constructor that initializes properties of a room
	 * @param roomNum
	 * @param cost
	 * @param roomType
	 * @param reservations
	 */
	public Room(int roomNum, int cost, String roomType, RoomReservations reservations) {
		this.roomNum = roomNum;
		this.cost = cost;
		this.reservations = reservations;
		this.roomType = roomType;
	}
	/**
	 * get the cost of a room
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * get the room number
	 * @return the room number
	 */
	public int getRoomNum() {
		return roomNum;
	}
	/**
	 * get the type of room
	 * @return the type of room
	 */
	public String getType() {
		return roomType;
	}
	/**
	 * compare the type of room
	 * @param type
	 * @return true/false if the type room matches
	 */
	public boolean isType(String type)
	   {
	      return roomType.equals(type);
	   }
	/**
	 * get reservations that have been made 
	 * @return reservations object
	 */
	 public RoomReservations getReservations()
	   {
	      return reservations;
	   }
	 /**
	  * add rooms into a reservation
	  * @param r
	  */
	public void addReservation(RoomReservation r)
	   {
	      reservations.add(r);
	   }
	/**
	 * cancel the rooms in a reservation
	 * @param r
	 */
	public void ReservationCancelation(RoomReservation r)
	   {
	      reservations.cancelation(r);
	   }
	/**
	 * displays the attributes of a room
	 */
	public String toString()
	   {
	      return "Room Number: #" + getRoomNum()+ " ," + "Room Type: " + getType() +
	    		  "," + "Price = $" + getCost();
	   }
	
	

}
