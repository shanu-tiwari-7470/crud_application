import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class DeleteDemo1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
	        String s3=request.getParameter("u3");
	        String s4=request.getParameter("u4");
	        String s5=request.getParameter("u5");

	
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		try{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false","root","root");
		 Statement st= con.createStatement();
       int x=st.executeUpdate("delete from insmarks where UROLL='"+s1+"'");
        if(x!=0)
        {
          
            response.sendRedirect("ShowAll");
            
        }
        else{
		out.println("<h1>data not deleted</h1>");

		}
        con.close();
                }
		catch(Exception e){
		out.println(e);
		
		}
		//out.println("<h1>Name="+s1+"</h1>");
		//out.println("<h1>Sername="+s2+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}		
	
}
