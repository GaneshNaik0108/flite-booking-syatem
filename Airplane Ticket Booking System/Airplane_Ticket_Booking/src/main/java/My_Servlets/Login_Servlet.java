package My_Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/LoginServlet")  // veryimportant html file ko ye naam dena hai 

public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter(); // basically no use 
			
			// This line loads the MySQL JDBC (Java Database Connectivity) driver class.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//System.out.println("Hii"); // debug the runtime error 
			
			// used to connect to the database 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air_ticket_booking","root","root");
			
			
			// getparameter is used to take the values from the html pages 
			String Name = request.getParameter("Username");
			String Password =  request.getParameter("Password");
			
			// add values to the database 
			PreparedStatement ps = con.prepareStatement("SELECT username, password FROM registration_table WHERE username = ? and password = ? "); 
			// setString is used to set the given values by user to the database table 
			ps.setString(1, Name);
			ps.setString(2, Password);
			ResultSet Rs = ps.executeQuery();
			
			
			// Rs.next() returns true when the next row has some data means pura data retrieve nahi hua humko jo dhundh rahe the woh mil gaya hogaya 
 			if(Rs.next()) {
				 
 				// a session is created iske vajaah se har bande ka profile aaalag se dikhega means har web page ko pata chalega ki kisne login kiya hai  
 				request.getSession().setAttribute("USER", Name);
 				
 			    // if successful then redirect user to this page
				RequestDispatcher rd = request.getRequestDispatcher("homepage2.html");
				rd.forward(request, response);		
			}
			else 
			{
				// again we can write out.println to redirect  to the 
			out.println("<font color =red size = 18> login failed !! <br>");
			
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response); // ye server ko request send karega 
	}

}
