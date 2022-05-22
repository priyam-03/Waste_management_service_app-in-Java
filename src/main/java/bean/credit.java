package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet(urlPatterns = "/credit")
public class credit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("id");
		int id = Integer.parseInt(userid);
		
		insert s = new insert();
		
		s.setCredit(id);
	
		PrintWriter out = resp.getWriter();
		
		try {
			ResultSet allcredit;
			allcredit = s.getcreditdata();
			
			int credit = 0;
			
			if(allcredit.next())
			{
				credit = allcredit.getInt("credit");
			}
			
			out.print(credit);
			
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}