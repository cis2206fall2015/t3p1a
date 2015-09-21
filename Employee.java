package employeefile;

/**
 *
 * @author Dylan Lozo and Kyle Zindell
 */
public class UserIpAddress {

    private int userId;
    private String ipAddress;
    private String dateAdded;
    private int numRequest;

    public Employee() {
        userId = 0;
        ipAddress = "";
        dateAdded = "";
        numRequest = 0;
    }

    public UserIpAddress(int userId, String ipAddress, String dateAdded, int numRequest) {
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.dateAdded = dateAdded;
        this.numRequest = numRequest;
    }

    public String getdateAdded() {
        return dateAdded;
    }

    public void setdateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getipAddress() {
        return ipAddress;
    }

    public void setipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getnumRequest() {
        return numRequest;
    }

    public void setnumRequest(int numRequest) {
        this.numRequest = numRequest;
    }

    @Override
    public String toString() {
        return "Employee{" + "userId=" + userId + ", ipAddress=" + ipAddress 
                + ", dateAdded=" + dateAdded  
                + ", numRequest=" + numRequest + '}';
    }
}
