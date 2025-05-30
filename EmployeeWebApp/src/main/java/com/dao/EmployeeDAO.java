package com.dao;

import com.model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public boolean insertEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO Employee (Empno, EmpName, DoJ, Gender, Bsalary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDoj());
            ps.setString(4, emp.getGender());
            ps.setDouble(5, emp.getSalary());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("Empno"), rs.getString("EmpName"), rs.getString("DoJ"),
                        rs.getString("Gender"), rs.getDouble("Bsalary")));
            }
        }
        return list;
    }

    public boolean deleteEmployee(int empno) throws SQLException {
        String sql = "DELETE FROM Employee WHERE Empno=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empno);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE Employee SET EmpName=?, DoJ=?, Gender=?, Bsalary=? WHERE Empno=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDoj());
            ps.setString(3, emp.getGender());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getEmpno());
            return ps.executeUpdate() > 0;
        }
    }

    public List<Employee> getEmployeesBySalaryRange(double minSalary) throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee WHERE Bsalary >= ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, minSalary);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Employee(rs.getInt("Empno"), rs.getString("EmpName"),
                            rs.getString("DoJ"), rs.getString("Gender"), rs.getDouble("Bsalary")));
                }
            }
        }
        return list;
    }
}
