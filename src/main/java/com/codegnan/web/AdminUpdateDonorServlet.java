// AdminUpdateDonorServlet.java
package com.codegnan.web;

import com.codegnan.dao.DonorDao;
import com.codegnan.model.Donor;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateDonor")
public class AdminUpdateDonorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Donor donor = new Donor();
        donor.setId(Integer.parseInt(request.getParameter("id")));
        donor.setName(request.getParameter("name"));
        donor.setContactNumber(request.getParameter("contact"));
        donor.setEmail(request.getParameter("email"));
        donor.setBloodGroup(request.getParameter("bloodGroup"));
        donor.setAddress(request.getParameter("address"));

        DonorDao dao = new DonorDao();
        try {
            dao.updateDonor(donor);
            response.sendRedirect("adminViewDonors.jsp?msg=Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}