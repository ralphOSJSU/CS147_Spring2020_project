package SocialNetwork;
import java.util.ArrayList;
import java.util.Scanner;

// Social Network Project
// By .....
// Class that handles the network and the management of its users.


public class Network {
    private ArrayList<User> users;

    public Network() {						// Initializes Network with an ArrayList of type User to contain network members.
        users = new ArrayList<>();
    }

    public void getUsers() {				// Prints out all users in the network.
        for (User u : users)
        	System.out.println(u.getName());
    }

    public boolean addUser(User u) {		// Adds a user to the network if they are not already in the network. Returns true if successful.
        if(!users.contains(u)){
            return users.add(u);
        }
        return false;
    }

    public boolean deleteUser(User u) {		// Removes a user from the network. Returns true if successful.
        return users.remove(u);
    }

    public User search(String name){		// Searches for a user by name. If found, returns the user. Else, returns null.
        for (User user : users) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

 // Creates an adjacency list for the network using the users and their friends.
    public ArrayList<ArrayList<User>> adjecencyList(){			
        ArrayList<ArrayList<User>> list = new ArrayList<>();
        for(User user : users) {
            list.add(user.getFriends());
        }
        return list;
    }
}