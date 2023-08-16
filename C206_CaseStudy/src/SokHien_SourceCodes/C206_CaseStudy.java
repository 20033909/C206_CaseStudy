import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C206_CaseStudy {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();
		ArrayList<School> schools = new ArrayList<>();

		while (true) {
			System.out.println("Welcome to the School Lunch Box Online Ordering System!");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			int choice = Helper.readInt("Please choose an option:");

			switch (choice) {
			case 1:
				login(users, schools);
				break;
			case 2:
				register(users);
				break;
			case 3:
				System.out.println("Thank you for using our system. Goodbye!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	public static void login(List<User> users, List<School> schools) {
		String username = Helper.readString("Enter username:");
		String password = Helper.readString("Enter password:");

		User user = findUserByUsername(users, username);
		if (user != null && user.getPassword().equals(password)) {
			handleUserType(user, schools);
		} else {
			System.out.println("Invalid username or password. Please try again.");
		}
	}

	public static void handleUserType(User user, List<School> schools) {
		if (user instanceof Parent) {
			System.out.println("Welcome, Parent " + user.getFullName());
			// Call parent menu here
		} else if (user instanceof Vendor) {
			System.out.println("Welcome, Vendor " + user.getFullName());
			// Call vendor menu here
		} else if (user instanceof Admin) {
			System.out.println("Welcome, Admin " + user.getFullName());
			adminMenu(schools); // Call admin menu here
		}
	}

	public static void register(List<User> users) {
		String username = Helper.readString("Enter a username:");
		String password = Helper.readString("Enter a password:");
		String email = Helper.readString("Enter your email:");
		String fullName = Helper.readString("Enter your full name:");
		String phoneNo = Helper.readString("Enter your phone number:");
		String address = Helper.readString("Enter your address:");

		System.out.println("Choose a role:");
		System.out.println("1. Parent");
		System.out.println("2. Vendor");
		System.out.println("3. Admin");
		int roleChoice = Helper.readInt("Enter your choice:");

		if (roleChoice == 1) {
			List<Integer> childrenIds = new ArrayList<>();
			List<String> allergies = new ArrayList<>();
			String dietaryRestrictions = Helper.readString("Enter your dietary restrictions:");

			Parent parent = new Parent("", username, password, email, fullName, phoneNo, address, "Parent", childrenIds,
					new ArrayList<>(allergies), dietaryRestrictions);

			users.add(parent); // Add parent to your user database
			System.out.println("Parent registered successfully!");
		} else if (roleChoice == 2) {
			Vendor vendor = new Vendor("", username, password, email, fullName, phoneNo, address, "Vendor");
			users.add(vendor); // Add vendor to your user database
			System.out.println("Vendor registered successfully!");
		} else if (roleChoice == 3) {
			Admin admin = new Admin("adminID", username, password, email, fullName, phoneNo, address, "Admin");
			users.add(admin); // Add admin to your user database
			System.out.println("Admin registered successfully!");
		} else {
			System.out.println("Invalid choice. Registration canceled.");
		}
	}

	public static User findUserByUsername(List<User> users, String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public static void adminMenu(List<School> schools) {
		while (true) {
			System.out.println("Admin Menu:");
			System.out.println("1. Add School");
			System.out.println("2. View All Schools");
			System.out.println("3. Delete School");
			System.out.println("4. Logout");
			int choice = Helper.readInt("Please choose an option:");

			switch (choice) {
			case 1:
				addSchools(schools);
				break;
			case 2:
				viewAllSchools(schools);
				break;
			case 3:
				deleteSchools(schools);
				break;
			case 4:
				System.out.println("Logging out from admin account.");
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	public static void addSchools(List<School> schools) {
		String name = Helper.readString("Enter school name:");
		if (name != null) {
			String distributionRange = Helper.readString("Enter distribution range:");
			School school = new School(name, distributionRange);
			schools.add(school);
			System.out.println("School added successfully!");
		} else {
			System.out.println("Cannot add school with null name.");
		}
	}

	public static void viewAllSchools(List<School> schools) {
		System.out.println("List of Schools:");
		for (School school : schools) {
			System.out.println("School Name: " + school.getName());
			System.out.println("Distribution Range: " + school.getDistributionRange());
			System.out.println();
		}
	}

	public static void deleteSchools(List<School> schools) {

	       viewAllSchools(schools);
	    String nameToDelete = Helper.readString("Enter the name of the school to delete:");
	    School schoolToDelete = findSchoolByName(schools, nameToDelete);
	    if (schoolToDelete != null) {
	        schools.remove(schoolToDelete);
	        System.out.println("School deleted successfully!");
	    } else {
	        System.out.println("School not found.");
	    }
	}
	public static School findSchoolByName(List<School> schools, String name) {
	    for (School school : schools) {
	        if (school.getName().equalsIgnoreCase(name)) {
	            return school;
	        }
	    }
	    return null;
	}
}
