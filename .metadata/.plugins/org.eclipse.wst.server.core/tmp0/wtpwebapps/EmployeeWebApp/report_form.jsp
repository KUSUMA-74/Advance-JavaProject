<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Salary Report</title>
    <style>
        body {
            background-color: #fff0f5;
            color: #660033;
            font-family: Arial, sans-serif;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            color: #d63384;
        }
        form {
            background-color: #ffe6f0;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(204, 102, 153, 0.3);
            width: 400px;
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
            font-weight: bold;
            color: #a80056;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ffb3d9;
            border-radius: 8px;
            background-color: #fff5fa;
            color: #660033;
            font-size: 14px;
        }
        input[type=submit] {
            background-color: #d63384;
            color: white;
            font-weight: bold;
            margin-top: 20px;
            cursor: pointer;
            border: none;
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
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
        .error {
            margin-top: 20px;
            color: #cc0033;
            text-align: center;
            font-weight: 600;
        }
    </style>
</head>
<body>
    <h2>Generate Salary Report</h2>

    <form action="report_result.jsp" method="get">
        <label for="empno">Enter Employee Number (optional):</label>
        <input type="number" name="empno" id="empno" min="1" placeholder="Leave blank to ignore" />

        <label for="salary">Enter Minimum Salary:</label>
        <input type="number" name="salary" id="salary" step="0.01" required />

        <input type="submit" value="Show Report" />
    </form>

    <% 
       String error = request.getParameter("error");
       if (error != null) {
    %>
       <p class="error"><%= error %></p>
    <%
       }
    %>

    <a href="empdisplay.jsp">← Back to Employee List</a>
</body>
</html>
