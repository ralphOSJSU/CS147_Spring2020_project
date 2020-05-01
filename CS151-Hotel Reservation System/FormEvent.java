import java.util.Date;
import java.util.EventObject;
	
	//this is where an event of each command on a form panel is performed for users
	public class FormEvent extends EventObject{
		private Date checkIn;
		private Date checkOut;
		private String roomType;
		private String smokeTypeOfRooms;
		private String numberOfAdults;
		private String numberOfChildren;
		/**
		 * Constructor: get the source of event that is created 
		 * @param source
		 */
		public FormEvent(Object source) {
			super(source);
		}
		/**
		 * Initialize constructor
		 * @param source
		 * @param checkIn
		 * @param checkOut
		 * @param roomType
		 * @param smokeTypeOfRooms
		 * @param numberOfAdults
		 * @param numberOfChildren
		 */
		public FormEvent(Object source, Date checkIn , Date checkOut, String roomType,String smokeTypeOfRooms, String numberOfAdults, String numberOfChildren) {
			super(source);
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			this.roomType = roomType;
			this.smokeTypeOfRooms = smokeTypeOfRooms;
			this.numberOfAdults = numberOfAdults;
			this.numberOfChildren = numberOfChildren;
			
		}
		/**
		 * get check in date
		 * @return date of check in
		 */
		public Date getCheckIn() {
			return checkIn;
		}
		/**
		 * set the check in date
		 * @param checkIn
		 */
		public void setCheckIn(Date checkIn) {
			this.checkIn = checkIn;
		}
		/**
		 * get check out date
		 * @return date of check out
		 */
		public Date getCheckOut() {
			return checkOut;
		}
		/**
		 * set check out date
		 * @param checkOut
		 */
		public void setCheckOut(Date checkOut) {
			this.checkOut = checkOut;
		}
		/**
		 * get type of room
		 * @return type of room as a string
		 */
		public String getRoomType() {
			return roomType;
		}
		/**
		 * set type of room
		 * @param roomType
		 */
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
		/**
		 * get smoking type of room
		 * @return smoking type of room as string type
		 */
		public String getSmokeTypeOfRooms() {
			return smokeTypeOfRooms;
		}
		/**
		 * set smoking type of room
		 * @param smokeTypeOfRooms
		 */
		public void setSmokeTypeOfRooms(String smokeTypeOfRooms) {
			this.smokeTypeOfRooms = smokeTypeOfRooms;
		}
		/**
		 * get the number of adults
		 * @return number of adults as a string
		 */
		public String getNumberOfAdults() {
			return numberOfAdults;
		}
		/**
		 * set the number of adults
		 * @param numberOfAdults
		 */
		public void setNumberOfAdults(String numberOfAdults) {
			this.numberOfAdults = numberOfAdults;
		}
		/**
		 * get the number of children
		 * @return number of children as string
		 */
		public String getNumberOfChildren() {
			return numberOfChildren;
		}
		/**
		 * set the number of children
		 * @param numberOfChildren
		 */
		public void setNumberOfChildren(String numberOfChildren) {
			this.numberOfChildren = numberOfChildren;
		}
		
	}


