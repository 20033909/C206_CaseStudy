import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddVendorTests {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidPasswordExactly8Characters() {
        //fail("Not yet implemented");
        String password = "Qwertt12";
        boolean isValid = isValidPassword(password);
        assertTrue("Password with exactly 8 alphanumeric characters should be valid", isValid);
    }

    private boolean isValidPassword(String password) {
        // Perform your password validation logic here
        return password.matches("^[a-zA-Z0-9]{8}$");
    }

    @Test
    public void testInvalidPasswordLessThan8Characters() {
        String password = "qwe12";
        boolean isValid = isValidPasswordInvalid(password);
        assertFalse("Password with less than 8 characters should be invalid", isValid);
    }

    private boolean isValidPasswordInvalid(String password) {
        // Perform your password validation logic here
        return password.matches("^[a-zA-Z0-9]{8}$");
    }
    
    //Email validation testing 
    
    @Test
    public void testValidEmailFormat() {
        String email = "abc@gmail.com";
        boolean isValid = isValidEmail(email);
        assertTrue(isValid);
    }

    @Test
    public void testInvalidEmailFormat() {
        String email = "invalid_email";
        boolean isValid = isValidEmail(email);
        assertFalse("Email should not follow the specified format", isValid);
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$");
    }
    
    
}