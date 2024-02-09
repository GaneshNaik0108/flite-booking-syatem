// login servlet mei bhi tahi code hai so iska koi use nahi hai dono same hai 
package myJava_Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class CustomerLoginDAO {
	
	public boolean verify (Customer customer) throws ClassNotFoundException{
		
		boolean status = false ;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			// used to maintain simplicity 
			// url har class mein constant hai woh jdbc se connect karne ke liye use hoga 
			String url = "jdbc:mysql://localhost:3306/air_ticket_booking" ;
			// ye mysql ke passwords and username hai jo humko connnection banate time pass karna hai
			String username = "root" ;
			String password = "root" ;
			
			// used to connect to the database 
			Connection connection = DriverManager.getConnection(url,username,password);
			
			// add values to the database 
			java.sql.PreparedStatement ps = connection.prepareStatement("SELECT username, password FROM registration_table WHERE username = ? and password = ? ");
			ps.setString(1, customer.GetUsername());
			ps.setString(2, customer.GetPassword());
			// ye executeQuery Query ke code ko run karta hai 
			ResultSet rs = ps.executeQuery();
			
			
		}catch(SQLException e) {
			// process sql exception 
			e.printStackTrace();
			
		}
		return status ;
	}

}
