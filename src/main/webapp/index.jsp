<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mini Blood Bank</title>
    <style> body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)), 
                    url('https://images.unsplash.com/photo-1615461066841-4b5a5f7b3c0d?ixlib=rb-4.0.3&auto=format&fit=crop&q=80') no-repeat center center fixed;
        background-size: cover;
        color: white;
        min-height: 100vh;
    }
    .container { max-width: 800px; margin: 50px auto; padding: 30px; text-align: center; background: rgba(0,0,0,0.4); border-radius: 15px; }
    input, button, a { padding: 10px; margin: 10px; font-size: 16px; }
    button, a { background: #d32f2f; color: white; text-decoration: none; border: none; border-radius: 5px; cursor: pointer; }
    table { width: 100%; margin-top: 20px; border-collapse: collapse; }
    th, td { padding: 12px; border: 1px solid #ddd; }
    th { background: #b71c1c; } </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Mini Blood Bank System</h1>
    <h3>${param.msg}</h3>
    <a href="userLogin.jsp">User Login</a>
    <a href="userRegister.jsp">User Register</a>
    <a href="donorRegister.jsp">Donor Register</a>
    <a href="donorLogin.jsp">Donor Login</a>
    <a href="adminLogin.jsp">Admin Login</a>
</div>
</body>
</html>