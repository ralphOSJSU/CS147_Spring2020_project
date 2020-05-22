package SocialNetwork;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class runs the GUI for the welcome screen to the Social Network.
 * @author Terry Hong
 * @author Ralph Orteza
 */

public class WelcomeGUI extends JFrame
{
	private final int 	WINDOW_WIDTH = 600;		// The width of the window.
	private final int 	WINDOW_HEIGHT = 600;	// The height of the window.
	private Network 	socialNetwork;			// The Social Network.
	private User 		defaultUser;			// The default User.
	private JPanel		namePanel;				// To hold the user's name.
	private JPanel		imagePanel;				// To hold the user's image selection.
	private JLabel 		selectImage;			// To hold display the user's image.
	private ImageIcon 	userImage;				// To hold the user's image.
	private JTextField 	userNameInput;			// To hold the user's input name.
	
	// Constructor.
	public WelcomeGUI(User defaultUser, Network socialNetwork)
	{
		// Initialize defaultUser.
		this.defaultUser = defaultUser;
		
		// Initialize the socialNetwork.
		this.socialNetwork = socialNetwork;
		
		// Set the title bar text.
		setTitle("The Social Network");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Prevent resizing of this window.
		this.setResizable(false);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a BorderLayout manager to the content panel.
		setLayout(new BorderLayout());
		
		// Build the panels.
		buildNamePanel();
		buildImagePanel();
		
		// Add the panels to the window.
		JButton joinButton = new JButton("JOIN");
		add(namePanel, BorderLayout.NORTH);
		add(imagePanel, BorderLayout.CENTER);
		add(joinButton, BorderLayout.SOUTH);
		joinButton.addActionListener(new joinButtonListener());
		
		// Display the window.
		setVisible(true);
	}

	// Build the title and namePanel at the top of the JFrame.
	private void buildNamePanel()
	{
		// Create 4 items: 3 JLabels and a JButton.
		JLabel createProfileMessage = new JLabel("CREATE PROFILE TO JOIN NETWORK");
		JLabel nameLabel = new JLabel("Name");
		JLabel newLine = new JLabel(" ");
		JButton setName = new JButton("Set Name");
		
		// Initialize the JTextField for the user's name.
		userNameInput = new JTextField(20);
		
		// Add an Action Listener to the setName JButton.
		setName.addActionListener(new setNameButListener());
		
		// If defaultUser has a name, set the JTextField userNameInput to it.
		if (defaultUser.getName() != null)
		{
			String selection = defaultUser.getName();
			userNameInput.setText(selection);
		}
		
		// Initialize the JPanel.
		namePanel = new JPanel();
		
		// Set the size for the newLine JLabel.
		newLine.setPreferredSize(new Dimension(WINDOW_WIDTH, 0));
		
		// Add the components to the JPanel.
		namePanel.add(createProfileMessage);
		namePanel.add(newLine);
		namePanel.add(nameLabel);
		namePanel.add(userNameInput);
		namePanel.add(setName);
		namePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	}
	
	// Build the imagePanel at the center of the JFrame.
	private void buildImagePanel()
	{
		// Create a JLabel and a JButton.
		selectImage = new JLabel("Select Image");
		JButton selectImageBut = new JButton("Upload");
		selectImage.setPreferredSize(new Dimension(100,100));
		selectImageBut.setPreferredSize(new Dimension(80,80));
		selectImageBut.addActionListener(new setImageButListener());
		
		// If defaultUser already has a picture, set the JLabel selectImage to the picture.
		if (defaultUser.getProfilePicture() != null)
		{
			userImage = defaultUser.getProfilePicture();
			selectImage.setIcon(userImage);
			selectImage.setText(null);
		}

		// Initialize the JPanel.
		imagePanel = new JPanel();
		
		// Add the JLabel and JButton to the panel.
		imagePanel.add(selectImage);
		imagePanel.add(selectImageBut);
		imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	}
	
	// Resizes an ImageIcon.
	private ImageIcon ResizeImage(String ImagePath)
	{
		// Creates an ImageIcon with the ImagePath.
		ImageIcon currentImage = new ImageIcon(ImagePath);
		
		// Creates an Image and resizes it.
		Image img = currentImage.getImage();
		Image newImg = img.getScaledInstance(selectImage.getWidth(), selectImage.getHeight(), Image.SCALE_SMOOTH);
		
		//Creates a resized ImageIcon and returns it.
		ImageIcon resizedImage = new ImageIcon(newImg);
		return resizedImage;
	}
	
	/*
	 * Closes the WelcomeGUI window and initializes the NetworkGUI window.
	 * If the user did not enter a name or profile picture, assign default values.
	 * In addition, assign default profile pictures for all users in the Social Network.
	 */
	private class joinButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (defaultUser.getName() == null)
			{
				// If the user never added a name, show a message dialog.
				JOptionPane.showMessageDialog(null, "Please enter a name before entering.");
			}
			else
			{
				// If the user did not choose an image, resize the DefaultPic and assign it to the User.
				if (defaultUser.getProfilePicture() == null)
				{
					ImageIcon defaultPic = new ImageIcon(Image.class.getResource("/resources/DefaultPic.jpg"));
					Image img = defaultPic.getImage();
					Image newImg = img.getScaledInstance(selectImage.getWidth(), selectImage.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon resizedDefaultPic = new ImageIcon(newImg);
					defaultUser.setProfilePicture(resizedDefaultPic);
				}
				
				// If the user entered an empty name, assign the name to "Default User".
				if (defaultUser.getName().equals("") || defaultUser.getName().equals(" "))
				{
					defaultUser.setName("Default User");
				}
				
				// Get the default profile pictures for all users in the social network.
				ImageIcon defaultPic = new ImageIcon(Image.class.getResource("/resources/Default_NetworkPic.jpg"));
				Image img = defaultPic.getImage();
				Image newImg = img.getScaledInstance(selectImage.getWidth(), selectImage.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon resizedDefaultPic = new ImageIcon(newImg);

				// Set the default profile picture for all users in the Social Network.
				for (User currentUser : socialNetwork.getUsers())
				{
					if (currentUser.getProfilePicture() == null)
					{
						currentUser.setProfilePicture(resizedDefaultPic);
					}
				}
				
				// Closes the window.
				dispose();
				
				// Now go to the main network GUI.
				new NetworkGUI(defaultUser, socialNetwork);
			}
		}
	}
	
	// When the setName button is pressed, assign the defaultUser's name to the input.
	private class setNameButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String nameInput = userNameInput.getText();
			defaultUser.setName(nameInput);
		}
	}
	
	// When the setImage button is pressed, the defaultUser chooses a profile picture using JFileChooser.
	private class setImageButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Use JFileChooser to allow the user to choose a image file.
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "gif", "png");
			file.addChoosableFileFilter(filter);
			
			// If the user pressed the save button, update the image. Else, output a message.
			if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = file.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				userImage = ResizeImage(path);
				selectImage.setText(null);
				selectImage.setIcon(userImage);
				defaultUser.setProfilePicture(userImage);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "No image file was selected.");
			}
		}
	}
}
