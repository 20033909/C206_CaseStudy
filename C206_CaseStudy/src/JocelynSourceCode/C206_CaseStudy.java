package JocelynSourceCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C206_CaseStudy {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    login(users,schools);
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

    private static void login(List<User> users,List<School> schools) {
        String username = Helper.readString("Enter username:");
        String password = Helper.readString("Enter password:");

        User user = findUserByUsername(users, username);
        if (user != null && user.getPassword().equals(password)) {
            if (user instanceof Parent) {
                System.out.println("Welcome, Parent " + user.getFullName());
                // Call parent menu here
            } else if (user instanceof Vendor) {
                System.out.println("Welcome, Vendor " + user.getFullName());
                vendorMenu((Vendor) user);// Call vendor menu here
            } else if (user instanceof Admin) {
                System.out.println("Welcome, Admin " + user.getFullName());
                adminMenu(schools); // Call admin menu here
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    

    private static void register(List<User> users) {
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
               
              Parent parent = new Parent("", username, password, email, fullName, phoneNo, address, "Parent", childrenIds, new ArrayList<>(allergies), dietaryRestrictions);
              users.add(parent);  // Add parent to your user database 
              System.out.println("Parent registered successfully!"); 
          } 
          else if (roleChoice == 2) { 
              Vendor vendor = new Vendor("", username, password, email, fullName, phoneNo, address, "Vendor"); 
              users.add(vendor);  // Add vendor to your user database 
              System.out.println("Vendor registered successfully!"); 
          } 
          else if (roleChoice == 3) { 
            Admin admin = new Admin("adminID", username, password, email, fullName, phoneNo, address, "Admin");
              users.add(admin);  // Add admin to your user database 
              System.out.println("Admin registered successfully!"); 
          } 
          else { 
              System.out.println("Invalid choice. Registration canceled."); 
          } 
      } 
    
    private static User findUserByUsername(List<User> users, String username) { 
        for (User user : users) { 
            if (user.getUsername().equals(username)) { 
                return user; 
            } 
        } 
        return null; 
    } 

    private static void adminMenu(List<School> schools) {
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

    private static void addSchools(List<School> schools) {
       String name = Helper.readString("Enter school name:");
         String distributionRange = Helper.readString("Enter distribution range:");
         School school = new School(name, distributionRange);
         schools.add(school);
         System.out.println("School added successfully!");
    }

    private static void viewAllSchools(List<School> schools) {
      System.out.println("List of Schools:");
        for (School school : schools) {
            System.out.println("School Name: " + school.getName());
            System.out.println("Distribution Range: " + school.getDistributionRange());
            System.out.println();
        }
    }

    private static void deleteSchools(List<School> schools) {
      viewAllSchools(schools);
        String nameToDelete = Helper.readString("Enter the name of the school to delete:");
        School schoolToDelete = null;
        for (School school : schools) {
            if (school.getName().equalsIgnoreCase(nameToDelete)) {
                schoolToDelete = school;
                break;
            }
        }
        if (schoolToDelete != null) {
            schools.remove(schoolToDelete);
            System.out.println("School deleted successfully!");
        } else {
            System.out.println("School not found.");
        }
    }
     

  
    public static void vendorMenu(Vendor vendor) {
    	while (true) {
    		vendorOption();
            int choice = Helper.readInt("Please choose an option:");

            if (choice == 1) {
                String itemName = Helper.readString("Enter menu item name:");
                String description = Helper.readString("Enter menu item description:");
                double price = Helper.readDouble("Enter menu item price:");
                addNewMenu(vendor, itemName, description, price);
            }
            else if (choice == 2) {
            	System.out.println(viewAllMenus(vendor));
            } 
            else if (choice == 3) {
                int j = 1;
                deleteExistingMenu(vendor, j);
            } 
            else if (choice == 4) {
                System.out.println("Logging out from vendor account.");
                return;
            } 
            else {
                System.out.println("Invalid option. Please try again.");
            }
           }
       }

	public static void vendorOption() {
		System.out.println("Vendor Menu:");
		System.out.println("1. Add Menu");
		System.out.println("2. View Menus");
		System.out.println("3. Delete Menu");
		System.out.println("4. Logout");
	}
        
        
        

    // Additional code for demonstrating functionalities
    private static void demonstrateFunctionalities() {
        // Create instances of Parent and Vendor objects
        Parent parent1 = new Parent("P001", "parent1", "password123", "parent1@example.com", "Parent One", "98765432", "123 Parent Street", "Parent",new ArrayList<>(), new ArrayList<>(), "");
        Vendor vendor1 = new Vendor("V001", "vendor1", "password456", "vendor1@example.com", "Vendor One", "87654321", "456 Vendor Road", "Vendor");
     // Set additional attributes for Parent and Vendor objects
        List<Integer> childrenIds = new ArrayList<>();
        childrenIds.add(1);
        childrenIds.add(2);
        parent1.setChildrenIds(childrenIds);

        List<String> allergies = new ArrayList<>();
        allergies.add("Peanuts");
        allergies.add("Lactose");
        parent1.setAllergies(allergies);

        String dietaryRestrictions = "Vegetarian";
        parent1.setDietaryRestrictions(dietaryRestrictions);

        ArrayList<Menu> dailyMenus = new ArrayList<>();
        Menu menu1 = new Menu("Menu1", "Delicious menu for Monday", 5.99);
        Menu menu2 = new Menu("Menu2", "Special menu for Tuesday", 6.99);
        dailyMenus.add(menu1);
        dailyMenus.add(menu2);
        vendor1.setDailyMenus(dailyMenus);

        String contactInformation = "Phone: 98765432, Email: vendor1@example.com";
        vendor1.setContactInformation(contactInformation);

        // Demonstrate some functionalities
        // For example, print the parent's children IDs and dietary restrictions
        System.out.println("Parent's Children IDs: " + parent1.getChildrenIds());
        System.out.println("Parent's Dietary Restrictions: " + parent1.getDietaryRestrictions());

        // Print the vendor's daily menus
        List<Menu> vendorMenus = vendor1.getDailyMenus();
        for (Menu menu : vendorMenus) {
            System.out.println("Menu Name: " + menu.getItemName());
            System.out.println("Description: " + menu.getDescription());
            System.out.println("Price: " + menu.getPrices());
        }
    }
    
    
    
  //================================= Option 1 Add new menu (CRUD - Create) =================================
    
    // Method to let vendor to add new menus
	public static void addNewMenu(Vendor vendor, String itemName, String description, double price) {
		
		if (price < 0) {
			 System.out.println("Error: The menu price cannot be negative.");
		     return; 
		}
		
        Menu newMenu = new Menu(itemName, description, price);
        vendor.addMenu(newMenu);

        System.out.println("New menu added successfully!");
		
	}
	
	
	//================================= Option 2 View all new menu (CRUD - Retrieve) ===========================
	
	// Method to let vendor to view all menus
	public static String viewAllMenus(Vendor vendor) {
	    List<Menu> menus = vendor.getDailyMenus();
	    
	    if (menus.isEmpty()) {
	        return "No menus available.";
	    }
	    
	    StringBuilder output = new StringBuilder("List of Menus:\n");
	    
	    for (int i = 0; i < menus.size(); i++) {
	        Menu menu = menus.get(i);
	        output.append("Item Name: ").append(menu.getItemName()).append("\n");
	        output.append("Description: ").append(menu.getDescription()).append("\n");
	        output.append("Price: ").append(menu.getPrices()).append("\n");
	        output.append("\n");
	    }
	    
	    return output.toString();
	}
    
    
    
  //================================= Option 3 Delete new menu (CRUD - Delete) =================================

    
	 // Method to let vendor to delete an existing menu
	 public static String deleteExistingMenu(Vendor vendor, int j) {
	        List<Menu> menus = vendor.getDailyMenus();
	
	        if (menus.isEmpty()) {
	            System.out.println("No menus available to delete.");
	            return "No menus available to delete.";
	        }
	
	        System.out.println("List of Menus:");
	        for (int i = 0; i < menus.size(); i++) {
	            Menu menu = menus.get(i);
	            System.out.println((i + j) + ". " + menu.getItemName());
	        }
	
	        int choice = Helper.readInt("Enter the number of the menu to delete:");
	        if (choice >= 1 && choice <= menus.size()) {
	            Menu deletedMenu = menus.remove(choice - j);
	            System.out.println("Menu '" + deletedMenu.getItemName() + "' deleted successfully!");
	        } else {
	            System.out.println("Invalid menu choice.");
	        }
			return null;
	    }


}
