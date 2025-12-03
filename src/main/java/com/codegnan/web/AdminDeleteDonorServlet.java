// AdminDeleteDonorServlet.java
package com.codegnan.web;

import com.codegnan.dao.DonorDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteDonor")
public class AdminDeleteDonorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DonorDao dao = new DonorDao();
        try {
            dao.deleteDonor(id);
            response.sendRedirect("adminViewDonors.jsp?msg=Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}