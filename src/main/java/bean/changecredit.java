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
@WebServlet(urlPatterns = "/insert_credit")
public class changecredit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//ArrayList<String> subs = new ArrayList<String>();
		String credit1 = req.getParameter("credit");
		int credit = Integer.parseInt(credit1);
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		insert s = new insert();
		
		
		s.setCredit(credit);
		s.setId(id);
		PrintWriter out = resp.getWriter();
		
		try 
		{
			int update = s.updateCredit();
			
			
			if(update == 1)
				out.print("data update Successfully");
			else
				out.println("update Failed");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		}
	}
}