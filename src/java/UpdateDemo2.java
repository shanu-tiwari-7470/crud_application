import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class  UpdateDemo2 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
				
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'/>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<div id='mymenu'>");
		out.println("<ul><li>home</li><li><a href='Insertdemo.html'>Insert</a></li><li><a href='ShowAll'>ShoAll</a></li><li><a href='searchdemo.html'>search</a></li><li><a href='UpdateDemo1.html'>update</a></li><li><a href='DeleteDemo1.html'>delete</a></li><li><a href='login.html'>LogOut</a></li><li>Contact</li></ul></div>");
		String s1=request.getParameter("u1");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false","root","root");
		 
                	Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks where UROLL='"+s1+"'");
			
			 out.println("<center>");
			 if(rs.next()){
                             out.println("<form action='UpdateDemo1'>");
             out.println("<table cellpadding='12'>");			 
			 out.println("<tr>");
			 out.println("<th>First Name</th>");
		 out.println("<th><input type='text' value='"+rs.getString(1)+"' name='u1'></th>");
			 out.println("</tr>");
			 
		out.println("<tr>");
			 out.println("<th>Last Name</th>");
  		 out.println("<th><input type='text' value='"+rs.getString(2)+"' name='u2'></th>");

			 out.println("</tr>");
			 
			 out.println("<tr>");
			 out.println("<th>Phone Number</th>");
		 out.println("<th><input type='text' value='"+rs.getString(3)+"' name='u3'></th>");

			 out.println("</tr>");
			 
			 out.println("<tr>");
			 out.println("<th>Email </th>");
out.println("<th><input type='text' value='"+rs.getString(4)+"' name='u4'></th>");

			 out.println("</tr>");
			 
			 out.println("<tr>");
			 out.println("<th>Address</th>");
	 out.println("<th><input type='text' value='"+rs.getString(5)+"' name='u5'></th>");

			 out.println("</tr>");
                         
                         out.println("<tr>");
                         out.println("<th colspan='2'><input type='submit' class='B' value='update'></th>");
                          out.println("</tr>");


			 out.println("</table>");
                         out.println("</form>");
		}
			else{
			 out.println("invalid Name");
			}
			con.close();
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
}