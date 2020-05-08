
public class Room {
	
	private int roomNum;
	private int cost;
	private RoomReservations reservations;
	
	public Room(int roomNum, int cost) {
		this.roomNum = roomNum;
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void addReservation(RoomReservation r)
	   {
	      reservations.add(r);
	   }
	public void cancelReservation(RoomReservation r)
	   {
	      reservations.cancel(r);
	   }
	public String toString()
	   {
	      return "Room Number: #" + roomNum + " , Price = $" + getCost();
	   }
	
	

}
