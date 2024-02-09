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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flight Booking System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: white;
            padding: 1em;
            text-align: center;
        }

        main {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
        }

        input {
            padding: 8px;
            margin-bottom: 16px;
        }

        button {
            padding: 10px;
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
	<header>
        <h1>Flight reservation</h1>
    </header>

    <main>
         <form action="SearchFlite.html">
			 <h2> List of Availiable Flights Yoday</h2>
			 
			 <%
		String flight_name, time ;
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/air_ticket_booking","root","root");
			
			java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM flights");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				flight_name = rs.getString("flight_name");
				time = rs.getString("flight_time");
				
				%>

			<p> <b><%=flight_name%></b>  <i>at  time:</i>  <b><%=time%></b> </p>
			
			<%			
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>

            <button type="button" onclick="bookFlight()">Book Flight</button>
            <br><br>
            <button type="submit">Search Availiable Flights</button>
            
           
        </form>
    </main>

    <script>
        function bookFlight() {
            
            alert ("These are the availiable flights at nearby     ")
            alert("please click on the  button to home page to book  a flite ")
        	}
        	
            
        
    </script>
</body>
</html>