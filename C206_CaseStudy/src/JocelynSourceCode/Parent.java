package JocelynSourceCode;
import java.util.ArrayList;
import java.util.List;
//comments
public class Parent extends User {
    private String dietaryRestrictions;
    private List<Integer> childrenIds; // List of child IDs associated with the parent
    private List<String> allergies; // List of food allergies the parent wants to inform about

    // Constructor for Parent class
    public Parent(String userID, String username, String password, String email, String fullName, String phoneNo, String address, String role, List<Integer> childrenIds, ArrayList<String> allergies, String dietaryRestrictions) {
        super(userID, username, password, email, fullName, phoneNo, address, role);
        this.childrenIds = childrenIds;
        this.allergies = allergies;
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public String getDietaryRestrictions() {
		return dietaryRestrictions;
	}

	public List<Integer> getChildrenIds() {
		return childrenIds;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	// Setter methods for attributes
    public void setChildrenIds(List<Integer> childrenIds) {
        this.childrenIds = childrenIds;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}