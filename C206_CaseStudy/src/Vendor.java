import java.util.ArrayList;
import java.util.List;

/*import java.util.ArrayList;
import java.util.List;

public class Vendor extends User {
	// Additional attributes specific to the Vendor class
	private ArrayList<Menu> dailyMenus; // List of menus offered by the vendor for each day
	private String contactInformation; // Contact information of the vendor (e.g., phone number, email)
	// You can add more attributes as needed, such as vendor ID, business address,
	// etc.

	// Constructor for Vendor class
	public Vendor(String userID, String username, String password, String email, String fullName, String phoneNo,
			String address, String role) {
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

	public ArrayList<Menu> getDailyMenus() {
		return dailyMenus;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public void setDailyMenus(ArrayList<Menu> dailyMenus2) {
		// TODO Auto-generated method stub
		dailyMenus = new ArrayList<>();
	}

	// Other methods specific to the Vendor class can be added here
}
*/
/*import java.util.List;
import java.util.ArrayList;

public class Vendor {
    private String name;
    private String description;
    private String contactEmail;
    private String phoneNumber;
    private String distributionRegion; 
    private List<String[]> menusOffered;
    
    // Constructor
    public Vendor(String name, String description, String contactEmail, String phoneNumber, String address) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
        this.distributionRegion = distributionRegion;  // Initialize the address
        this.menusOffered = new ArrayList<>();
    }
    
    // Getter and setter methods for attributes
    
    // Method to add a menu to productsOffered
    public void addMenu(String[] menu) {
        productsOffered.add(menu);
    }
    
    // Method to get all menus
    public List<String[]> getAllMenus() {
        return productsOffered;
    }
    
    // ... Other methods for modifying attributes, etc. ...
    
    // Getter method for address
    public String getAddress() {
        return address;
    }
}*/

public class Vendor extends User {
    private List<Menu> menus;  // List of menus offered by the vendor

    public Vendor(String userID, String username, String password, String email,
                  String fullName, String phoneNo, String address, String role) {
        super(userID, username, password, email, fullName, phoneNo, address, role);
        menus = new ArrayList<>();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void deleteMenu(Menu menu) {
        menus.remove(menu);
    }

    // Other methods specific to Vendor
    public String getName() {
        return fullName;
    }

    public String getDistributionRange() {
        return distributionRange;
    }
    
    public String getContactPersonName() {
        return contactPersonName;
    }
    
    public int getSchoolMobile() {
        return schoolMobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistributionRange(String distributionRange) {
        this.distributionRange = distributionRange;
    }
    
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }
    
    public void setSchoolMobile(int schoolMobile) {
        this.schoolMobile = schoolMobile;
    }
}