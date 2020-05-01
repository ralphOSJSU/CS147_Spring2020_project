package SocialNetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDriver {

	 public static void main(String[] args)						// Main method to test the network and its users.
		{
			Scanner scan = new Scanner(System.in);
	    	
			System.out.println("Testing network and user functions.");
	    	System.out.println();
	    	
	    	Network n = new Network();
			
	    	System.out.println("Printing current users: ");
	    	n.printUsers();		// Previous getUser() method printed users, so I changed method to printUsers().
	    	System.out.println();
	    			
	    	System.out.println("Adding creators: Terry Hong and Ralph Orteza");
	    	System.out.println();
	    			
	    	User terry = new User("Terry Hong", Status.Online);
	    	User ralph = new User("Ralph Orteza", Status.Busy);
	    			
	    	n.addUser(terry);
	    	n.addUser(ralph);
	    			
	    	System.out.println("Printing current users: " );
	    	n.printUsers();
	    	System.out.println();
	    			
	    	System.out.println("Adding user: Faramarz Mortezaie");
	    	System.out.println();
	    			
	    	User mortezaie = new User("Faramarz Mortezaie", Status.Busy);
	    			
	    	n.addUser(mortezaie);
	    			
	    	System.out.println("Printing current users:");
	    	n.printUsers();
	    	System.out.println();
			
	    	System.out.println("Adding Mortezaie and Terry to Ralph's friend's list:");
	    	System.out.println();
	    			
	    	ralph.addFriend(terry);
	    	ralph.addFriend(mortezaie);
			
	    	System.out.println("Printing Ralph's friends list:");
	    			
	    	ralph.printFriends();
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
	    	System.out.print("Terry Hong and Terry Hong: ");
	    	System.out.println(terry.equals(terry));					// That's the Object class .equals() though.
	    	System.out.print("Terry Hong and Faramarz Mortezaie: ");
	    	System.out.println(terry.equals(mortezaie));
	    	System.out.println();
	    	
	    	System.out.println("Searching for user: Orteza Ralph");
	    	System.out.println(n.search("Orteza Ralph"));
	    	System.out.println("Searching for user: Ralph Orteza");
	    	System.out.println(n.search("Ralph Orteza").getName());
	    	System.out.println();
	    	
	    	System.out.println("Removing Terry Hong from the network:");
	    	n.deleteUser(terry);
	    	System.out.println();
	    	
	    	System.out.println("Printing new current users:");
	    	n.getUsers();
	    	System.out.println();
	    	
	    	System.out.println("Re-adding Terry Hong to the network:");
	    	n.addUser(terry);
	    	System.out.println();
	    	
	    	System.out.println("Printing new current users:");
	    	n.getUsers();
	    	System.out.println();
	    	
	    	
	    	System.out.println("Printing adjacency list:");
	    	ArrayList<ArrayList<User>> al = n.adjecencyList();
	    	
	    	for (int i = 0; i < al.size(); i++)
	    	{
	    		System.out.println(n.getUsers().get(i).getName() + "'s friends:");	// This is because before it was split, they were in same class so same visiblity.
	    		ArrayList<User> friendGroup = al.get(i);
	    		for (User u : friendGroup)
	    			System.out.println(u.getName());
	    		System.out.println();
	    	}
	    	
	    	scan.close();
		}
}
