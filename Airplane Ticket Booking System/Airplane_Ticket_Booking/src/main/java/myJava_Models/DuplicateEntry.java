package myJava_Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DuplicateEntry {
	
	public boolean Entry(Customer customer) throws ClassNotFoundException{
		
		boolean status = false ;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			// used to maintain simplicity 
			// url har class mein constant hai woh jdbc se connect karne ke liye use hoga 
			String url = "jdbc:mysql://localhost:3306/air_ticket_booking" ;
			// ye mysql ke passwords and username hai jo humko connnection banate time pass karna hai  
			String username = "root" ;
			String password = "root" ;
			
			// used to connect to the Database 
			Connection connection = DriverManager.getConnection(url,username ,password);
			
			// above line is used to add values to database check karega ki username exists or not 
			java.sql.PreparedStatement ps = connection.prepareStatement("SELECT * FROM  registration_table WHERE username = ?;");
			ps.setString(1, customer.GetUsername());
			
			// table mein se retrieve karega aur ResultSet ke Object ke pass values send karega 
			ResultSet rs = ps.executeQuery();
			
			// rs mein koi value rahega tho rs.next() ki value true ho jayegiii  aur hume pata chalega ki dublicate values hai 
			// dublicate entry rahegii tho status true ho jayega 
			
			status = rs.next();
			
			connection.close();
			
		}catch(SQLException e ) {
			e.printStackTrace ();
		}
		
		return status ;
	}

}
