public class Vendor extends User {
    // Additional attributes specific to the Vendor class
    private List<Menu> dailyMenus; // List of menus offered by the vendor for each day
    private String contactInformation; // Contact information of the vendor (e.g., phone number, email)
    // You can add more attributes as needed, such as vendor ID, business address, etc.

    // Constructor for Vendor class
    public Vendor(String userID, String username, String password, String email, String fullName, String phoneNo, String address, String role) {
        super(userID, username, password, email, fullName, phoneNo, address, role); // Set the role dynamically
        dailyMenus = new ArrayList<>();
        contactInformation = "";
    }

    // Additional methods for Vendor class (if needed)
    public void addMenu(Menu menu) {
        dailyMenus.add(menu);
    }

    public void removeMenu(Menu menu) {
        dailyMenus.remove(menu);
    }

    public List<Menu> getDailyMenus() {
        return dailyMenus;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    // Other methods specific to the Vendor class can be added here
}
