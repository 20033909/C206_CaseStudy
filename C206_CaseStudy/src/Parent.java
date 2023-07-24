
public class Parent extends User{
	private String dietaryRestrictions;
	private List<Integer> childrenIds; // List of child IDs associated with the parent
	private List<String> allergies; // List of food allergies the parent wants to inform about
	
	
	public Parent(String userID, String username, String password, String email, String fullName, String phoneNo, String address, String role, List<Integer> childrenIds, List<String> allergies, String dietaryRestrictions) {
        super(userID, username, password, email, fullName, phoneNo, address, role); 
        this.childrenIds = childrenIds;
        this.allergies = allergies;
        this.dietaryRestrictions = dietaryRestrictions;
    }

}
