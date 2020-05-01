
package SocialNetwork;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

/*
 * Class that handles users and their details.
 */

public class User {
	private BufferedImage picture;
    private String name;
    private Status status;
    private ArrayList<User> friends;
    
 // Constructor that initializes new users with a name, status, and friends ArrayList.
    public User(String name, Status status) {	
        this.name = name;
        this.status = status;
        this.friends = new ArrayList<>();;
    }

    public BufferedImage getProfilePicture()
    {
    	return picture;
    }
    
    public void setProfilePicture(BufferedImage newPicture)
    {
    	this.picture = newPicture;
    }
    
    public String getName() {					// Returns user's name.
        return name;
    }

    public void setName(String name) {			// Changes user's name.
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {			// Checks if one user is the same as another.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    public Status getStatus() {					// Returns user's status.
        return status;
    }

    public void setStatus(Status status) {		// Changes user's status.
        this.status = status;
    }

   
    public boolean addFriend(User friend){		// Method that adds friends to current user.
        if(!friends.contains(friend)){
            return friend.friends.add(this) && friends.add(friend);
        }
        return false;
    }

    public ArrayList<User> getFriends() {		// Returns list of user's current friends.
        return friends;
    }

    public void printFriends() {				// Prints out all friends of the user.
    	for (User u : friends)
    		System.out.println(u.getName());
    }
    
    public String toString()
    {
    	return "The name of this user is: " + this.getName(); 
    }
}


