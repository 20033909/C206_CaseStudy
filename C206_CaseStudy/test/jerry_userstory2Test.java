import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class jerry_userstory2Test { //test edit

    private static final String TABLE_HEADER =
            "--------------------------------------------------------------------------------------------\n" +
            "| User ID  | Full Name       | Username        | Phone Number    | Dietary Restr.     |\n" +
            "--------------------------------------------------------------------------------------------";

    @Test
    public void testDisplayRegisteredParentsAndGuardians() {
        List<User> users = new ArrayList<>();
        Parent parent1 = new Parent("P001", "parent1", "password123", "parent1@example.com", "Parent One", "98765432",
                "123 Parent Street", "Parent", new ArrayList<>(), "");
        Parent parent2 = new Parent("P002", "parent2", "password456", "parent2@example.com", "Parent Two", "87654321",
                "456 Parent Road", "Parent", new ArrayList<>(), "");
        users.add(parent1);
        users.add(parent2);

        // Capture the console output for assertion
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        C206_CaseStudy.displayRegisteredParents(users);

        // Restore original System.out
        System.setOut(System.out);

        String expectedOutput = TABLE_HEADER +
                "\n| %-10s | %-15s | %-15s | %-15s | %-18s |\n" +
                "--------------------------------------------------------------------------------------------\n";

        String parent1Row = "| P001      | Parent One      | parent1        | 98765432       |                  |\n";
        String parent2Row = "| P002      | Parent Two      | parent2        | 87654321       |                  |\n";

        expectedOutput += parent1Row + parent2Row;

        assertEquals(String.format(expectedOutput, "User ID", "Full Name", "Username", "Phone Number", "Dietary Restr."),
                outputStream.toString());
    }

    @Test
    public void testDisplayNoParentsAndGuardians() {
        List<User> users = new ArrayList<>();

        // Capture the console output for assertion
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        C206_CaseStudy.displayRegisteredParents(users);

        // Restore original System.out
        System.setOut(System.out);

        String expectedOutput = TABLE_HEADER +
                "\n--------------------------------------------------------------------------------------------\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDisplayMultipleRecords() {
        List<User> users = new ArrayList<>();
        Parent parent1 = new Parent("P001", "parent1", "password123", "parent1@example.com", "Parent One", "98765432",
                "123 Parent Street", "Parent", new ArrayList<>(), "");
        Parent parent2 = new Parent("P002", "parent2", "password456", "parent2@example.com", "Parent Two", "87654321",
                "456 Parent Road", "Parent", new ArrayList<>(), "");
        users.add(parent1);
        users.add(parent2);

        // Capture the console output for assertion
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        C206_CaseStudy.displayRegisteredParents(users);

        // Restore original System.out
        System.setOut(System.out);

        String expectedOutput = TABLE_HEADER +
                "\n| %-10s | %-15s | %-15s | %-15s | %-18s |\n" +
                "--------------------------------------------------------------------------------------------\n";

        String parent1Row = "| P001      | Parent One      | parent1        | 98765432       |                  |\n";
        String parent2Row = "| P002      | Parent Two      | parent2        | 87654321       |                  |\n";

        expectedOutput += parent1Row + parent2Row;

        assertEquals(String.format(expectedOutput, "User ID", "Full Name", "Username", "Phone Number", "Dietary Restr."),
                outputStream.toString());
    }
}
