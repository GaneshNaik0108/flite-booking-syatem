package My_Servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
// we imported our created class 
import myJava_Models.* ;

/**
 * Servlet implementation class SignUp_Servlet
 */
@WebServlet("/SignUpServlet")
public class SignUp_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public SignUp_Servlet() {
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
		
	    CustomerDAO CD = new CustomerDAO();  // two classes ke objects create kiye 
	    Customer customer = new Customer();
	    
		int i = 0 ;
		// used to take values from html textfield signup page 
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		
		customer.SetUserName(Username);
		customer.SetPassword(Password);
		
		try {
		// SignInCustomer returns the values stored in database if there is no dublicate entry 
			 i = CD.SignInCustomer(customer);
			
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		// if login is successfull then goTo home page 
		if(i>0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginPage.html");
			dispatcher.forward(request, response);
		}
		// login is unsuccessfull so again goback to login page 
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPage.html");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}

}
