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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Profile_Servlet
 */
@WebServlet("/profile")
public class Profile_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String user = (String)request.getSession().getAttribute("USER");
		
		int result = 0;
		
		String passport = request.getParameter("passport");
		String email =  request.getParameter("email");
		String firstname =  request.getParameter("firstname");
		String lastname =  request.getParameter("lastname");
		String phone =  request.getParameter("phone");
		int userid = 0;
	
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air_ticket_booking","root","root");
			
			java.sql.PreparedStatement preparedStatement = con.prepareStatement("SELECT user_id FROM registration_table WHERE username = '"+user+"' ");
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				userid=rs.getInt(1);
			}
			//used to add values to the data base 
			java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO user_data"
					+ "(firstname, lastname, emailid, phone_num, passport_num, userid)"
					+ "VALUES(?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, passport);
			ps.setInt(6, userid);
			
			result = ps.executeUpdate();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		if(result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("Reservation.html");
			rd.forward(request, response);	
		}
		else {
			out.println("<font color =red size = 18> Due to some reason Process failed !! <br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
