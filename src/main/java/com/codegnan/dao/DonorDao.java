package com.codegnan.dao;

import com.codegnan.model.Donor;
import com.codegnan.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonorDao {

    public void registerDonor(Donor donor) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO donors (name, contact_number, email, blood_group, address, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, donor.getName());
            ps.setString(2, donor.getContactNumber());
            ps.setString(3, donor.getEmail());
            ps.setString(4, donor.getBloodGroup());
            ps.setString(5, donor.getAddress());
            ps.setString(6, donor.getPassword());
            ps.executeUpdate();
        }
    }

    public Donor loginDonor(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM donors WHERE email = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Donor d = new Donor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setContactNumber(rs.getString("contact_number"));
                d.setEmail(rs.getString("email"));
                d.setBloodGroup(rs.getString("blood_group"));
                d.setAddress(rs.getString("address"));
                return d;
            }
        }
        return null;
    }

    public List<Donor> getAllDonors() throws SQLException, ClassNotFoundException {
        List<Donor> list = new ArrayList<>();
        String sql = "SELECT * FROM donors";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Donor d = new Donor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setContactNumber(rs.getString("contact_number"));
                d.setEmail(rs.getString("email"));
                d.setBloodGroup(rs.getString("blood_group"));
                d.setAddress(rs.getString("address"));
                list.add(d);
            }
        }
        return list;
    }

    public Donor getDonorById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM donors WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Donor d = new Donor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setContactNumber(rs.getString("contact_number"));
                d.setEmail(rs.getString("email"));
                d.setBloodGroup(rs.getString("blood_group"));
                d.setAddress(rs.getString("address"));
                return d;
            }
        }
        return null;
    }

    public void updateDonor(Donor donor) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE donors SET name=?, contact_number=?, email=?, blood_group=?, address=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, donor.getName());
            ps.setString(2, donor.getContactNumber());
            ps.setString(3, donor.getEmail());
            ps.setString(4, donor.getBloodGroup());
            ps.setString(5, donor.getAddress());
            ps.setInt(6, donor.getId());
            ps.executeUpdate();
        }
    }

    public void deleteDonor(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM donors WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}