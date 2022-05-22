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


@WebServlet(urlPatterns="/getcompeteuserdata")
public class getCompleteuserdata extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest req ,HttpServletResponse resp) throws ServletException,IOException {
	
		PrintWriter out = resp.getWriter();
		//out.print("Hii");
		
		insert s = new insert();
		try {
			ArrayList<insert> alluser;
			alluser = s.getCompleteuserdata();
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
