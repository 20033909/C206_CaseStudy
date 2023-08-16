<<<<<<< HEAD
import java.util.ArrayList;
=======
public class Admin extends User {
    public Admin(String userID, String username, String password, String email, String fullName, String phoneNo, String address, String role) {
        super(userID, username, password, email, fullName, phoneNo, address, role); //This is a test
    }
}
>>>>>>> branch 'master' of https://github.com/20033909/C206_CaseStudy.git

public class Admin extends User {
	public Admin(String userID, String username, String password, String email, String fullName, String phoneNo,
			String address, String role) {
		super(userID, username, password, email, fullName, phoneNo, address, role);
	}

	public static void deleteParent(ArrayList<User> users, String usernameToDelete) {
		boolean parentDeleted = false;

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user instanceof Parent && user.getUsername().equalsIgnoreCase(usernameToDelete)) {
				users.remove(i);
				parentDeleted = true;
				break;
			}
		}

		if (parentDeleted) {
			System.out.println("Parent/guardian deleted successfully!");
		} else {
			System.out.println("Parent/guardian not found.");
		}
	}

}
