package com.codegnan.dao;

import com.codegnan.model.User;
import com.codegnan.util.DBConnection;
import java.sql.*;

public class UserDao {

    public void registerUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO users (name, contact_number, email, password) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getContactNumber());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        }
    }

    public User loginUser(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        }
        return null;
    }
}