<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <style>
        body {
            background-color: #fff0f5;
            color: #4a004a;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            color: #d63384;
            font-size: 28px;
            margin-bottom: 20px;
            border-bottom: 2px dashed #ff99cc;
            padding-bottom: 10px;
        }

        table {
            border-collapse: collapse;
            width: 90%;
            background-color: #ffe6f0;
            box-shadow: 0 4px 12px rgba(200, 100, 150, 0.2);
            margin-top: 20px;
            border-radius: 10px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ffcce6;
        }

        th {
            background-color: #ff66b2;
            color: white;
        }

        td {
            color: #660033;
            background-color: #fff5fa;
        }

        a {
            margin: 20px 10px;
            color: #cc0066;
            text-decoration: none;
            font-weight: 500;
        }

        a:hover {
            text-decoration: underline;
        }

        .message {
            margin-top: 20px;
            color: #008000;
        }

        .error {
            margin-top: 20px;
            color: #cc0000;
        }

        div {
            margin-top: 25px;
        }
    </style>
</head>
<body>
    <h2>Employee List</h2>

    <%
        String message = request.getParameter("message");
        String error = request.getParameter("error");
        if (message != null) {
    %>
        <p class="message"><%= message %></p>
    <%
        } else if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <%
        }

        String dbURL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
        String dbUser = "root";
        String dbPass = ""; // Your password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            if (!rs.isBeforeFirst()) {
                out.println("<p class='error'>No employees found.</p>");
            } else {
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
    %>
        <tr>
            <td><%= rs.getInt("empno") %></td>
            <td><%= rs.getString("empname") %></td>
            <td><%= rs.getString("doj") %></td>
            <td><%= rs.getString("gender") %></td>
            <td><%= rs.getDouble("bsalary") %></td>
        </tr>
    <%
                }
    %>
    </table>
    <%
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
        }
    %>

    <div>
        <a href="empadd.jsp">Add Employee</a> |
        <a href="empupdate.jsp">Update Employee</a> |
        <a href="empdelete.jsp">Delete Employee</a> |
        <a href="report_form.jsp">Reports</a>
    </div>
</body>
</html>
