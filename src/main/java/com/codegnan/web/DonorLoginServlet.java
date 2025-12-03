// DonorLoginServlet.java
package com.codegnan.web;

import com.codegnan.dao.DonorDao;
import com.codegnan.model.Donor;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donorLogin")
public class DonorLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DonorDao dao = new DonorDao();
        try {
            Donor donor = dao.loginDonor(email, password);
            if (donor != null) {
                HttpSession session = request.getSession();
                session.setAttribute("donor", donor);
                response.sendRedirect("donorDashboard.jsp");
            } else {
                response.sendRedirect("donorLogin.jsp?error=Invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}