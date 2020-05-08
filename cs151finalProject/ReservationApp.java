import javax.swing.JFrame;
	import javax.swing.SwingUtilities;

public class ReservationApp {
		public static void main(String[] args) {
			//run swing app in a special thread
			//more robust swing app that runs in an approved manner
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new MainFrame();//can run the main frame directly
					
				}
				
			});
			
			
		}

	}


