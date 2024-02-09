package myJava_Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CustomerDAO {
	// to handle an exception if the class is not found .here we passed an object of type customer 
	public int SignInCustomer(Customer customer) throws ClassNotFoundException{
		
		int result =0 ; 
		// loads mysql jdbc driver from memory 
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			// these three lines are used to simplify the program 
			// url har class mein constant hai woh jdbc se connect karne ke liye use hoga 
			String url = "jdbc:mysql://localhost:3306/air_ticket_booking" ;
			// ye mysql ke passwords and username hai jo humko connnection banate time pass karna hai. done for  sake simplicity
			String username = "root" ;
			String password = "root" ;
			
			// this line is used to set connection to the data base using connection Object 
			Connection connection = DriverManager.getConnection(url,username,password);
			
			DuplicateEntry DE = new DuplicateEntry();
			
			if(DE.Entry(customer)) {
				result = 0 ;
			}
			
			else {
				// above line is used to add values to database 
				java.sql.PreparedStatement ps = connection.prepareStatement("INSERT INTO registration_table (username, password)VALUES(?, ?);");
				ps.setString(1,customer.GetUsername());
				ps.setString(2,customer.GetPassword());
				
				// to update/insert Query or to add data in the database 
				result = ps.executeUpdate();
			}
			// used to close the database connection 
			connection.close();
			
		}catch(SQLException e ) {
			// process SQL Exception 
			e.printStackTrace();
		}
		
		return result ;
	}

}
