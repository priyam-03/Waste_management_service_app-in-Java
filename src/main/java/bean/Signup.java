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
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/insert_data")
public class Signup extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//ArrayList<String> subs = new ArrayList<String>();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		

		insert s = new insert();
		
		
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setAddress(address);
		s.setCredit(0);
		PrintWriter out = resp.getWriter();
		
		try 
		{
			int id = (int)s.addUser();
			s.setId(id);
			s.addCredit();
			
			req.getRequestDispatcher("login.html").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		}
	}
}