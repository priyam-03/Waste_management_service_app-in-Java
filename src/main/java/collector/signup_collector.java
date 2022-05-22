package collector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/insertcollector_collector_data")
public class signup_collector extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		


		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		int password = Integer.parseInt(pass);
		insertcollector s = new insertcollector();
		
		
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
	
		PrintWriter out = resp.getWriter();
		
		try 
		{
			int response = s.addCollector();
			
			if(response == 1)
			{
				out.print("Registration Successfully");
			}
			else
			{
				out.println("Registration Failed");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		}
	}
}