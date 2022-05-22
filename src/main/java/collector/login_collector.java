
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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/login_collector_data")
public class login_collector extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		  String email = req.getParameter("email"); 
		  
		  
		  
		  String pass = req.getParameter("password"); 
		  int password = Integer.parseInt(pass); 
		  insertcollector s = new insertcollector(); 
		  insertcollector s1;
		  
		  s.setEmail(email);
		  
		  s.setPassword(password);
		 

		 PrintWriter out = resp.getWriter();
		 out.print("I'm Login");
		
		 System.out.println("Login servlet");
		
		  try {
		  
			  s1 = s.search_data_byname();
			  System.out.println(s1);
			 if(s1!=null) {
				String name =  s1.getName();
				int id = s1.getId();
				System.out.println(name);
				 out.print("Welcome, "+name);  
		        HttpSession session7=req.getSession();  
		        session7.setAttribute("name",name);  
		        session7.setAttribute("id", id);
			 }
		  
		  Gson gson = new Gson();
		  String jsonArray = gson.toJson(s1);
		  
		  out.print(jsonArray);
		  
		  
		  } catch (SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace();
		  
		  
		  }
		 
	}
}