package bean;

public class WalletHistoryBean {

	private String dateTime;
	private String modeofTransaction;
	private String amount;
	private String transactionId;
	private int size;
	
	public WalletHistoryBean(String dateTime, String modeofTransaction, String amount, String transactionId) {
		super();
		this.dateTime = dateTime;
		this.modeofTransaction = modeofTransaction;
		this.amount = amount;
		this.transactionId = transactionId;
		this.size = size;
	}
	
	public WalletHistoryBean(int size) {
		super();
		this.size = size;
	}

	public String getDateTime() {
		return dateTime;
	}

	public String getModeofTransaction() {
		return modeofTransaction;
	}

	public String getAmount() {
		return amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public int getSize() {
		return size;
	}

}
