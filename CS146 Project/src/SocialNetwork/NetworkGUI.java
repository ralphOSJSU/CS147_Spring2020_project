package SocialNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class NetworkGUI extends JFrame
{
	private Network socialNetwork;				// The Social Network.
	private User defaultUser;					// The defaultUser's profile.
	private final int WINDOW_WIDTH = 750;		// The width of the window.
	private final int WINDOW_HEIGHT = 600;		// The height of the window.
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
		buildNetworkUserPanel();
		buildSearchPanel();
		
		// Set the size of the panels.
		userPanel.setPreferredSize(new Dimension(200, WINDOW_HEIGHT - 100));
		
		
		// Add the JPanels to the network.
		add(userPanel, BorderLayout.WEST);
//		add(networkPanel, BorderLayout.EAST);
		add(searchPanel, BorderLayout.SOUTH);
		
		// Display the window.
		// pack();
		setVisible(true);
	}
	
	private void buildUserPanel()
	{
		// Create 7 items: 5 JLabels, 2 buttons.
		JLabel displayText = new JLabel("Your Profile");
		JLabel userPicture = new JLabel(defaultUser.getProfilePicture());
		JLabel userName = new JLabel("Name: " + defaultUser.getName());
		JLabel userStatus = new JLabel("Status: Online");
		JLabel userFriends = new JLabel("Friends: " + defaultUser.getFriends().size());
		JButton leaveNetworkBut = new JButton("Leave Network");
		JButton modifyProfileBut = new JButton("Modify Profile");
		
		// Align all 5 JLabels to the center.
		displayText.setHorizontalAlignment(JLabel.CENTER);
		userPicture.setHorizontalAlignment(JLabel.CENTER);
		userName.setHorizontalAlignment(JLabel.CENTER);
		userStatus.setHorizontalAlignment(JLabel.CENTER);
		userFriends.setHorizontalAlignment(JLabel.CENTER);
		
		// Initialize the JPanel, and put all 7 items on it.
		userPanel = new JPanel();
		userPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill =  c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.insets = new Insets(0, 0, 40, 0);
		userPanel.add(displayText,c);
        c.insets = new Insets(0, 0, 10, 0);
        c.gridy = 1;
		userPanel.add(userPicture,c);
        c.gridy = 2;
        userPanel.add(userName,c);
        c.gridy = 3;
        userPanel.add(userStatus,c);
        c.gridy = 4;
        userPanel.add(userFriends,c);
        c.gridy = 5;
        userPanel.add(leaveNetworkBut,c);
        c.gridy = 6;
        userPanel.add(modifyProfileBut,c);
	}
	
	private void buildNetworkUserPanel()
	{
		// Initialize the network JPanel.
		networkPanel = new JPanel();
		
		// Set the layout of the network JPanel.
		networkPanel.setLayout(new GridLayout(socialNetwork.getUsers().size(), 1));
		
		JScrollPane scrollPane = new JScrollPane(networkPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		
		// Add each user in the network into the JPanel.
		for (int i = 1; i < socialNetwork.getUsers().size(); i++)
		{
			networkPanel.add(buildNetworkUserPanel(socialNetwork.getUsers().get(i)));
		}
		
	}
	
	private JPanel buildNetworkUserPanel(User networkUser)
	{
		// Create 5 items: 4 JLabels, 1 button.
		JLabel userPicture = new JLabel(networkUser.getProfilePicture());
		JLabel userName = new JLabel("Name: " + networkUser.getName());
		JLabel userStatus = new JLabel("Status: " + networkUser.getStatus());
		JLabel userFriends = new JLabel("Their Friends: (Can't show --> Private");
		JButton addFriendBut = new JButton("+ Add Friend");

		// Initialize a sub JPanel, and add the 5 items to the sub JPanel.
		JPanel userNetworkPanel = new JPanel();
		userNetworkPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill =  c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 20);
		userNetworkPanel.add(userPicture, c);
        c.insets = new Insets(0, 10, 0, 20);
		c.gridx = 1;
		c.gridy = 0;
		userNetworkPanel.add(userName, c);
		c.gridx = 1;
		c.gridy = 1;
		userNetworkPanel.add(userStatus, c);
		c.gridx = 1;
		c.gridy = 2;
		userNetworkPanel.add(userFriends, c);
		c.gridx = 2;
		c.gridy = 1;
        c.insets = new Insets(0, 10, 0, 10);
		userNetworkPanel.add(addFriendBut, c);

		// Set the border for the sub JPanel.
		userNetworkPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
		
		// Return the sub JPanel.
		return userNetworkPanel;
	}
	
	private void buildSearchPanel()
	{
		// Create a JLabel, JTextField, and JButton.
		JLabel nameSearch = new JLabel("Name Search");
		JTextField textField = new JTextField(20);
		JButton searchBut = new JButton("Search");
		
		// Initialize the JPanel.
		searchPanel = new JPanel();
		
		// Add the JLabel. JTextField, and JButton to the panel.
		searchPanel.add(nameSearch);
		searchPanel.add(textField);
		searchPanel.add(searchBut);
	}
}
