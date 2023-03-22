package bean;

public class AdminPassHistoryBean {
	
	private String userEmail;
	private String source;
	private String destination;
	private String validFrom;
	private String validThrough;
	private String passType;
	private String modeofTransaction;
	private double fare;
	private String txnid;
	private String dateTime;
	private int size;
	
	public AdminPassHistoryBean(String userEmail, String source, String destination, String validFrom,
			String validThrough, String passType, String modeofTransaction, double fare, String txnid,
			String dateTime) {
		super();
		this.userEmail = userEmail;
		this.source = source;
		this.destination = destination;
		this.validFrom = validFrom;
		this.validThrough = validThrough;
		this.passType = passType;
		this.modeofTransaction = modeofTransaction;
		this.fare = fare;
		this.txnid = txnid;
		this.dateTime = dateTime;
	}

	public AdminPassHistoryBean(int size) {
		super();
		this.size = size;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public String getValidThrough() {
		return validThrough;
	}

	public String getPassType() {
		return passType;
	}

	public String getModeofTransaction() {
		return modeofTransaction;
	}

	public double getFare() {
		return fare;
	}

	public String getTxnid() {
		return txnid;
	}

	public String getDateTime() {
		return dateTime;
	}

	public int getSize() {
		return size;
	}
}
