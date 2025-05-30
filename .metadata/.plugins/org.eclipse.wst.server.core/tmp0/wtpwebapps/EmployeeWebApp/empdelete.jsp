<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
    <style>
        body {
            background-color: #ffe6f0;
            font-family: Arial, sans-serif;
            color: #5a2a41;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 40px;
        }
        h2 {
            color: #d63384;
        }
        form {
            background-color: #fff0f5;
            padding: 20px;
            border-radius: 12px;
            width: 400px;
            box-shadow: 0 4px 10px rgba(214, 51, 132, 0.3);
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-size: 16px;
            font-weight: 600;
        }
        input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="number"] {
            background-color: #ffd6e8;
            color: #5a2a41;
        }
        input[type="submit"] {
            background-color: #d63384;
            color: white;
            cursor: pointer;
            margin-top: 20px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #b0266c;
        }
        a {
            margin-top: 20px;
            display: inline-block;
            color: #d63384;
            text-decoration: none;
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
        p {
            margin-top: 20px;
            font-size: 16px;
            font-weight: 600;
        }
        .message {
            color: #28a745;
        }
        .error {
            color: #dc3545;
        }
    </style>
</head>
<body>
    <h2>Delete Employee</h2>

    <form action="DeleteEmployeeServlet" method="get">
        <label>Enter Employee Number to Delete:</label>
        <input type="number" name="empno" required />
        <input type="submit" value="Delete Employee" />
    </form>

    <a href="empdisplay.jsp">← Back to Employee List</a>

    <% 
       String message = request.getParameter("message");
       String error = request.getParameter("error");
       if (message != null) { 
    %>
         <p class="message"><%= message %></p>
    <% } else if (error != null) { %>
         <p class="error"><%= error %></p>
    <% } %>
</body>
</html>
