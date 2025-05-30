<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
    <style>
        body {
            background-color: #fff0f5;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            color: #4a004a;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 50px;
        }

        h2 {
            color: #d63384;
            margin-bottom: 25px;
            font-size: 28px;
            border-bottom: 2px dashed #ff99cc;
            padding-bottom: 10px;
        }

        form {
            background-color: #ffe6f0;
            border: 2px solid #ffcce6;
            padding: 30px 40px;
            border-radius: 20px;
            box-shadow: 0 4px 15px rgba(200, 100, 150, 0.2);
            width: 400px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #b30059;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ffb3d9;
            border-radius: 10px;
            background-color: #fff5fa;
            font-size: 14px;
            color: #660033;
        }

        input[type=submit] {
            margin-top: 25px;
            background-color: #ff66b2;
            color: white;
            font-weight: bold;
            border: none;
            padding: 12px;
            cursor: pointer;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        input[type=submit]:hover {
            background-color: #cc3385;
        }

        a {
            margin-top: 20px;
            display: inline-block;
            color: #cc0066;
            text-decoration: none;
            font-weight: 500;
        }

        a:hover {
            text-decoration: underline;
        }

        p {
            margin-top: 20px;
            font-size: 15px;
        }

        .message {
            color: #008000;
        }

        .error {
            color: #cc0000;
        }
    </style>
</head>
<body>
    <h2>Update Employee</h2>

    <form action="UpdateEmployeeServlet" method="post">
        <label>Employee Number (to update):</label>
        <input type="number" name="empno" required />

        <label>New Name:</label>
        <input type="text" name="empname" required />

        <label>New Date of Joining:</label>
        <input type="date" name="doj" required />

        <label>New Gender:</label>
        <select name="gender" required>
            <option value="">--Select--</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>

        <label>New Basic Salary:</label>
        <input type="number" step="0.01" name="bsalary" required />

        <input type="submit" value="Update Employee" />
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
