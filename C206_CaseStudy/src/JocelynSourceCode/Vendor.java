package JocelynSourceCode;
import java.util.ArrayList;
import java.util.List;
//comments
public class Vendor extends User {

    private List<Menu> dailyMenus;
    private String contactInformation;

    public Vendor(String userID, String username, String password, String email, String fullName,
                  String phoneNo, String address, String role) {
        super(userID, username, password, email, fullName, phoneNo, address, role);
        this.dailyMenus = new ArrayList<>();
        this.contactInformation = "";
    }
    
    public void addMenu(Menu menu) {
        dailyMenus.add(menu);
    }
    
    public void removeMenu(Menu menu) {
        dailyMenus.remove(menu);
    }

    public List<Menu> getDailyMenus() {
        return dailyMenus;
    }

    public void setDailyMenus(List<Menu> dailyMenus) {
        this.dailyMenus = dailyMenus;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
    
}
