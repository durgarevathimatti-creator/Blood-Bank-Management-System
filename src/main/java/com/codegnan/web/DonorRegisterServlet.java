// DonorRegisterServlet.java
package com.codegnan.web;

import com.codegnan.dao.DonorDao;
import com.codegnan.model.Donor;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donorRegister")
public class DonorRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Donor donor = new Donor();
        donor.setName(request.getParameter("name"));
        donor.setContactNumber(request.getParameter("contact"));
        donor.setEmail(request.getParameter("email"));
        donor.setBloodGroup(request.getParameter("bloodGroup"));
        donor.setAddress(request.getParameter("address"));
        donor.setPassword(request.getParameter("password"));

        DonorDao dao = new DonorDao();
        try {
            dao.registerDonor(donor);
            response.sendRedirect("index.jsp?msg=Donor+Registered");
        } catch (SQLException e) {
            response.sendRedirect("donorRegister.jsp?error=Failed");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}