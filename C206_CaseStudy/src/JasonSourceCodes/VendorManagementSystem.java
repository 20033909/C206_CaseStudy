package JasonSourceCodes;
import java.util.ArrayList;
import java.util.List;

public class VendorManagementSystem {
    // List to store vendors
    private List<Vendor> vendors;

    // Constructor to initialize the list of vendors
    public VendorManagementSystem() {
        vendors = new ArrayList<>();
    }

    // Method to add a vendor to the system
    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
    }

    // Method to retrieve a list of all vendors in the system
    public List<Vendor> getVendors() {
        return vendors;
    }

    // Method to delete a vendor from the system
    public void deleteVendor(Vendor vendor) {
        
    	vendors.remove(vendor);

    }


}