package bean;

public class UserBean {

	private String name = "";
	private String email = "";
	private String mobile_no = "";
	private String password = "";
	private String c_password = "";
	private String h_password = "";

	public UserBean(String name, String email, String mobile_no, String password, String c_password, String h_password) {
		super();
		this.name = name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.password = password;
		this.c_password = c_password;
		this.h_password = h_password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getmobile_no() {
		return mobile_no;
	}

	public void setmobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getH_password() {
		return h_password;
	}

	public void setH_password(String h_password) {
		this.h_password = h_password;
	}

}
