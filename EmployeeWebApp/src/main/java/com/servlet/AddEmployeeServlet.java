package com.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // your password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empnoStr = request.getParameter("empno");
        String empname = request.getParameter("empname");
        String doj = request.getParameter("doj");
        String gender = request.getParameter("gender");
        String bsalaryStr = request.getParameter("bsalary");

        if (empnoStr == null || empnoStr.isEmpty()) {
            response.sendRedirect("empadd.jsp?error=Employee number is required");
            return;
        }

        int empno;
        double bsalary;
        try {
            empno = Integer.parseInt(empnoStr);
            bsalary = Double.parseDouble(bsalaryStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("empadd.jsp?error=Invalid number format");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "INSERT INTO employees (empno, empname, doj, gender, bsalary) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, empno);
                    stmt.setString(2, empname);
                    stmt.setString(3, doj);
                    stmt.setString(4, gender);
                    stmt.setDouble(5, bsalary);

                    int rowsInserted = stmt.executeUpdate();

                    if (rowsInserted > 0) {
                        response.sendRedirect("DisplayEmployeeServlet?message=Employee added successfully");
                    } else {
                        response.sendRedirect("empadd.jsp?error=Failed to add employee");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("empadd.jsp?error=JDBC Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("empadd.jsp?error=Database error: " + e.getMessage());
        }
    }
}
