package IpTracker;

/**
 *
 * @author Dylan Lozo and Kyle Zindell
 */
  public class IpTracker {

	private int userId;
	private String ipAddress;
	private String dateAdded;
	private int numRequest;

	public IpTracker() {
		userId = 0;
		ipAddress = "";
		dateAdded = "";
		numRequest = 0;
	}

	public IpTracker(int userId, String ipAddress, String date added, int numRequest) {
		this.userId = userId;
		this.ipAddress = ipAddress;
		this.dateAdded = dateAdded;
		this.numRequest = numRequest;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getNumRequest() {
		return numRequest;
	}

	public void setNumRequest(int numRequest) {
		this.numRequest = numRequest;
	}

	@Override
	public String toString() {
		return "\nUser Id = " + userId + "\nIp Address = " + ipAddress + "\nDate Added = " + dateAdded + "\nNumber of Requests = " + numRequest;
	}
}
