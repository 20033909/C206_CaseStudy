import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeleteVendorTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testRemoveVendor_Success() {
        // Arrange
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        Vendor vendor = new Vendor("Vendor123", "1234567890", "Region A", "vendor@example.com", "vendoruser", "password123");
        vendorManagementSystem.addVendor(vendor);

        // Act
        vendorManagementSystem.deleteVendor(vendor);

        // Assert
        assertFalse(vendorManagementSystem.getVendors().contains(vendor));
    }
	
	@Test
	public void testDeleteNonExistentVendor() {
	    // Arrange
	    VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
	    Vendor vendor = new Vendor("Vendor123", "1234567890", "Region A", "vendor@example.com", "vendoruser", "password123");

	    // Act
	    vendorManagementSystem.deleteVendor(vendor);

	    // Assert
	    assertFalse("No such vendor exist!", vendorManagementSystem.getVendors().contains(vendor));
	}
	@Test
    public void testDeleteVendorWithAssociatedData() {
        // Arrange
        VendorManagementSystem vendorManagementSystem = new VendorManagementSystem();
        Vendor vendor = new Vendor("Vendor123", "1234567890", "Region A", "vendor@example.com", "vendoruser", "password123");
        Menu menu = new Menu();
        menu.addItem("Item1");
        vendor.addMenu(menu);
        vendorManagementSystem.addVendor(vendor);

        // Act
        boolean deleted = vendorManagementSystem.removeVendor(vendor);

        // Assert
        assertFalse(deleted);
        assertTrue(vendorManagementSystem.getVendors().contains(vendor));
    }
	





}
