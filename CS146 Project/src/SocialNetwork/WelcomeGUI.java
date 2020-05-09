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
	private final int WINDOW_WIDTH = 500;		// The width of the window.
	private final int WINDOW_HEIGHT = 500;		// The height of the window.
	private JPanel namePanel;					// To hold the user's name.
	private JPanel imagePanel;					// To hold the user's image selection.
	private JTextField userNameInput;
	private JLabel selectImage;
	private ImageIcon userImage;
	
	public WelcomeGUI(Network socialNetwork)
	{
		// Initialize the socialNetwork.
		this.socialNetwork = socialNetwork;
		
		// Set the title bar text.
		setTitle("The Social Network");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a BorderLayout manager to the content panel.
		setLayout(new FlowLayout());
		
		// Build the panels.
		buildNamePanel();
		buildImagePanel();
		
		// Add the panels to the window.
		
		JButton joinButton = new JButton("JOIN");
		add(new JLabel("CREATE PROFILE TO JOIN NETWORK"), BorderLayout.NORTH);
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
		JButton setName = new JButton("Set Name");			// Set name will be a button that reads textfield then assigns to user.name
		setName.addActionListener(new setNameButListener());
		userNameInput = new JTextField(20);
		
		// Initialize the JPanel.
		namePanel = new JPanel();
		
		// Add the JLabel and JTextField to the panel.
		namePanel.add(nameLabel);
		namePanel.add(userNameInput);
		namePanel.add(setName);
	}
	
	private void buildImagePanel()
	{
		// Create a JLabel and a JButton.
		selectImage = new JLabel("Select Image");
		JButton selectImageBut = new JButton("Upload");
		selectImage.setPreferredSize(new Dimension(400,400));
		selectImageBut.setPreferredSize(new Dimension(50,50));
		selectImageBut.addActionListener(new setImageButListener());

		// Initialize the JPanel.
		imagePanel = new JPanel();
		
		// Add the JLabel and Jbutton to the panel.
		imagePanel.add(selectImage);
		imagePanel.add(selectImageBut);
	}
	
	private ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon currentImage = new ImageIcon(ImagePath);
		Image img = currentImage.getImage();
		Image newImg = img.getScaledInstance(selectImage.getWidth(), selectImage.getHeight(), Image.SCALE_SMOOTH);
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
	
	// 
	private class setNameButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String nameInput = userNameInput.getText();
			defaultUser.setName(nameInput);
		}
	}
	
	// 
	private class setImageButListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
			file.addChoosableFileFilter(filter);
			int result = file.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = file.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				userImage = ResizeImage(path);
				selectImage.setText(null);
				selectImage.setIcon(userImage);
			}
		}
	}
}
