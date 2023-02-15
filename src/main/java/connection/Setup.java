package connection;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Database;

/**
 * Servlet implementation class Connection
 */
public class Setup extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
	private static Connection con;
	private static String driver = "";
	private static String url = "";
	private static String databaseName = "";
	private static String username = "";
	private static String password = "";
	static Database db;
	
	public static void databaseConnection(HttpServletRequest request, HttpServletResponse response) throws Throwable, IOException {

		try
		{
			ServletContext ctx = request.getServletContext();
			driver = ctx.getInitParameter("driver");
			url = ctx.getInitParameter("url");
			databaseName = ctx.getInitParameter("databaseName");
			username = ctx.getInitParameter("username");
			password = ctx.getInitParameter("password");

			db = new Database(driver, url, databaseName, username, password);
			Setup.DBCon();
		}
		catch(Exception e)
		{
			request.setAttribute("Error", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	
	public static Connection DBCon() throws ClassNotFoundException, SQLException {
		
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl() + db.getDatabaseName(), db.getUsername(), db.getPassword());
		return con;
	}
}
