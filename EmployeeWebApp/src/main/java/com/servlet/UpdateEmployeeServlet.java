package com.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // or your password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");
        String name = request.getParameter("empname");
        String doj = request.getParameter("doj");
        String gender = request.getParameter("gender");
        String bsalaryStr = request.getParameter("bsalary");

        if (empnoStr == null || empnoStr.isEmpty()) {
            response.sendRedirect("empupdate.jsp?error=Employee number is required");
            return;
        }

        int empno;
        double bsalary;
        try {
            empno = Integer.parseInt(empnoStr);
            bsalary = Double.parseDouble(bsalaryStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("empupdate.jsp?error=Invalid number format");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "UPDATE employees SET empname = ?, doj = ?, gender = ?, bsalary = ? WHERE empno = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, doj);
                    stmt.setString(3, gender);
                    stmt.setDouble(4, bsalary);
                    stmt.setInt(5, empno);

                    int rowsUpdated = stmt.executeUpdate();

                    if (rowsUpdated > 0) {
                        response.sendRedirect("DisplayEmployeeServlet?message=Employee updated successfully");
                    } else {
                        response.sendRedirect("empupdate.jsp?error=Employee not found");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("empupdate.jsp?error=JDBC Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("empupdate.jsp?error=Database error: " + e.getMessage());
        }
    }
}
