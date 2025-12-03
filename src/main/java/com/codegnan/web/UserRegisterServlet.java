// UserRegisterServlet.java
package com.codegnan.web;

import com.codegnan.dao.UserDao;
import com.codegnan.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setContactNumber(request.getParameter("contact"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        UserDao dao = new UserDao();
        try {
            dao.registerUser(user);
            response.sendRedirect("index.jsp?msg=User+Registered+Successfully");
        } catch (SQLException e) {
            response.sendRedirect("userRegister.jsp?error=Registration+Failed");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}