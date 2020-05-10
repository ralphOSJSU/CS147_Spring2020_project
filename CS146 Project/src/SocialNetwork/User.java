package SocialNetwork;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ImageIcon;

/*
 * This class is a represent's a user's profile.
 */

public class User 
{
	// Instance variables.
	private ImageIcon picture;
    private String name;
    private Status status;
    private ArrayList<User> friends;
    
    // Constructor that initializes new users with a name, status, and friends ArrayList.
    public User(String name, Status status)
    {	
        this.name = name;
        this.status = status;
        this.friends = new ArrayList<>();;
        this.picture = null;
    }
    
    // Default constructor that initializes all variables to null or empty.
    public User()
    {	
        this.name = null;
        this.status = null;
        this.friends = new ArrayList<>();;
        this.picture = null;
    }

    // The method returns the profile picture of the user.
    public ImageIcon getProfilePicture()
    {
    	return picture;
    }
    
    // The method sets the profile picture of the user.
    public void setProfilePicture(ImageIcon newPicture)
    {
    	this.picture = newPicture;
    }
    
    // Returns the user's name.
    public String getName() 
    {					
        return name;
    }

    // Changes user's name.
    public void setName(String name) 
    {			
        this.name = name;
    }

    // Checks if one user is the same as another.
    @Override
    public boolean equals(Object o) 
    {			
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    // Returns user's status.
    public Status getStatus() 
    {					
        return status;
    }

    // Changes user's status.
    public void setStatus(Status status) 
    {		
        this.status = status;
    }

    
    /*
     * Adds a friend to the user's friend list and adds the user to the friend's friend list.
     * Returns true if successfully added both ways. Else, returns false.
     */
    public boolean addFriend(User friend)
    {		
        if(!friends.contains(friend)){
            return friend.friends.add(this) && friends.add(friend);
        }
        return false;
    }
    
    /*
     * Removes a friend from the user's friend list and removes the user from the friend's friend list.
     * Returns true if successfully removed both ways. Else, returns false.
     */
    public boolean removeFriend(User friend)
    {		
        if(!friends.contains(friend)){
            return friend.friends.remove(this) && friends.remove(friend);
        }
        return false;
    }

    // Returns the ArrayList of user's current friends.
    public ArrayList<User> getFriends() 
    {		
        return friends;
    }

    // Prints out all friends of the user.
    public void printFriends() 
    {				
    	for (User u : friends)
    		System.out.println(u.getName());
    }
    
    // Displays the profile's information and friendProfiles.
	public void display()
	{
		
	}
    
    // Prints out the name and status of the user.
    public String toString()
    {
    	return this.getName() + " Status: " + this.getStatus();
    }
}
