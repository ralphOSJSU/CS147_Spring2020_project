package SocialNetwork;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class runs the main GUI to simulate a Social Network.
 * @author Terry Hong
 * @author Ralph Orteza
 */
public class NetworkGUI extends JFrame
{
	private final int 	WINDOW_WIDTH = 1000;	// The width of the window.
	private final int 	WINDOW_HEIGHT = 600;	// The height of the window.
	private Network 	socialNetwork;			// The Social Network.
	private User 		defaultUser;			// The defaultUser's profile.
	private User 		currentNetworkUser;		// The current User in the Network.
	private JPanel 		userPanel;				// To hold the user's profile.
	private JPanel 		networkPanel;			// To hold the network of Users.
	private JPanel 		addFriendPanel;			// To hold the JList of friends.
	private JPanel 		searchPanel;			// To hold the search bar.
	private JList 		addFriendList;			// The JList for all Users in the Network.
	private JTextField 	searchTextField;		// The search bar for the Users in the Network.
	
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
		
		// Disable resizing the window.
		this.setResizable(false);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a BorderLayout manager to the content panel.
		setLayout(new BorderLayout());
		
		// Build the JPanels.
		buildUserPanel();
		buildNetworkUserPanel();
		buildSearchPanel();
		buildAddFriendPanel();
		
		// Set the JScrollPane for the network.
		JScrollPane scrollPaneNetwork = new JScrollPane(networkPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scrollPaneAddFriend = new JScrollPane(addFriendPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// Set the size of the panels.
		userPanel.setPreferredSize(new Dimension(200, WINDOW_HEIGHT - 100));
		scrollPaneNetwork.setPreferredSize(new Dimension(550, WINDOW_HEIGHT - 100));
		scrollPaneAddFriend.setPreferredSize(new Dimension(250, WINDOW_HEIGHT - 100));
		
		// Add the JPanels to the network.
		add(userPanel, BorderLayout.WEST);
		add(scrollPaneNetwork, BorderLayout.CENTER);
		add(scrollPaneAddFriend, BorderLayout.EAST);
		add(searchPanel, BorderLayout.SOUTH);
		
		// Display the window.
		setVisible(true);
	}
	
	// Build the userPanel on the left side of the JFrame.
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
		
		// Add Action Listeners to the modifyProfileBut and the leaveNetworkBut.
		leaveNetworkBut.addActionListener(new leaveNetworkButListener());
		modifyProfileBut.addActionListener(new modifyProfileButListener());
		
		// Initialize the JPanel, and put all 7 items on it.
		userPanel = new JPanel();
		userPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill =  c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.insets = new Insets(0, 0, 20, 0);
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
	
	// Build the networkPanel on the center of the JFrame.
	private void buildNetworkUserPanel()
	{
		// Initialize the network JPanel.
		networkPanel = new JPanel();
		
		// Set the layout of the network JPanel.
		networkPanel.setLayout(new GridLayout(socialNetwork.getUsers().size(), 1));
		
		
		/* 	
		 	Adjacency List:
			This is the outer for-loop that goes through every user
		 	The method it calls has another for-loop that goes through the current user's arraylist of friends.
		*/
		
		
		// Add each user in the network into the JPanel.
		for (int i = 0; i < socialNetwork.getUsers().size(); i++)
		{
			// Add the NetworkUserPanel to a left-aligned tempPanel, then add the tempPanel to the networkPanel.
			JPanel tempPanel = new JPanel();
			tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT,3,3));
			tempPanel.add(buildNetworkUserPanel(socialNetwork.getUsers().get(i)));
			networkPanel.add(tempPanel);
		}
		
		System.out.println("test");
	}
	
	// Build a panel for the User input from the network, then add to the main networkPanel.
	private JPanel buildNetworkUserPanel(User networkUser)
	{
		// Create 5 items: 4 JLabels, 1 button.
		JLabel userPicture = new JLabel(networkUser.getProfilePicture());
		JLabel userName = new JLabel("Name: " + networkUser.getName());
		JLabel userStatus = new JLabel("Status: " + networkUser.getStatus());
		JLabel userFriends = new JLabel();
		
		// If defaultUser is friends with the networkUser, display their friends. Otherwise, make it private.
		if (defaultUser.getFriends().contains(networkUser))
		{
			userFriends.setText("Their Friends: " + networkUser.getFriends().get(0).getName() + " ");
			for (int i = 1; i < networkUser.getFriends().size(); i++)
			{
				User currentUser = networkUser.getFriends().get(i);
				userFriends.setText(userFriends.getText() + " --> " + currentUser.getName());
			}
		}
		else
		{
			userFriends.setText("Their Friends: (Can't show --> Private)");
		}
		
		// Initialize a sub JPanel, and add the 5 items to the sub JPanel.
		JPanel userNetworkPanel = new JPanel();
		userNetworkPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
        c.gridheight = 3;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
		userNetworkPanel.add(userPicture, c);
        c.insets = new Insets(10, 10, 0, 10);
        c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 0;
		userNetworkPanel.add(userName, c);
		c.gridx = 1;
		c.gridy = 1;
		userNetworkPanel.add(userStatus, c);
        c.insets = new Insets(25, 10, 15, 10);
		c.gridx = 1;
		c.gridy = 2;
		userNetworkPanel.add(userFriends, c);
		c.gridx = 2;
		c.gridy = 1;
		
		// Return the sub JPanel.
		return userNetworkPanel;
	}
	
	// Build the addFriendPanel on the right side of the JFrame.
	private void buildAddFriendPanel()
	{
		// Create a JButton to add a friend.
		JButton addFriend = new JButton("+ Add Friend");
		
		// Initialize the JPanel.
		addFriendPanel = new JPanel();
		
		addFriendPanel.setLayout(new BorderLayout());
		
		// Initialize the JList.
		addFriendList = new JList(socialNetwork.getUsers().toArray());
		
		// Add a List Selection Listener.
		addFriendList.addListSelectionListener(new ListListener());
		addFriend.addActionListener(new addFriendButListener());
		
		// Set a custom space for each item in the list.
		addFriendList.setFixedCellHeight(50);
		
		// Add the JList and JButtonto the JPanel.
		addFriendPanel.add(addFriendList);
		addFriendPanel.add(addFriend, BorderLayout.SOUTH);
	}
	
	// Build the searchPanel at the bottom of the JFrame.
	private void buildSearchPanel()
	{
		// Create a JLabel, JTextField, and JButton.
		JLabel nameSearch = new JLabel("Name Search");
		searchTextField = new JTextField(20);
		JButton searchBut = new JButton("Search");
		
		// Add an Action Listener to the search button.
		searchBut.addActionListener(new searchButListener());
		
		// Initialize the JPanel.
		searchPanel = new JPanel();
		
		// Set the size of the searchPanel.
		searchPanel.setPreferredSize(new Dimension(200, 50));
		
		// Add the JLabel. JTextField, and JButton to the panel.
		searchPanel.add(nameSearch);
		searchPanel.add(searchTextField);
		searchPanel.add(searchBut);
	}
	
	// Add the currentNetworkUser to the defaultUser's friend list, then reopen the GUI to update information.
	private class addFriendButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Add the currentNetworkUser to the defaultUser's friend list. 
			defaultUser.addFriend(currentNetworkUser);
			
			// Closes the window.
			dispose();
			
			// Restart the main network GUI with updated information.
			new NetworkGUI(defaultUser, socialNetwork);
			
		}
	}
	
	// Set the currentNetworkUser to the selected User in the network.
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			currentNetworkUser = (User) addFriendList.getSelectedValue();
		}
	}
	
	// When the button is pressed, dispose of the window and terminate the program.
	private class leaveNetworkButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Closes the window.
			dispose();
			
			// Terminates the program.
			System.exit(ABORT);
		}
	}
	
	// When the button is pressed, close the NetworkGUI frame and go back to the welcome screen.
	private class modifyProfileButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Closes the window.
			dispose();
			
			// Restart the WelcomeGUI screen with updated information.
			new WelcomeGUI(defaultUser, socialNetwork);
		}
	}
	
	// Searches the social network for a User's name.
	private class searchButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// 
			String input = searchTextField.getText();
			int index = 0;
			boolean found = false;
			
			
			while (index < socialNetwork.getUsers().size() && !found)
			{
	            if(socialNetwork.getUsers().get(index).getName().equalsIgnoreCase(input))
	            {
	    			found = true;
	            }
	            index++;
			}
			
			// 
	        if (found)
	        	JOptionPane.showMessageDialog(null, "The user is at position " + index + ".");
	        else
	        	JOptionPane.showMessageDialog(null, "The user is not in the social network.");
		}
	}
}
