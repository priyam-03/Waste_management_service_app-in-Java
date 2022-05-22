 package bean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import java.sql.SQLException;
//import java.util.Scanner;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



//import javax.servlet.http.Part;

import com.google.gson.Gson;


@WebServlet(urlPatterns="/getoneuserdata")
public class getoneuserdata extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest req ,HttpServletResponse resp) throws ServletException,IOException {
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		insert s = new insert();
		
		
		
		s.setId(id);
		PrintWriter out = resp.getWriter();
		//out.print("Hii");
		
		
		try {
			ArrayList<insert> alluser;
			alluser = s.getoneuserdata();
			Gson gson = new Gson();
			String response = gson.toJson(alluser);
			
			out.print(response);
			
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
