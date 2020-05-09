package SocialNetwork;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WelcomeGUI extends JFrame
{
	private Network socialNetwork;				// The Social Network.
	private User defaultUser;					// The default User.
	private final int WINDOW_WIDTH = 600;		// The width of the window.
	private final int WINDOW_HEIGHT = 600;		// The height of the window.
	private JPanel namePanel;					// To hold the user's name.
	private JPanel imagePanel;					// To hold the user's image selection.
	private JTextField userNameInput;			// To hold the user's input name.
	private JLabel selectImage;					// To hold display the user's image.
	private ImageIcon userImage;				// To hold the user's image.
	
	public WelcomeGUI(Network socialNetwork)
	{
		// Initialize defaultUser;
		defaultUser = new User();
		
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

	private void buildNamePanel()
	{
		// Create a JLabel and a JTextField
		JLabel nameLabel = new JLabel("Name");
		JLabel newLine = new JLabel(" ");
		JLabel createProfileMessage = new JLabel("CREATE PROFILE TO JOIN NETWORK");
		JButton setName = new JButton("Set Name");
		setName.addActionListener(new setNameButListener());
		userNameInput = new JTextField(20);
		
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
	
	private void buildImagePanel()
	{
		// Create a JLabel and a JButton.
		selectImage = new JLabel("Select Image");
		JButton selectImageBut = new JButton("Upload");
		selectImage.setPreferredSize(new Dimension(100,100));
		selectImageBut.setPreferredSize(new Dimension(80,80));
		selectImageBut.addActionListener(new setImageButListener());

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
	
	// Closes the welcomeGUI and initializes the main NetworkGUI.
	private class joinButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Create a temporary Network to store the Network.
			Network tempNetwork = socialNetwork;
			
			// Closes the window.
			dispose();
			
			// Now go to the main network GUI.
			new NetworkGUI(defaultUser, tempNetwork);
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
