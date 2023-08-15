import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class jerry_userstory3Test {

	private ArrayList<User> users;
	List<String> childrenIds = new ArrayList<>(); // Make sure you use the correct type for childrenIds
	List<String> allergies = new ArrayList<>();

	@Before
	public void setUp() {
		users = new ArrayList<>();
		// Initialize users as needed for testing
	}

	@Test
	public void testDeleteExistingParent() {
		// Create a parent/guardian and add them to the users list
		Parent parent = new Parent("userID", "parentUsername", "password", "email", "fullName", "phoneNo", "address",
				"role", allergies, "dietaryRestrictions");
		users.add(parent);

		// Call the deleteParent method to delete the parent
		Admin.deleteParent(users, "parentUsername");

		// Ensure that the parent is successfully deleted
		assertTrue("Parent should be deleted", users.isEmpty());
	}

	@Test
	public void testDeleteNonExistingParent() {
		// Call the deleteParent method with a non-existing username
		Admin.deleteParent(users, "nonExistingUsername");

		// Ensure that the parent is not deleted and the list remains unchanged
		assertTrue("Parent should not be deleted", users.isEmpty());
	}

	@Test
	public void testDeleteExistingParentCaseInsensitive() {
		// Create a parent/guardian and add them to the users list
		Parent parent = new Parent("userID", "parentUsername", "password", "email", "fullName", "phoneNo", "address",
				"role", allergies, "dietaryRestrictions");
		users.add(parent);

		// Call the deleteParent method with different case variations of the username
		Admin.deleteParent(users, "PARENTUSERNAME");
		Admin.deleteParent(users, "ParentUsername");
		Admin.deleteParent(users, "parentusername");

		// Ensure that the parent is successfully deleted in all case variations
		assertTrue("Parent should be deleted (case-insensitive)", users.isEmpty());
	}
}
