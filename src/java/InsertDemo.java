/*import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class  InsertDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{           
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
		String s3=request.getParameter("u3");
		String s4=request.getParameter("u4");
		String s5=request.getParameter("u5");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try
		{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection con=DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false","root","root");
		       Statement st=con.createStatement();
			 int x=st.executeUpdate("insert into insmarks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			 if(x!=0)
			 {
			response.sendRedirect("ShowAll");	 
			 }
			 else
			 {
			out.println("<h1>data  not insert</h1>");
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
}*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.regex.*;

public class InsertDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("u1");
        String lastName = request.getParameter("u2");
        String phoneNumber = request.getParameter("u3");
        String emailId = request.getParameter("u4");
        String address = request.getParameter("u5");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        // Validation
        if (!isValidFirstName(firstName)) {
            out.println("<h1>Invalid first name. Only letters are allowed.</h1>");
        } else if (!isValidLastName(lastName)) {
            out.println("<h1>Invalid last name. Only letters are allowed.</h1>");
        } else if (!isValidPhoneNumber(phoneNumber)) {
            out.println("<h1>Invalid phone number. Only numbers are allowed.</h1>");
        } else if (!isValidEmail(emailId)) {
            out.println("<h1>Invalid email address.</h1>");
        } else if (!isValidAddress(address)) {
            out.println("<h1>Invalid address.</h1>");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false", "root", "root");
                Statement st = con.createStatement();
                int x = st.executeUpdate("insert into insmarks values('" + firstName + "','" + lastName + "','" + phoneNumber + "','" + emailId + "','" + address + "')");
                if (x != 0) {
                    response.sendRedirect("ShowAll");
                } else {
                    out.println("<h1>Data not inserted</h1>");
                }
                con.close();
            } catch (Exception e) {
                out.println(e);
            }
        }
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    private boolean isValidFirstName(String name) {
        return name != null && name.matches("[a-zA-Z]+");
    }

    private boolean isValidLastName(String name) {
        return name != null && name.matches("[a-zA-Z]+");
    }

    private boolean isValidPhoneNumber(String number) {
        return number != null && number.matches("[0-9]+");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    private boolean isValidAddress(String address) {
        return address != null && address.matches("[a-zA-Z0-9\\s,.-]+");
    }
}
