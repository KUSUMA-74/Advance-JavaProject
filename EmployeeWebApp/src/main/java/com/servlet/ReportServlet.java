package com.servlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private EmployeeDAO dao;

    public void init() {
        dao = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double minSalary = Double.parseDouble(request.getParameter("minSalary"));

        try {
            List<Employee> filteredList = dao.getEmployeesBySalaryRange(minSalary);
            request.setAttribute("empList", filteredList);
            request.getRequestDispatcher("report_result.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
        }
    }
}
