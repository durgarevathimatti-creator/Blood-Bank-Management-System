package com.codegnan.dao;

import com.codegnan.model.Admin;
import com.codegnan.util.DBConnection;
import java.sql.*;

public class AdminDao {
    public Admin loginAdmin(String username, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                return admin;
            }
        }
        return null;
    }
}