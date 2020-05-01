package SocialNetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDriver {

	 public static void main(String[] args)						// Main method to test the network and its users.
		{
			Scanner scan = new Scanner(System.in);
	    	
			// Comment in MainDriver.java
			// Changes part 2
			// This is Ralphs comment
			
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
	    	
	    	for (int i = 0; i < al.size(); i++)
	    	{
	    		System.out.println(al.get(i)+ "'s friends:");
	    		ArrayList<User> friendGroup = al.get(i);
	    		for (User u : friendGroup)
	    			System.out.println(u.getName());
	    		System.out.println();
	    	}
	    	
	    	scan.close();
		}
}
