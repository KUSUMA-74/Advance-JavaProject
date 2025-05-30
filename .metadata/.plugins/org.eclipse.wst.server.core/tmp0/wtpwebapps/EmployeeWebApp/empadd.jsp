<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <style>
        body {
            background: linear-gradient(135deg, #ffe6f0, #ffccdd, #ffb3cc);
            color: #660033;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            color: #d63384;
            margin-bottom: 20px;
            text-shadow: 0 0 5px #ff99cc;
        }

        form {
            background: #fff0f5;
            border-radius: 15px;
            padding: 30px 35px;
            box-shadow: 0 8px 24px rgba(204, 102, 153, 0.3);
            width: 420px;
            transition: transform 0.2s ease;
        }

        form:hover {
            transform: scale(1.01);
        }

        label {
            margin-top: 15px;
            display: block;
            font-weight: 600;
            color: #a80056;
        }

        input, select {
            width: 100%;
            padding: 10px 12px;
            margin-top: 6px;
            margin-bottom: 16px;
            border: 1px solid #ffb3d9;
            border-radius: 8px;
            background-color: #ffe6f2;
            color: #660033;
            font-size: 14px;
        }

        input[type=submit] {
            background-color: #d63384;
            color: white;
            font-weight: bold;
            cursor: pointer;
            border: none;
            padding: 12px;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        input[type=submit]:hover {
            background-color: #a80056;
        }

        a {
            margin-top: 20px;
            color: #cc3399;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        p {
            margin-top: 20px;
            font-size: 15px;
        }

        .message {
            color: #4b004b;
            font-weight: 600;
        }

        .error {
            color: #cc0033;
            font-weight: 600;
        }
    </style>
</head>
<body>
    <h2>Add Employee</h2>

    <form action="AddEmployeeServlet" method="post">
        <label>Employee Number:</label>
        <input type="number" name="empno" required />

        <label>Employee Name:</label>
        <input type="text" name="empname" required />

        <label>Date of Joining:</label>
        <input type="date" name="doj" required />

        <label>Gender:</label>
        <select name="gender" required>
            <option value="">--Select--</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>

        <label>Basic Salary:</label>
        <input type="number" step="0.01" name="bsalary" required />

        <input type="submit" value="Add Employee" />
    </form>

    <a href="empdisplay.jsp">← Back to Employee List</a>

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
    %>
</body>
</html>
