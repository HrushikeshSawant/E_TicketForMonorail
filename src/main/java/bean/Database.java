package bean;

public class Database {

	private String driver = "";
	private String url = "";
	private String databaseName = "";
	private String username = "";
	private String password = "";

	public Database(String driver, String url, String databaseName, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
