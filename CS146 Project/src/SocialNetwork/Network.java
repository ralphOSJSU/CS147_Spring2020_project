package SocialNetwork;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Scanner;

// Social Network Project.
// By Terry Hong and Ralph Orteza.
// Class that handles the network and the management of its users.

public class Network 
{
    private ArrayList<User> users;

    // Initializes Network with an ArrayList of type User to simulate a network.
    public Network() 
    {						
        this.users = new ArrayList<User>();
    }

    // Prints out all users in the network.
    public void printUsers() 
    {				
        for (User u : users)
        	System.out.println(u.getName());
    }
        
    // Returns an ArrayList of all the users in the network.
    public ArrayList<User> getUsers()
    {			
        return users;
    }
        
    // Adds a given user to the network if they are not already in the network. Returns true if successful.
    public boolean addUser(User u) 
    {		
        if(!users.contains(u)){
            return users.add(u);
        }
        return false;
    }

    // Removes a user from the network. Returns true if successful.
    public boolean deleteUser(User u) 
    {		
        return users.remove(u);
    }

    // Searches the network for a user by name. If found, returns the user. Else, returns null.
    public User search(String name)
    {		
        for (User user : users) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }
    
    /*
     *  Takes a User and their friend, finds them in the network, then returns the friend's list of friends. 
     *  Else, cannot find user or friend, return null.
     */
    public ArrayList<User> getFriendsListOfFriends(User u, User friend)
    {
    	// Find the User in the network.
    	if (this.search(u.getName()) != null)
    	{
    		// Find the friend in the user's friend list.
    		for (User user : u.getFriends())
    		{
    			// If the friend is found, return the friend's list of friends.
                if(user.getName().equalsIgnoreCase(friend.getName()))
                {
                	return user.getFriends();
                }
    		}
    	}
    	return null;
    }

    // Creates an adjacency list for the network using the users and their friends.
    public ArrayList<ArrayList<User>> adjecencyList()
    {			
        ArrayList<ArrayList<User>> list = new ArrayList<>();
        for(User user : users)
        {
            list.add(user.getFriends());
        }
        return list;
    }
}
