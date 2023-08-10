public class School {
    private String name;
    private String distributionRange;
    private String contactPersonName;
    private int schoolMobile;

    public School(String name, String distributionRange, String contactPersonName, int schoolMobile) {
        this.name = name;
        this.distributionRange = distributionRange;
        this.contactPersonName = contactPersonName;
        this.schoolMobile = schoolMobile;
        
    }

    public String getName() {
        return name;
    }

    public String getDistributionRange() {
        return distributionRange;
    }
    
    public String getContactPersonName() {
        return contactPersonName;
    }
    
    public int getSchoolMobile() {
        return schoolMobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistributionRange(String distributionRange) {
        this.distributionRange = distributionRange;
    }
    
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }
    
    public void setSchoolMobile(int schoolMobile) {
        this.schoolMobile = schoolMobile;
    }
}

