package sources;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/index")
public class MyServletA extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
            response.setContentType("text/html");

            try (PrintWriter out = response.getWriter()) {
                String message = "If you're reading this, it worked!";
                
                out.println("<html><body>");
                out.println("<h1><a href='phrase'>Get Phrase</a></h1>");
                out.println("</body></html>");
                out.flush();
            } 
        }
    
    
    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
            response.setContentType("text/html");
            
            try (PrintWriter out = response.getWriter()){
                out.println("<html><body>ERROR</body></html>");
                out.flush();
            }
    }
}