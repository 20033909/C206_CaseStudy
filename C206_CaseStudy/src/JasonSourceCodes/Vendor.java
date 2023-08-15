package JasonSourceCodes;
import java.util.ArrayList;

public class Vendor {
    private String name;
    private int mobileNumber;
    private String distributionRegion;
    private String email;
    private String username;
    private String password;
    private ArrayList<Menu> menu;

    // Constructors
    public Vendor(String name, int mobileNumber, String distributionRegion, String email, String username, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.distributionRegion = distributionRegion;
        this.email = email;
        this.username = username;
        this.password = password;
        this.menu = new ArrayList<>();
    }

    // Getters and setters for attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDistributionRegion() {
        return distributionRegion;
    }

    public void setDistributionRegion(String distributionRegion) {
        this.distributionRegion = distributionRegion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addMenuItem(Menu item) {
        menu.add(item);
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }
}