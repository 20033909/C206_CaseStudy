package Test1Tests;
import static org.junit.Assert.*;
import Test1.Vendor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddVendorTests {
	
	private Vendor v1;
	
    @Before
    public void setUp() throws Exception {
    	v1 = new Vendor("Vendor1", 123456781, "west", "vendor1@email.com", "username1", "password1");
   }
    
    	
	  @Test
	  public void testVendorPassword() { 
		  
		  String password = v1.getPassword();
		  boolean isValidPassword = true;
		  if (password.length() < 8 || !password.matches("^[a-zA-Z0-9]+$")) {
			  isValidPassword = false;
		  }
		  assertTrue("Password is 8 characters long and alphanumeric.", isValidPassword);
	  }
	  
	  @Test
	  public void testVendorName() { 
		  String name = v1.getName();
		  boolean isValidName = true;
		  if (name.length() > 50) {
			  isValidName = false;
		  }
		  assertTrue("Name is within 50 characters.", isValidName);
	  }
	  
	  @Test
	  public void testVendorEmail() { 
		  String email = v1.getEmail();
		  boolean isValidEmail = true;
		  isValidEmail = email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$");	  
		  assertTrue("Email is valid.", isValidEmail);
	  }
}