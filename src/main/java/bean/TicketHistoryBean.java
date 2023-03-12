package bean;

import java.util.Random;

import other.Details;

public class TicketHistoryBean {
	
	private String source;
	private String destination;
	private double passengersCount;
	private String modeofTransaction;
	private double fare;
	private String txnid;
	private String dateTime;
	private int size;
	
	public TicketHistoryBean(String source, String destination, double passengersCount, String modeofTransaction, double fare, String txnid, String dateTime) {
		super();
		this.source = source;
		this.destination = destination;
		this.passengersCount = passengersCount;
		this.modeofTransaction = modeofTransaction;
		this.fare = fare;
		this.txnid = txnid;
		this.dateTime = dateTime;
	}
	
	public TicketHistoryBean(int size) {
		super();
		this.size = size;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public double getPassengersCount() {
		return passengersCount;
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
