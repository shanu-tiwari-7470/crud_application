import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class MenuDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
                String s1=(String)session.getAttribute("un");
                if(s1!=null){
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'/>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<div id='mymenu'>");
          out.println("<ul><li>Home</li><li><a href='Insertdemo.html'>Insert</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='searchdemo.html'>search</a></li><li><a href='UpdateDemo1.html'>update</a></li><li><a href='DeleteDemo1.html'>delete</a></li><li><a href='login.html'>LogOut</a></li><li>Contact</li></ul></div>");
           out.println("welcome="+s1);
           out.println("</body>");
           out.println("</html>");
                }
                else{
                    response.sendRedirect("login.html");
                }

		out.close();
		
	}
	
}