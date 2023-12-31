
//Test codes for user story 1. test editt
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class jerry_userStory1Test {

	private List<User> userList;
	private List<School> schoolList;
	private Admin admin;

	@Before
	public void setUp() throws Exception {
		userList = new ArrayList<>();
		schoolList = new ArrayList<>();
		admin = new Admin("admin123", "admin", "password", "admin@example.com", "Admin User", "12345678", "123 Main St",
				"Admin");
	}

	@After
	public void tearDown() throws Exception {
		userList = null;
		schoolList = null;
		admin = null;
	}

	@Test
	public void testRegisterParent_Success() {
		String username = "testparent";
		String password = "testpassword";
		String email = "test@example.com";
		String fullName = "Test Parent";
		String phoneNo = "12345678";
		String address = "123 Test Street";
		int roleChoice = 1; // Role choice for Parent

		C206_CaseStudy.register(userList);

		// Check that the parent was added to the userList
		User registeredUser = userList.get(0);
		assertTrue(registeredUser instanceof Parent);
		assertEquals(username, registeredUser.getUsername());
		assertEquals(email, registeredUser.getEmail());
	}

	@Test
	public void testRegisterVendor_Success() {
		String username = "testvendor";
		String password = "testpassword";
		String email = "test@example.com";
		String fullName = "Test Vendor";
		String phoneNo = "12345678";
		String address = "123 Test Street";
		int roleChoice = 2; // Role choice for Vendor

		C206_CaseStudy.register(userList);

		// Check that the vendor was added to the userList
		User registeredUser = userList.get(0);
		assertTrue(registeredUser instanceof Vendor);
		assertEquals(username, registeredUser.getUsername());
		assertEquals(email, registeredUser.getEmail());
	}

	@Test
	public void testRegisterAdmin_Success() {
		String username = "testadmin";
		String password = "testpassword";
		String email = "test@example.com";
		String fullName = "Test Admin";
		String phoneNo = "12345678";
		String address = "123 Test Street";
		int roleChoice = 3; // Role choice for Admin

		C206_CaseStudy.register(userList);

		// Check that the admin was added to the userList
		User registeredUser = userList.get(0);
		assertTrue(registeredUser instanceof Admin);
		assertEquals(username, registeredUser.getUsername());
		assertEquals(email, registeredUser.getEmail());
	}

}
