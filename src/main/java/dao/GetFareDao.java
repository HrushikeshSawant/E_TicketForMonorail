package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class GetFareDao {
	
	private static Logger log = LogManager.getLogger(GetFareDao.class);

	public String getFareBetweenTwoStations(String source, String destination)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("SELECT Price FROM station_fare WHERE Source = ? AND Destination = ? OR Source = ? AND Destination = ?");
			ps.setString(1, source);
			ps.setString(2, destination);
			ps.setString(3, destination);
			ps.setString(4, source);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return rs.getString("Price");
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
}
