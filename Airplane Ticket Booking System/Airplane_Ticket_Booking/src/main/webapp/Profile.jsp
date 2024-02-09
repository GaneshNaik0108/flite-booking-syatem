<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String User=(String)request.getSession().getAttribute("USER");
if(User==null)
{
	response.sendRedirect("LoginPage.html");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<%
		String fname, lname, email, phone, passport;
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air_ticket_booking","root","root");
			
			java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM user_data WHERE userid = (SELECT user_id FROM registration_table WHERE username = '"+User+"')");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				fname = rs.getString("firstname");
				lname = rs.getString("lastname");
				email = rs.getString("emailid");
				phone = rs.getString("phone_num");
				passport = rs.getString("passport_num");
				%>
				
				<p>First Name  : <%=fname%> </p>
				<p>Last Name   : <%=lname%> </p>
				<p>Email       : <%=email%> </p>
				<p>Phone No.   : <%=phone%> </p>
				<p>Passport No.: <%=passport%> </p>
				
				<hr>
				<br>
				<%			
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</div>

</body>
</html>