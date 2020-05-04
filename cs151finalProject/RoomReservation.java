
public class RoomReservation {
	private FormEvent userForm;
	private Room room;
	
	public RoomReservation(FormEvent userForm, Room room) {
		this.userForm = userForm;
		this.room = room;
		
	}
	
	public String getArrivalTime() {
		return userForm.getCheckIn();
	}
	public String getDepartureTime() {
		return userForm.getCheckOut();
	}
	public int getPrice() {
		return room.getCost();
	}
	public int getRoomNumber() {
		return room.getRoomNum();
	}
	
	public String toString()
	 {

	    return "Room #" + room.getRoomNum() + "Price: " + room.getCost()+" checkin: " + userForm.getCheckIn() + " checkout: " + userForm.getCheckOut();
	 }

}
