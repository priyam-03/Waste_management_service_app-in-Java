package collector;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class profile_collector extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("dashboard_collector.jsp").include(request, response);  
          
        HttpSession session3=request.getSession(false);  
        if(session3!=null){  
        String name=(String)session3.getAttribute("name");  
          
        out.print("Hello, "+name+" Welcome to Profile");  
        System.out.println("Hello, "+name+" Welcome to Profile");
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}  