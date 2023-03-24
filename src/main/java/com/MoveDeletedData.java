package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.GetUserDetailsBean;
import dao.GetUserDetailsDao;
import dao.MoveToHistoricDataDao;

/**
 * Servlet implementation class MoveDeletedData
 */
public class MoveDeletedData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(MoveDeletedData.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ArrayList<GetUserDetailsBean> userDetails;
		
		GetUserDetailsDao getUserDetailsDao = new GetUserDetailsDao();
		userDetails = getUserDetailsDao.getDeletedUserDetails();
		
		if(userDetails.get(0).getSize() != 0)
		{
			log.info("Deleted users data available");
			MoveToHistoricDataDao moveToHistoricData = new MoveToHistoricDataDao();
			String result = moveToHistoricData.moveDeletedUserDataToHistorictable();
			if(result.equalsIgnoreCase("Data moved successfully"))
				request.setAttribute("Msg", "Deleted Data moved Successsfully to the Historic table!!");
			else
				request.setAttribute("Msg", "Something went wrong, data not moved..");
			
			request.getRequestDispatcher("/move-to-historic-data.jsp").forward(request, response);
		}
		else if(userDetails.get(0).getSize() == 0)
		{
			log.info("No deleted users available");
			request.setAttribute("Msg", "No deleted users available.");
			request.getRequestDispatcher("/move-to-historic-data.jsp").forward(request, response);
		}
		else
		{
			log.info("Something went wrong, Please try again..");
			request.setAttribute("Msg", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/move-to-historic-data.jsp").forward(request, response);
		}
		
	}

}
