package JocelynSourceCode;
//comments
public class School {
    private String name;
    private String distributionRange;

    public School(String name, String distributionRange) {
        this.name = name;
        this.distributionRange = distributionRange;
    }

    public String getName() {
        return name;
    }

    public String getDistributionRange() {
        return distributionRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistributionRange(String distributionRange) {
        this.distributionRange = distributionRange;
    }
}