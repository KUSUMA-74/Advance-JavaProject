package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DisplayEmployeeServlet")
public class DisplayEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // or your MySQL password

    public static class Employee {
        public int empno;
        public String name;
        public String doj;
        public String gender;
        public double bsalary;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employeeList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT * FROM employees";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        Employee emp = new Employee();
                        emp.empno = rs.getInt("empno");
                        emp.name = rs.getString("empname");
                        emp.doj = rs.getString("doj");
                        emp.gender = rs.getString("gender");
                        emp.bsalary = rs.getDouble("bsalary");
                        employeeList.add(emp);
                    }
                }
            }

            request.setAttribute("employees", employeeList);
            request.getRequestDispatcher("empdisplay.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("empdisplay.jsp?error=Error loading employees: " + e.getMessage());
        }
    }
}
