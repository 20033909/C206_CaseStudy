import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;



public class ViewVendorTests {
	private Vendor v1;
	private Vendor v2;
	private Vendor v3;
	private Vendor v4;

	private ArrayList<Vendor> vendorList;


	@Before
	public void setUp() throws Exception {
		// prepare test data
		v1 = new Vendor("Ah Seng", "west", "abc@gm.com", "AhSeng", "12345678");
		
		

		vendorList = new ArrayList<Vendor>();
		
	}


    @Test
    public void testViewAllVendors() {
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        List<Vendor> vendors = createSampleVendors(); // Create sample vendors for testing

        for (Vendor vendor : vendors) {
            vendorManagementSystem.addVendor(vendor);
        }

        List<Vendor> retrievedVendors = vendorManagementSystem.getVendors();
        assertEquals("Number of retrieved vendors should match the number of added vendors", vendors.size(), retrievedVendors.size());

        for (int i = 0; i < vendors.size(); i++) {
            Vendor expectedVendor = vendors.get(i);
            Vendor retrievedVendor = retrievedVendors.get(i);
            assertEquals("Vendor name should match", expectedVendor.getName(), retrievedVendor.getName());
            assertEquals("Mobile number should match", expectedVendor.getMobileNumber(), retrievedVendor.getMobileNumber());
            // Repeat similar assertions for other attributes as needed
        }
    }

    @Test
    public void testEmptyVendorList() {
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        List<Vendor> retrievedVendors = vendorManagementSystem.getVendors();
        assertTrue("Vendor list should be empty", retrievedVendors.isEmpty());
    }

    private List<Vendor> createSampleVendors() {
        // Create and return a list of sample vendors for testing
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor("Vendor1", "1234567890", "Region1", "vendor1@example.com", "user1", "password1"));
        vendors.add(new Vendor("Vendor2", "9876543210", "Region2", "vendor2@example.com", "user2", "password2"));
        // Add more sample vendors as needed
        return vendors;
    }
}
/*
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

// Import the Vendor class
import your.package.name.Vendor; // Replace "your.package.name" with the actual package name

public class ViewVendorTests {

    @Test
    public void testViewAllVendors() {
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        List<Vendor> vendors = createSampleVendors(); // Create sample vendors for testing

        for (Vendor vendor : vendors) {
            vendorManagementSystem.addVendor(vendor);
        }

        List<Vendor> retrievedVendors = vendorManagementSystem.getVendors();
        assertEquals("Number of retrieved vendors should match the number of added vendors", vendors.size(), retrievedVendors.size());

        for (int i = 0; i < vendors.size(); i++) {
            Vendor expectedVendor = vendors.get(i);
            Vendor retrievedVendor = retrievedVendors.get(i);
            assertEquals("Vendor name should match", expectedVendor.getName(), retrievedVendor.getName());
            assertEquals("Mobile number should match", expectedVendor.getMobileNumber(), retrievedVendor.getMobileNumber());
            // Repeat similar assertions for other attributes as needed
        }
    }

    @Test
    public void testEmptyVendorList() {
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        List<Vendor> retrievedVendors = vendorManagementSystem.getVendors();
        assertTrue("Vendor list should be empty", retrievedVendors.isEmpty());
    }

    @Test
    public void testViewSingleVendor() {
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        Vendor vendor = new Vendor("VendorX", "9998887777", "RegionX", "vendorX@example.com", "userX", "passwordX");
        vendorManagementSystem.addVendor(vendor);

        List<Vendor> retrievedVendors = vendorManagementSystem.getVendors();
        assertEquals("Number of retrieved vendors should be 1", 1, retrievedVendors.size());

        Vendor retrievedVendor = retrievedVendors.get(0);
        assertEquals("Vendor name should match", vendor.getName(), retrievedVendor.getName());
        assertEquals("Mobile number should match", vendor.getMobileNumber(), retrievedVendor.getMobileNumber());
        // Repeat similar assertions for other attributes as needed
    }

    private List<Vendor> createSampleVendors() {
        // Create and return a list of sample vendors for testing
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor("Vendor1", "1234567890", "Region1", "vendor1@example.com", "user1", "password1"));
        vendors.add(new Vendor("Vendor2", "9876543210", "Region2", "vendor2@example.com", "user2", "password2"));
        // Add more sample vendors as needed
        return vendors;
    }
}
*/