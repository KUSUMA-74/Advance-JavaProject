<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Salary Report</title>
    <style>
        body {
            background-color: #fff0f5; /* light pink */
            color: #660033; /* dark pink/purple */
            font-family: Arial, sans-serif;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            color: #d63384; /* strong pink */
        }
        table {
            border-collapse: collapse;
            width: 90%;
            background-color: #ffe6f0; /* very light pink */
            margin-top: 20px;
            box-shadow: 0 4px 12px rgba(204, 102, 153, 0.3); /* pinkish shadow */
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ffb3d9; /* pink border */
        }
        th {
            background-color: #d63384; /* strong pink */
            color: white;
        }
        td {
            color: #660033;
        }
        a {
            margin-top: 20px;
            color: #cc3399; /* pink link */
            text-decoration: none;
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
        .error {
            margin-top: 20px;
            color: #cc0033; /* red-ish for errors */
            font-weight: 600;
        }
    </style>
</head>
<body>
    <h2>Employees With Salary Greater Than Input</h2>

<%
    String salaryStr = request.getParameter("salary");
    String dbURL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    String dbUser = "root";
    String dbPass = ""; // Replace with your actual MySQL password

    if (salaryStr == null || salaryStr.trim().isEmpty()) {
%>
        <p class="error">Salary parameter is missing.</p>
<%
    } else {
        try {
            double salary = Double.parseDouble(salaryStr);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String query = "SELECT * FROM employees WHERE bsalary > ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, salary);
            ResultSet rs = stmt.executeQuery();

            boolean recordsFound = false;

%>
    <table>
        <tr>
            <th>Emp No</th>
            <th>Name</th>
            <th>Date of Joining</th>
            <th>Gender</th>
            <th>Basic Salary</th>
        </tr>
<%
            while (rs.next()) {
                recordsFound = true;
%>
        <tr>
            <td><%= rs.getInt("empno") %></td>
            <td><%= rs.getString("empname") %></td>
            <td><%= rs.getDate("doj") %></td>
            <td><%= rs.getString("gender") %></td>
            <td><%= rs.getDouble("bsalary") %></td>
        </tr>
<%
            }

            if (!recordsFound) {
%>
        <tr>
            <td colspan="5" class="error">No employees found with salary greater than <%= salary %>.</td>
        </tr>
<%
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (NumberFormatException e) {
%>
        <p class="error">Invalid salary value provided.</p>
<%
        } catch (Exception e) {
%>
        <p class="error">Error: <%= e.getMessage() %></p>
<%
        }
    }
%>

    <a href="report_form.jsp">← Back to Report Form</a>
</body>
</html>
