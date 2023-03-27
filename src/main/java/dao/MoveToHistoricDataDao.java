package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class MoveToHistoricDataDao {
	
	private static Logger log = LogManager.getLogger(MoveToHistoricDataDao.class);
	
	public String moveDeletedUserDataToHistorictable()
	{
		try(Connection con = DBConnection.DBCon())
		{
			con.setAutoCommit(false);
			
			try
			{
				PreparedStatement ps = con.prepareStatement("INSERT INTO historic_users_data (Name, Email, Mobile_No) SELECT Name, Email, Mobile_No FROM users WHERE Status = 'Deleted'");
				PreparedStatement ps1 = con.prepareStatement("INSERT INTO historic_users_wallet_transaction_data (Email, Amount, Mode_of_Transaction, Transaction_Id, DateTime) SELECT wt.Email, wt.Amount, wt.Mode_of_Transaction, wt.Transaction_Id, wt.DateTime FROM users u INNER JOIN wallet_transaction wt ON u.Email = wt.Email WHERE u.Status = 'Deleted'");
				PreparedStatement ps2 = con.prepareStatement("INSERT INTO historic_users_ticket_transaction (Email, Source, Destination, Passengers_Count, Fare, Mode_of_Transaction, Transaction_Id, DateTime) SELECT tt.Email, tt.Source, tt.Destination, tt.Passengers_Count, tt.Fare, tt.Mode_of_Transaction, tt.Transaction_Id, tt.DateTime FROM users u INNER JOIN ticket_transaction tt ON u.Email = tt.Email WHERE u.Status = 'Deleted'");
				PreparedStatement ps3 = con.prepareStatement("INSERT INTO historic_users_pass_transaction (CEmail, Source, Destination, Valid_From, Valid_Through, Pass_Type, Fare, Mode_of_Transaction, Transaction_Id, DateTime) SELECT  pt.Email, pt.Source, pt.Destination, pt.Valid_From, pt.Valid_Through, pt.Pass_Type, pt.Fare, pt.Mode_of_Transaction, pt.Transaction_Id, pt.DateTime FROM users u INNER JOIN pass_transaction pt ON u.Email = pt.Email WHERE u.Status = 'Deleted'");
				PreparedStatement ps4 = con.prepareStatement("DELETE wallet_transaction FROM wallet_transaction INNER JOIN users ON users.Email = wallet_transaction.Email WHERE users.Status = 'Deleted'");
				PreparedStatement ps5 = con.prepareStatement("DELETE ticket_transaction FROM ticket_transaction INNER JOIN users ON users.Email = ticket_transaction.Email WHERE users.Status = 'Deleted'");
				PreparedStatement ps6 = con.prepareStatement("DELETE pass_transaction FROM pass_transaction INNER JOIN users ON users.Email = pass_transaction.Email WHERE users.Status = 'Deleted'");
				PreparedStatement ps7 = con.prepareStatement("DELETE FROM users WHERE Status = 'Deleted'");
				
				ps.executeUpdate();
				ps1.executeUpdate();
				ps2.executeUpdate();
				ps3.executeUpdate();
				ps4.executeUpdate();
				ps5.executeUpdate();
				ps6.executeUpdate();
				ps7.executeUpdate();
				
				con.commit();
				con.setAutoCommit(true);
				log.info("Transacrion Committed. Data moved successfully");
				return "Data moved successfully";
			}
			catch (SQLException e) 
			{
				log.info("Transacrion Rollbacked. Something got failed");
				con.rollback();
				e.printStackTrace();
			}
		}
		catch(SQLException | ClassNotFoundException e1)
		{
			e1.printStackTrace();
		} 
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}

}
