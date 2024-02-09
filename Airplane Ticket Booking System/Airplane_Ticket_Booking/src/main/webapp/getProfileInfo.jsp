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
<style>
body {
    font-family: 'Arial', sans-serif;
    background: linear-gradient(45deg, #00A5B7, #FFA07A);
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0;
}

.container {
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    text-align: center;
    padding: 30px;
    max-width: 400px;
}

h2 {
    font-size: 28px;
    color: #333;
    margin-bottom: 20px;
}

.form-group {
    text-align: left;
    margin-bottom: 20px;
}

label {
    font-size: 16px;
    color: #333;
    display: block;
}

input {
    width: 100%;
    padding: 15px;
    border: none;
    background-color: #f2f2f2;
    border-radius: 5px;
    font-size: 16px;
    transition: background-color 0.3s;
}

input:focus {
    background-color: #e0e0e0;
    outline: none;
}

button {
    width: 100%;
    background: linear-gradient(45deg, #FF4500, #FF6347);
    color: #fff;
    border: none;
    padding: 15px;
    border-radius: 5px;
    font-size: 18px;
    cursor: pointer;
    transition: background 0.3s;
}

button:hover {
    background: linear-gradient(45deg, #FF6347, #FF4500);
}
</style>
</head>
<body>
<div class="container">
        <h1>User Information Form</h1>
        <form action="profile">
            <div class="form-group">
                <label for="passport">Passport Number:</label>
                <input type="text" id="passport" name="passport" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" name="firstname" required>
            </div>
            <div class="form-group">
                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" name="lastname" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="tel" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>