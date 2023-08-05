import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C206_CaseStudy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the School Lunch Box Online Ordering System!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = Helper.readInt("Please choose an option:");

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
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

    private static void login() {
        String username = Helper.readString("Enter username:");
        String password = Helper.readString("Enter password:");

        // Implement login functionality here
        // For example, validate username and password against existing users in the system
        // Based on the role of the user, redirect to the respective menu (Vendor/Parent)
    }

    private static void register() {
        // Implement registration functionality here
        // Ask the user to choose a role (Vendor/Parent) and provide necessary details
        // Create a new Vendor or Parent object based on the user's choice
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
}
