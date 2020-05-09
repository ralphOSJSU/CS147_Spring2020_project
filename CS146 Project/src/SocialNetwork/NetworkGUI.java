package SocialNetwork;

import java.awt.BorderLayout;

import javax.swing.*;

public class NetworkGUI extends JFrame
{
	private Network socialNetwork;
	private User defaultUser;
	private final int WINDOW_WIDTH = 500;		// The width of the window.
	private final int WINDOW_HEIGHT = 500;		// The height of the window.
	private JPanel userPanel;					// To hold the user's profile.
	private JPanel networkPanel;				// To hold the network of Users.
	private JPanel searchPanel;					// To hold the search bar.
	
	
	// Constructor
	public NetworkGUI(User defaultUser, Network socialNetwork)
	{
		// Initialize the socialNetwork.
		this.defaultUser = defaultUser;
		this.socialNetwork = socialNetwork;
		
		// Set the title bar text.
		setTitle("The Social Network");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a BorderLayout manager to the content panel.
		setLayout(new BorderLayout());
		
		// Build the JPanels.
		buildUserPanel();
		buildNetworkPanel();
		buildSearchPanel();
		
		// Add the JPanels to the network.
		add(userPanel, BorderLayout.WEST);
		add(networkPanel, BorderLayout.EAST);
		add(searchPanel, BorderLayout.SOUTH);
		
		// Display the window.
		// pack();
		setVisible(true);
	}
	
	private void buildUserPanel()
	{
		// Create 7 items: 5 JLabels, 2 buttons.
		JLabel displayTest = new JLabel("Your Profile");
		JLabel userPicture = new JLabel();
		JLabel userName = new JLabel();
		JLabel userFriends = new JLabel();
		JButton leaveNetworkBut = new JButton("Leave Network");
		JButton modifyProfileBut = new JButton("Modify Profile");
	
		// Initialize the JPanel.
		userPanel = new JPanel();
		
		// Add the 7 items to the panel.
		userPanel.add(displayTest);
		userPanel.add(userPicture);
		userPanel.add(userName);
		userPanel.add(userFriends);
		userPanel.add(leaveNetworkBut);
		userPanel.add(modifyProfileBut);
	}
	
	private void buildNetworkPanel()
	{
		
		
		// Initialize the JPanel.
		networkPanel = new JPanel();
	}
	
	private void buildSearchPanel()
	{
		// Create a JLabel, JTextField, and JButton.
		JLabel nameSearch = new JLabel("Name Search");
		JTextField textField = new JTextField(20);
		JButton searchBut = new JButton("Search");
		
		// Initialize the JPanel.
		searchPanel = new JPanel();
		
		// Add the JLabelm JTextField, and JButton to the panel.
		searchPanel.add(nameSearch);
		searchPanel.add(textField);
		searchPanel.add(searchBut);
	}
	
}
