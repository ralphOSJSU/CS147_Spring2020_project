package testingPack;

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

    public ArrayList<ArrayList<User>> adjecencyList(){			// Creates an adjacency list for the network using the users and their friends.
        ArrayList<ArrayList<User>> list = new ArrayList<>();
        for(User user : users) {
            list.add(user.getFriends());
        }
        return list;
    }

    public static void main(String[] args)						// Main method to test the network and its users.
	{
		Scanner scan = new Scanner(System.in);
    	
		System.out.println("Testing network and user functions.");
    	System.out.println();
    	
    	Network n = new Network();
		
    	System.out.println("Printing current users:");
    	n.getUsers();
    	System.out.println();
    			
    	System.out.println("Adding creators: Ryan Tran and Timothy Yang");
    	System.out.println();
    			
    	User ryan = new User("Ryan Tran", Status.Online);
    	User timothy = new User("Timothy Yang", Status.Busy);
    			
    	//n.addUser(david);
    	//n.addUser(samson);
    			
    	System.out.println("Printing current users:");
    			
    	n.getUsers();
    	System.out.println();
    			
    	System.out.println("Adding user: Faramarz Mortezaie");
    	System.out.println();
    			
    	User mortezaie = new User("Faramarz Mortezaie", Status.Busy);
    			
    	n.addUser(mortezaie);
    			
    	System.out.println("Printing current users:");
    			
    	n.getUsers();
    	System.out.println();
		
    	System.out.println("Adding Mortezaie and Ryan to Timothy's friend's list:");
    	System.out.println();
    			
    	timothy.addFriend(ryan);
    	timothy.addFriend(mortezaie);
		
    	System.out.println("Printing Timothy's friend's list:");
    			
    	timothy.printFriends();
    	System.out.println();
    	
    	System.out.println("Printing Mortezaie's status:");
    	
    	System.out.println(mortezaie.getStatus());
    	System.out.println();
    	
    	System.out.println("Setting Mortezaie's status to Away:");
    	mortezaie.setStatus(Status.Away);
    	System.out.println();
    	
    	System.out.println("Printing Mortezaie's new status:");
    	
    	System.out.println(mortezaie.getStatus());
    	System.out.println();
    	
    	System.out.println("Checking if two users are the same:");
    	System.out.print("Ryan Tran and Ryan Tran: ");
    	System.out.println(ryan.equals(ryan));
    	System.out.print("Ryan Tran and Faramarz Mortezaie: ");
    	System.out.println(ryan.equals(mortezaie));
    	System.out.println();
    	
    	System.out.println("Searching for user: Yang Timothy");
    	System.out.println(n.search("Yang Timothy"));
    	System.out.println("Searching for user: Timothy Yang");
    	System.out.println(n.search("Timothy Yang"));
    	System.out.println();
    	
    	System.out.println("Removing Ryan Tran from the network:");
    	n.deleteUser(ryan);
    	System.out.println();
    	
    	System.out.println("Printing new current users:");
    	n.getUsers();
    	System.out.println();
    	
    	System.out.println("Re-adding Ryan Tran to the network:");
    	n.addUser(ryan);
    	System.out.println();
    	
    	System.out.println("Printing new current users:");
    	n.getUsers();
    	System.out.println();
    	
    	System.out.println("Printing adjacency list:");
    	ArrayList<ArrayList<User>> al = n.adjecencyList();
    	
    	for (int i = 0; i < n.users.size(); i++)
    	{
    		System.out.println(n.users.get(i).getName() + "'s friends:");
    		ArrayList<User> friendGroup = al.get(i);
    		for (User u : friendGroup)
    			System.out.println(u.getName());
    		System.out.println();
    	}
    	
    	scan.close();
	}
}