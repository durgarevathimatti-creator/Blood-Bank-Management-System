<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.codegnan.dao.DonorDao, com.codegnan.model.Donor, java.util.List" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>User Dashboard</title>
<style> <style>
    body {
        margin: 0; padding: 0; font-family: 'Segoe UI', Arial, sans-serif;
        background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)), 
                    url('https://images.unsplash.com/photo-1615461066841-4b5a5f7b3c0d?ixlib=rb-4.0.3&auto=format&fit=crop&q=80') 
                    no-repeat center center fixed;
        background-size: cover; color: white; min-height: 100vh;
    }
    .container { max-width: 900px; margin: 40px auto; padding: 30px; text-align: center; 
                 background: rgba(0,0,0,0.5); border-radius: 20px; box-shadow: 0 0 20px rgba(255,0,0,0.5); }
    h1, h2 { color: #ff1744; text-shadow: 0 0 10px #c62828; }
    input[type=text], input[type=email], input[type=password], select {
        width: 80%; padding: 12px; margin: 10px 0; border: none; border-radius: 8px; font-size: 16px;
    }
    input[type=submit], button, a.btn {
        background: #d32f2f; color: white; padding: 12px 30px; border: none; border-radius: 8px;
        cursor: pointer; text-decoration: none; display: inline-block; margin: 10px;
        font-size: 16px; transition: 0.3s;
    }
    input[type=submit]:hover, button:hover, a.btn:hover { background: #f44336; transform: scale(1.05); }
    table { width: 100%; margin-top: 20px; border-collapse: collapse; }
    th { background: #b71c1c; padding: 15px; }
    td { padding: 12px; background: rgba(255,255,255,0.1); }
    a { color: #ff5252; text-decoration: none; }
    .logout { position: absolute; top: 20px; right: 20px; background: #880e4f; }
</style> </style>
</head>
<body>
<a href="index.jsp" class="btn logout">Logout</a>
<div class="container">
    <h1>Welcome, User!</h1>
    <h2>Available Blood Donors</h2>
    <table>
        <tr><th>Name</th><th>Blood Group</th><th>Contact</th><th>Address</th></tr>
        <%
            DonorDao dao = new DonorDao();
            List<Donor> list = dao.getAllDonors();
            for(Donor d : list){
        %>
        <tr>
            <td><%=d.getName()%></td>
            <td><strong style="color:#ff1744;"><%=d.getBloodGroup()%></strong></td>
            <td><%=d.getContactNumber()%></td>
            <td><%=d.getAddress()%></td>
        </tr>
        <%}%>
    </table>
</div>
</body></html>