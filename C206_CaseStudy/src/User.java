
public class User {
	
	private int userID;
	private String username;
	private String password;
	private String email;
	private String fullName;
	private String phoneNo;
	private String address;
	private String role;
	
	
	public User(int userID, String username, String password, String email, String fullName, String phoneNo, String address, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.role = role;
    }
	
	// Getters 
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }
	
	
	

}
