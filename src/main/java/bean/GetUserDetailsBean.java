package bean;

public class GetUserDetailsBean {
	
	private String name;
	private String email;
	private String accountStatus;
	private int size;
	
	public GetUserDetailsBean(String name, String email, String accountStatus) {
		super();
		this.name = name;
		this.email = email;
		this.accountStatus = accountStatus;
	}
	
	public GetUserDetailsBean(int size) {
		super();
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public int getSize() {
		return size;
	}
}
