package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.GetStationNamesBean;
import connection.DBConnection;

public class GetStationNamesDao {
	
	private static Logger log = LogManager.getLogger(GetStationNamesDao.class);
	
	public ArrayList<GetStationNamesBean> getStationNames()
	{
		ArrayList<GetStationNamesBean> getStationNames = new ArrayList<GetStationNamesBean>();
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("SELECT Stations FROM station_name");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				GetStationNamesBean getStationNamesBean = new GetStationNamesBean(rs.getString("Stations"));
				getStationNames.add(getStationNamesBean);
			}
			
			return getStationNames;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return getStationNames;
	}

}
