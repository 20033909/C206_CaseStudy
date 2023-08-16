import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class C206_CaseStudyTest {

    private List<School> schools;
    private Admin admin;

    @Before
    public void setUp() throws Exception {
        schools = new ArrayList<>();
        admin = new Admin("admin123", "admin", "password", "admin@example.com", "Admin User", "12345678", "123 Main St", "Admin");
    }

    @Test
    public void testAddSchools() {
        assertEquals("Test if schoolList is empty before adding", 0, schools.size());

        // Normal Condition Test
        C206_CaseStudy.addSchools(schools);
        assertEquals("Test if schoolList size is 1 after adding", 1, schools.size());
        assertEquals("Test if the added school name matches", "Test School", schools.get(0).getName());

        // Boundary Condition Test
        School schoolWithNullName = new School(null, "Test Range");
        schools.add(schoolWithNullName); // Directly add the school object to the list
        assertEquals("Test if schoolList size remains 1 after adding duplicate", 1, schools.size());

        // Error Condition Test (adding with null name)
        C206_CaseStudy.addSchools(schools);
        assertEquals("Test if schoolList size remains 1 after adding with null name", 2, schools.size());
    }
    
    @Test
    public void testViewAllSchools() {
        // Normal Condition Test: Add two schools and view the list
        School school1 = new School("School A", "Range A");
        School school2 = new School("School B", "Range B");
        schools.add(school1);
        schools.add(school2);

        // Call the method to view all schools
        C206_CaseStudy.viewAllSchools(schools);

        // Assertion: Check if the schoolList size matches the expected result
        assertEquals("Test if schoolList size is 2 after adding two schools", 2, schools.size());

        // Boundary Condition Test: Viewing the first school in the system when there is only one school registered
        // Assuming the viewAllSchools method prints the details of the schools to the console
        C206_CaseStudy.viewAllSchools(schools);

        // Assertion: Check if the schoolList size remains the same after viewing
        assertEquals("Test if schoolList size remains 2 after viewing first school", 2, schools.size());

        // Error Condition Test: View the list of schools
        C206_CaseStudy.viewAllSchools(schools);

        // Assertion: Check if the schoolList size remains the same after viewing
        assertEquals("Test if schoolList size remains 2 after viewing", 2, schools.size());
    }
    
    @Test
    public void testDeleteSchools() {
        // Normal Condition Test: Delete a school that exists from the list
        School school1 = new School("School A", "Range A");
        School school2 = new School("School B", "Range B");
        schools.add(school1);
        schools.add(school2);

        // Deleting School A
        C206_CaseStudy.deleteSchools(schools);
        assertEquals("Test if schoolList size is 1 after deleting", 1, schools.size());
        assertFalse("Test if School A is deleted successfully", schools.contains(school1));

        // Boundary Condition Test: Delete a school from an empty list of schools
        C206_CaseStudy.deleteSchools(schools);
        assertEquals("Test if schoolList size remains 1 after deleting from empty list", 1, schools.size());

        // Error Condition Test: Delete a school that does not exist in the list
        C206_CaseStudy.deleteSchools(schools);
        assertEquals("Test if schoolList size remains 1 after deleting non-existing school", 1, schools.size());
    }
    
    @After
    public void tearDown() throws Exception {
        schools = null;
        admin = null;
    }

}
