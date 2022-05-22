package collector;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

@WebServlet(urlPatterns = "/collector_logout")
public class logout_collector extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            request.getRequestDispatcher("login_collector.html").forward(request, response);  
              
            HttpSession session4=request.getSession();  
            session4.invalidate();  
              
            out.print("You are successfully logged out!");  
              
            out.close();  
    }  
}  

