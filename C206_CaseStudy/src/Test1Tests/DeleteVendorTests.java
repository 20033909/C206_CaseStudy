package Test1Tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeleteVendorTests {

	private Vendor v1;
	private Vendor v2;
	private Vendor v3;
	private Vendor v4;
	private Vendor v5;
VendorManagementSystem Vms = new VendorManagementSystem();

    @Before
    public void setUp() throws Exception {
    	v1 = new Vendor("Vendor1", 123456781, "west", "vendor1@email.com", "username1", "password1");
    	v2 = new Vendor("Vendor2", 123456782, "south","vendor2@email.com", "username2", "password2");
    	v3 = new Vendor("Vendor3", 123456783, "east", "vendor3@email.com", "username3", "password3");
    	v4 = new Vendor("Vendor4", 123456784, "west", "vendor4@email.com", "username4", "password4");   }
    

    @Test
	  public void testSimpleDeleteVendor() { 
		  	Vms.addVendor(v1);
	    	Vms.addVendor(v2);
	    	Vms.addVendor(v3);
	    	Vms.addVendor(v4);
	      	assertEquals(4, Vms.getVendors().size());
	      	
	    	Vms.deleteVendor(v1);
	    	assertEquals(3, Vms.getVendors().size());
	  }
	  
	  @Test
	  public void testDeleteVendorNotInList() { 
		  	Vms.addVendor(v1);
	    	Vms.addVendor(v2);
	    	Vms.addVendor(v3);
	    	Vms.addVendor(v4);
	     	assertEquals(4, Vms.getVendors().size());
	     	
	    	v5  = new Vendor("Vendor5", 123456785, "west", "vendor5@email.com", "username5", "password5");
	    	Vms.deleteVendor(v5);
	    	assertEquals(4, Vms.getVendors().size());
	  }
	  
	  @Test
	  public void testDeleteVendorTwice() { 
		  	Vms.addVendor(v1);
	    	Vms.addVendor(v2);
	    	Vms.addVendor(v3);
	    	Vms.addVendor(v4);
	    	assertEquals(4, Vms.getVendors().size());
	    	
	    	Vms.deleteVendor(v4);
	    	assertEquals(3, Vms.getVendors().size());
	    	
	    	Vms.deleteVendor(v4);
	    	assertEquals(3, Vms.getVendors().size()); 
	  }
	  
}
