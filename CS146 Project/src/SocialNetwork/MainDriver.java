package SocialNetwork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates an object of type Network and tests out the code.
 * @author Terry Hong
 * @author Ralph Orteza
 */

public class MainDriver 
{
	// Main method to test the network and its users.
	public static void main(String[] args) 
	{
		// Print the start of the test.
		System.out.println("Testing network and user functions.");
		System.out.println("\n");

		// Create a Network.
		Network n = new Network();

		// 1. Output should be nothing since nobody was added yet.
		System.out.println("(1) Printing current users: ");
		n.printUsers();
		System.out.println();

		// 2. Adds Terry Hong and Ralph Orteza to the Network.
		System.out.println("(2) Adding creators: Terry Hong and Ralph Orteza");
		System.out.println();
		User terry = new User("Terry Hong", Status.Online);
		User ralph = new User("Ralph Orteza", Status.Busy);
		n.addUser(terry);
		n.addUser(ralph);

		// 3. Now that they are added, print the users. Should print Terry Hong and Ralph Orteza.
		System.out.println("(3) Printing current users: ");
		n.printUsers();
		System.out.println();

		// 4. Now user Faramarz Mortezaie is being added to the network.
		System.out.println("(4) Adding user: Faramarz Mortezaie");
		System.out.println();
		User mortezaie = new User("Faramarz Mortezaie", Status.Busy);
		n.addUser(mortezaie);

		// 5. Now, print all users. Should print Terry Hong, Ralph Orteza, and Faramarz Mortezaie.
		System.out.println("(5) Printing current users:");
		n.printUsers();
		System.out.println();

		// 6. Now, Add Mortezaie and Terry to Ralph's friend list. This method adds both ways.
		// This also means that Ralph is in Terry's friend list.
		// This also means that Ralph is in Mortezaie's friend list.
		System.out.println("(6) Adding Mortezaie and Terry to Ralph's friend list:");
		System.out.println();
		ralph.addFriend(terry);
		ralph.addFriend(mortezaie);

		// 7. Now, print Ralph's friends.
		System.out.println("(7) Printing Ralph's friends list:");
		ralph.printFriends();
		System.out.println();
		
		// 8. Now, print Terry's friends.
		System.out.println("(8) Printing Terry's friends list:");
		terry.printFriends();
		System.out.println();
		
		// 9. Now, print Mortezaie's friends.
		System.out.println("(9) Printing Mortezaie's friends list:");
		mortezaie.printFriends();
		System.out.println();

		// 10. Print Mortezaie's status. It should print Busy.
		System.out.println("(10) Printing Mortezaie's status:");
		System.out.println(mortezaie.getStatus());
		System.out.println();

		// 11. Set Mortezaie's status to Away.
		System.out.println("(11) Setting Mortezaie's status to Away:");
		mortezaie.setStatus(Status.Away);
		System.out.println();
		
		// 12. Print Mortezaie's new status. It should print Away.
		System.out.println("(12) Printing Mortezaie's new status:");
		System.out.println(mortezaie.getStatus());
		System.out.println();

		System.out.println("Checking if two users are the same:");
		
		// 13. Print if Terry Hong and Terry Hong are the same. It should print true.
		System.out.print("(13) Terry Hong and Terry Hong: ");
		System.out.println(terry.equals(terry)); 					
		System.out.println();
		
		// 14. Print if Terry Hong and Faramarz Mortezaie are the same. It should print false.
		System.out.print("(14) Terry Hong and Faramarz Mortezaie: ");
		System.out.println(terry.equals(mortezaie));
		System.out.println();

		// 15. Searches for Orteza Ralph in the network. It should return null.
		System.out.println("(15) Searching for user: Orteza Ralph");
		System.out.println(n.search("Orteza Ralph"));			
		System.out.println();
		
		// 16. Searches for Ralph Orteza in the network. It should return his name.
		System.out.println("(16) Searching for user: Ralph Orteza");
		System.out.println(n.search("Ralph Orteza").getName());
		System.out.println();

		// 17. Removes Terry Hong from the Network.
		System.out.println("(17) Removing Terry Hong from the network:");
		n.deleteUser(terry);
		System.out.println();

		// 18. Prints all users in the network. It should print Ralph Orteza and Faramarz Mortezaie.
		System.out.println("(18) Printing new current users:");
		n.printUsers();
		System.out.println();

		// 19. Add Terry Hong back to the network.
		System.out.println("(19) Re-adding Terry Hong to the network:");
		n.addUser(terry);
		System.out.println();

		// 20. Print all users in the network. It should print Ralph Orteza, Faramarz Mortezaie, and Terry Hong.
		System.out.println("Printing new current users:");
		n.printUsers();
		System.out.println();

		// 21. Creates and prints the adjacency list of the social network.
		System.out.println("(21) Printing adjacency list:");
		ArrayList<ArrayList<User>> al = n.adjecencyList();

		// Iterate for every User in the social network.
		for (int i = 0; i < al.size(); i++) 
		{
			// Iterate for every friend of every User in the social network.
			System.out.println(n.getUsers().get(i).getName() + "'s friends:");
			ArrayList<User> friendGroup = al.get(i);
			for (User u : friendGroup)
				System.out.println(u.getName());
			System.out.println();
		}

		// 22. Tests the friendsOfFriends method.
		System.out.println("(22) Adding David Nguyen, setting Ralph as his friend, and getting Ralph's Friends via David.");
		User david = new User("David Nguyen", Status.Invisible);
		n.addUser(david);
		david.addFriend(ralph);
		
		// Now David and Ralph are friends. It get's Ralph's friends via David.
		ArrayList<User> friendGroupTwo = n.getFriendsListOfFriends(david, ralph);
		for (User u : friendGroupTwo)
			System.out.println(u.getName());
		System.out.println();
		
		// Additional new Users to add for testing in the GUI only.
		User jason = new User("Jason Bourne", Status.Online);
		User steven = new User("Steven Dang", Status.Do_Not_Disturb);
		User tommy = new User("Tommy Nguyen", Status.Away);
		User anh = new User("Anh Nguyen", Status.Invisible);
		User justin = new User("Justin Nhi", Status.Busy);
		n.addUser(jason);
		n.addUser(steven);
		n.addUser(tommy);
		n.addUser(anh);
		n.addUser(justin);
		n.addUser(jason);
		steven.addFriend(tommy);
		steven.addFriend(anh);
		steven.addFriend(terry);
		tommy.addFriend(terry);
		terry.addFriend(anh);
		justin.addFriend(terry);
		
		// Create a default user for the GUI.
		User defaultUser = new User();
		
		// Starts the GUI for the welcome screen.
		new WelcomeGUI(defaultUser, n);
	}
}
