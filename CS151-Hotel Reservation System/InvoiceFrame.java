import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//this is the class where frame of invoice displays the reservations
public class InvoiceFrame extends JFrame{
	
	private JLabel nameLabel;
	private JPanel namePanel;	
	private JPanel btnPanel;
	private JButton viewingCancelingBtn;
	Hotel hotel = new Hotel();
	/**
	 * constructor for displaying invoice 
	 * @param ev
	 * @param h
	 */

	public InvoiceFrame(FormEvent ev, Hotel h) {
			
		setTitle("Invoice Frame");
		namePanel = new JPanel();
		
		btnPanel = new JPanel();//panel for button
		viewingCancelingBtn = new JButton("Viewing/Canceling Your Reservation");
		btnPanel.add(viewingCancelingBtn);
			
		nameLabel = new JLabel("KSR Receipt");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		namePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		namePanel.add(nameLabel);
			
			 
		final JScrollPane text = new JScrollPane();//create JScrollPane for html content
	    final JTextPane html = new JTextPane();
		html.setEditable(false);	
		html.setContentType("text/html");
		text.getViewport().add(html);
		 
		InvoiceFormatter r = new HtmlFormatterReceipt(h,ev);
		html.setText(h.format(r));//add the formatted receipt with html style
		
		//add listener to viewingcanceling button
		viewingCancelingBtn.addActionListener(new ActionListener() {
				@Override
			public void actionPerformed(ActionEvent arg0) {
				new CancelingFrame(h);//connect the button to canceling frame
					
			}	    
		});
		        	        			
	    add(namePanel, BorderLayout.NORTH);
	    add(text, BorderLayout.CENTER);
	    add(btnPanel,BorderLayout.SOUTH);		  
	    setPreferredSize(new Dimension(400,400));
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    pack();
	    setVisible(true); 
		
	}
		
	
}

