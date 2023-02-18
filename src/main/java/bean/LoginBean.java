package bean;

public class LoginBean {

	private String email;
	private String password;
	private String h_password;
	
	public LoginBean(String email, String password, String h_password) {
		super();
		this.email = email;
		this.password = password;
		this.h_password = h_password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geth_password() {
		return h_password;
	}

	public void seth_password(String h_password) {
		this.h_password = h_password;
	}
}
