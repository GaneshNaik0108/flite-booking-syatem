package myJava_Models;

public class Customer {
	// to store username and password 
	private String Username ;
	private String Password ;
	
// we created two getters 	
	public void SetUserName(String username ) {
		Username = username  ;
	}
	public void SetPassword(String password) {
		Password = password ;
	}
// create setters to return the values 
	public String GetUsername() {
		return Username ;
	}
	public String GetPassword() {
		return Password ;
	}
}
