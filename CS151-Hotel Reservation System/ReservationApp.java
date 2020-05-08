import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ReservationApp {
		public static void main(String[] args) {
			//This is the tester of the application
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					
					Hotel h =new  Hotel();//create a hotel object
					new MainFrame(h);//the main tester for run
					
				}
				
			});
			
			
		}

	}


