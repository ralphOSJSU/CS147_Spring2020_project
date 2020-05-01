import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

//this is a class where the invoice get formatted into html sytle
public class HtmlFormatterReceipt implements InvoiceFormatter{
	private int total;
	private Hotel hotel;
	private FormEvent e;
	public static int NUM_DAYS = 24;
	public static int HOURS = 60;
	 	/**
	 	 * constructor for initializing hotel and the events that occur on the form
	 	 * @param h
	 	 * @param ev
	 	 */
	   public HtmlFormatterReceipt(Hotel h, FormEvent ev)
	   {
		   hotel = h;
		   e = ev; 
	   }
	   /**
	    * @return the current date of invoice created 
	    */
	   public String formatDate() {
			DateFormat dateF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String d = "Date:" + " " + dateF.format(date);

			return d;
		}
	   /**
	    * @return the html style of invoice's header
	    */
		public String formatHeader() {
			total = 0;
			return "<html><b><h1><font color=\"#800000\"><center><p style=\"border:3px; border-style:solid; "
					+ "border-color:#ffd1dc; padding: 1em;\">RECEIPT</p></center></font></h1></b><br>";
		}
		/**
		 * @return the formatted rooms in a reservation that are booked 
		 */
		public String formatBooking() {
			String receipt = "";
			Iterator<Room> iter = hotel.roomIterator();

			while (iter.hasNext()) {
				Room r = iter.next();
				RoomReservations rs = r.getReservations();
				Iterator<RoomReservation> itera = rs.getReservations();
				while (itera.hasNext()) { 
					RoomReservation re = itera.next();//get the booked rooms
					receipt += "Room Number: #" + re.getRoomNumber() + ", " + "Room Type: " + re.getRoomType() + ", "
							+ "Price = $" + re.getPrice() + "<br>";

					receipt += "Check in: " + re.getArrivalTime() + "<br>";
					receipt += "Check out: " + re.getDepartureTime() + "<br>";

					receipt += "Number of adults: " + re.getAdultNum() + ", " + "Number of children: "
							+ re.getChildrenNum();

					receipt += "<br><br>";
					long numDays = (re.getDepartureTime().getTime() - re.getArrivalTime().getTime())
							/ (1000 * HOURS * HOURS * NUM_DAYS);
					total += r.getCost() * numDays;
				}

			}

			DecimalFormat formatter = new DecimalFormat("$0.00");
			String totalPrice = formatter.format(total);
			return receipt += "Total amount due: " + totalPrice;
		}
		/**
		 * @return the formatted footer 
		 */
		public String formatFooter() {
			return "<p><center><font color=\"green\"><b><p style=\"border:3px; border-style:solid; "
					+ "border-color:#98FB98; padding: 1em;\">" + "HAVE A NICE STAY!"
					+ "</p></b></font></center></p></html>";
		}

	
}
