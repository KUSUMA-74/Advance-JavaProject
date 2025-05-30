package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // or your password

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");

        if (empnoStr == null || empnoStr.trim().isEmpty()) {
            response.sendRedirect("DisplayEmployeeServlet?error=Employee number is required");
            return;
        }

        int empno;
        try {
            empno = Integer.parseInt(empnoStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("DisplayEmployeeServlet?error=Invalid employee number");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "DELETE FROM employees WHERE empno = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, empno);
                    int rowsDeleted = stmt.executeUpdate();

                    if (rowsDeleted > 0) {
                        response.sendRedirect("DisplayEmployeeServlet?message=Employee deleted successfully");
                    } else {
                        response.sendRedirect("DisplayEmployeeServlet?error=Employee not found");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("DisplayEmployeeServlet?error=JDBC Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("DisplayEmployeeServlet?error=Database error: " + e.getMessage());
        }
    }
}
