package JocelynTest;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JocelynSourceCode.C206_CaseStudy;
import JocelynSourceCode.Menu;
import JocelynSourceCode.Vendor;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class C206_CaseStudyTest {
	
    private Vendor vendor;
    
    public C206_CaseStudyTest() {
        super();
    }

    
    @Before
    public void setUp() throws Exception {
        vendor = new Vendor("", "vendor", "vendor123", "vendor@gmail.com", "Vendor One", "81234567", "blk 123 Jurong West st 12", "Vendor");
    }

    
    @Test
    public void testAddNewMenu() {

    	//  Normal case: To ensure that vendor has no menu
        assertEquals("Vendor has no menus", 0, vendor.getDailyMenus().size());

        // To test whether can add a new menu or not (normal case)
        C206_CaseStudy.addNewMenu(vendor, "Pasta", "Fish n Chip Spaghetti", 5.00);

        // Check whether the menu has been added successfully or not
        assertEquals("Vendor should have 1 menu after adding", 1, vendor.getDailyMenus().size());
        assertEquals("Menu name should match", "Pasta", vendor.getDailyMenus().get(0).getItemName());
        
        
        
        
        // Boundary case: To test whether can add a new menu with the highest price (boundary condition)
        C206_CaseStudy.addNewMenu(vendor, "Lobster", "Lobster Thermidor", Double.MAX_VALUE);

        // Check whether the menu has been added successfully or not
        assertEquals("Vendor should have 2 menus after adding", 2, vendor.getDailyMenus().size());
        assertEquals("Menu price should match", Double.MAX_VALUE, vendor.getDailyMenus().get(1).getPrices(), 0.001);
        
        
        
        
        // Error case: To test adding a new menu with negative price (error condition)
        C206_CaseStudy.addNewMenu(vendor, "French Fries", "Mentai Fries", -3.50);

        // Menu has not been added due to error
        assertEquals("Vendor should still have 2 menus", 2, vendor.getDailyMenus().size());
       
    }
    
    
    @Test
    public void testViewAllMenus() {

        // Normal case: Added two menus 
        C206_CaseStudy.addNewMenu(vendor, "Pasta", "Fish n Chip Spaghetti", 5.00);
        C206_CaseStudy.addNewMenu(vendor, "French Fries", "Mentai Fries", 3.50);

        // Expected output
        String expectedOutput = "List of Menus:\n"
            + "Item Name: Pasta\nDescription: Fish n Chip Spaghetti\nPrice: 5.00\n\n"
            + "Item Name: French Fries\nDescription: Mentai Fries\nPrice: 3.50\n\n";

        // Verify whether the actual output matches the expected output or not
        assertEquals(expectedOutput, C206_CaseStudy.viewAllMenus(vendor));
           
        // Empty menu list
        String expectedEmptyOutput = "No menus available.";
        assertEquals(expectedEmptyOutput, C206_CaseStudy.viewAllMenus(vendor));
        
        // Maximum price
        C206_CaseStudy.addNewMenu(vendor, "Lobster", "Lobster Thermidor", Double.MAX_VALUE);
        String expectedMaxPriceOutput = "List of Menus:\n"
            + "Item Name: Lobster\nDescription: Lobster Thermidor\nPrice: " + Double.MAX_VALUE + "\n\n";
        assertEquals(expectedMaxPriceOutput,  C206_CaseStudy.viewAllMenus(vendor));
		
        
        
        
        
        // Boundary case (Minimum price): Test menu with the minimum price
        C206_CaseStudy.addNewMenu(vendor, "Water", "Orange Juice", 0.80);
        String expectedMinPriceOutput = "List of Menus:\n"
            + "Item Name: Water\nDescription: Orange Juice\nPrice: 0.80\n\n";
        assertEquals(expectedMinPriceOutput,  C206_CaseStudy.viewAllMenus(vendor));
        
        
        
        
        
        // Error condition (Negative price): Test menu with a negative price
        C206_CaseStudy.addNewMenu(vendor, "Ice Cream", "Strawberry ice cream", -1.50);
        String expectedErrorOutput = "Error: Menu price cannot be negative.";
        assertEquals(expectedErrorOutput,  C206_CaseStudy.viewAllMenus(vendor));
        
    }
    
    
    
    @Test
    public void testDeleteExistingMenu() {
        // Normal case: Add two menus
        C206_CaseStudy.addNewMenu(vendor, "Pasta", "Fish n Chip Spaghetti", 5.00);
        C206_CaseStudy.addNewMenu(vendor, "French Fries", "Mentai Fries", 3.50);

        // Delete the first menu
        C206_CaseStudy.deleteExistingMenu(vendor, 1);

        // Verify the number of menus is reduced by 1
        assertEquals("Test if the number of menus is reduced by 1", 1, vendor.getDailyMenus().size());

        // Verify that the deleted menu is no longer in the list
        Menu remainingMenu = vendor.getDailyMenus().get(0);
        assertEquals("Pasta", remainingMenu.getItemName());
        
        
        
        
        
        // Boundary case: Add a single menu
        C206_CaseStudy.addNewMenu(vendor, "Pasta", "Fish n Chip Spaghetti", 5.00);

        // Delete the menu
        C206_CaseStudy.deleteExistingMenu(vendor, 1);

        // Verify that the menu list is now empty
        assertTrue("Test if the menu list is empty", vendor.getDailyMenus().isEmpty());
        
        
        
        
        
        // Error case: Delete menu when the list is empty
        String expectedErrorOutput = "No menus available to delete.";
        String actualErrorOutput = C206_CaseStudy.deleteExistingMenu(vendor, 1);

        // Verify the correct error message is returned
        assertEquals("Test if the correct error message is returned", expectedErrorOutput, actualErrorOutput); 
        
    }
    
    

	@After
    public void tearDown() throws Exception {
        vendor = null;
    }
}














