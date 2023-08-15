package Test1;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vendor Management System");
            System.out.println("1. Add Vendor");
            System.out.println("2. View Vendors");
            System.out.println("3. Delete Vendor");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addVendor(vendorManagementSystem, scanner);
                    break;
                case 2:
                    viewVendors(vendorManagementSystem);
                    break;
                case 3:
                    deleteVendor(vendorManagementSystem, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void addVendor(VendorManagementSystem vendorManagementSystem, Scanner scanner) {
        System.out.print("Enter vendor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter mobile number: ");
        int mobileNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter distribution region: ");
        String distributionRegion = scanner.nextLine();
        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (!isValidEmail(email));
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        String password;
        do {
            System.out.print("Enter password (at least 8 alphanumeric characters): ");
            password = scanner.nextLine();
            
            if (password.length() < 8 || !password.matches("^[a-zA-Z0-9]+$")) {
                System.out.println("Password must be at least 8 alphanumeric characters.");
            }
        } while (password.length() < 8 || !password.matches("^[a-zA-Z0-9]+$"));

        Vendor vendor = new Vendor(name, mobileNumber, distributionRegion, email, username, password);
        vendorManagementSystem.addVendor(vendor);

        System.out.println("Vendor added successfully.");
    }
    private static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$");
    }

   
    private static void viewVendors(VendorManagementSystem vendorManagementSystem) {
        List<Vendor> vendors = vendorManagementSystem.getVendors();

        if (vendors.isEmpty()) {
            System.out.println("No vendors available.");
        } else {
            System.out.println("List of Vendors:");
            for (Vendor vendor : vendors) {
                System.out.println("Vendor: " + vendor.getName());
                System.out.println("Contact: " + vendor.getMobileNumber());
                System.out.println("Distribution Region: " + vendor.getDistributionRegion());
                System.out.println("Email: " + vendor.getEmail());
                System.out.println("Username: " + vendor.getUsername());
                System.out.println("Password: " + vendor.getPassword());
                System.out.println("Menu Items:");

                ArrayList<Menu> menuItems = vendor.getMenu();
                if (menuItems.isEmpty()) {
                    System.out.println("No menu items available.");
                } else {
                    for (Menu menu : menuItems) {
                        System.out.println("Menu:");
                        ArrayList<String> items = menu.getItems();
                        for (String item : items) {
                            System.out.println("- " + item);
                        }
                    }
                }

                System.out.println();
            }
        }
    }

    public static void deleteVendor(VendorManagementSystem vendorManagementSystem, Scanner scanner) {
        List<Vendor> vendors = vendorManagementSystem.getVendors();

        if (vendors.isEmpty()) {
            System.out.println("No vendors available.");
            return;
        }
        
        System.out.println("List of Vendors:");
        for (int i = 0; i < vendors.size(); i++) {
            System.out.println((i + 1) + ". Vendor: " + vendors.get(i).getName() + ", Contact: " + vendors.get(i).getMobileNumber());
        }

        System.out.print("Enter the number of the vendor to delete: ");
        int vendorNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (vendorNumber >= 1 && vendorNumber <= vendors.size()) {
            Vendor vendorToDelete = vendors.get(vendorNumber - 1);

            // Confirmation prompt
            System.out.print("Are you sure you want to delete " + vendorToDelete.getName() + "? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                vendorManagementSystem.deleteVendor(vendorToDelete);
                System.out.println("Vendor deleted successfully.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Invalid vendor number.");
        }
    }
}