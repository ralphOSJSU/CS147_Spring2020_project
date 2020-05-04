import java.util.EventObject;

	public class FormEvent extends EventObject{//relays to the main frame and store info temporarily
		private String checkIn;
		private String checkOut;
		private String numberOfRooms;
		private String typeOfRooms;
		private String numberOfAdults;
		private String numberOfChildren;
		
		public FormEvent(Object source) {
			super(source);
		}
		
		public FormEvent(Object source, String checkIn , String checkOut, String numberOfRooms,String typeOfRooms, String numberOfAdults, String numberOfChildren) {
			super(source);
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			this.numberOfRooms = numberOfRooms;
			this.typeOfRooms = typeOfRooms;
			this.numberOfAdults = numberOfAdults;
			this.numberOfChildren = numberOfChildren;
			
		}

		public String getCheckIn() {
			return checkIn;
		}

		public void setCheckIn(String checkIn) {
			this.checkIn = checkIn;
		}

		public String getCheckOut() {
			return checkOut;
		}

		public void setCheckOut(String checkOut) {
			this.checkOut = checkOut;
		}

		public String getNumberOfRooms() {
			return numberOfRooms;
		}

		public void setNumberOfRooms(String numberOfRooms) {
			this.numberOfRooms = numberOfRooms;
		}

		public String getTypeOfRooms() {
			return typeOfRooms;
		}

		public void setTypeOfRooms(String typeOfRooms) {
			this.typeOfRooms = typeOfRooms;
		}

		public String getNumberOfAdults() {
			return numberOfAdults;
		}

		public void setNumberOfAdults(String numberOfAdults) {
			this.numberOfAdults = numberOfAdults;
		}

		public String getNumberOfChildren() {
			return numberOfChildren;
		}

		public void setNumberOfChildren(String numberOfChildren) {
			this.numberOfChildren = numberOfChildren;
		}
		
	}


