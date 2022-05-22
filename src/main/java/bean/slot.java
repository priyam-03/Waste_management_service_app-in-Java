package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/slot")
public class slot extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subsname = req.getParameter("subsname");
		String slot;
		if(subsname.equals("Organic")||subsname.equals("E-waste")) {
			 slot = req.getParameter("slot");
		}
		else {
			String slot1 = req.getParameter("slot1");
			String slot2= req.getParameter("slot2");
			 slot = slot1+" & "+ slot2;
		}
		int id = Integer.parseInt(req.getParameter("id"));

		
		insert s = new insert();
		
		s.setSubsname(subsname);
		s.setSlot(slot);
		s.setId(id);
	
		PrintWriter out = resp.getWriter();
		
		try 
		{
			int response = s.addSubscription();
			
			if(response == 1)
			{
				out.print("Registration Successfully");
			}
			else
			{
				out.println("Registration Failed");
			}
			 req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		}
	}
}