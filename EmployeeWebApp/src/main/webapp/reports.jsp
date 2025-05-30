<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Reports</title>
    <style>
        body {
            background-color: #fff0f5; /* light pink background */
            color: #660033; /* dark pink/purple text */
            font-family: Arial, sans-serif;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            color: #d63384; /* strong pink */
            margin-bottom: 30px;
        }
        .card {
            background-color: #ffe6f0; /* very light pink */
            width: 400px;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(204, 102, 153, 0.3); /* pinkish shadow */
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .report-link {
            display: block;
            background-color: #d63384; /* strong pink */
            color: white;
            text-align: center;
            text-decoration: none;
            padding: 12px 20px;
            border-radius: 6px;
            font-weight: bold;
            margin: 10px 0;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        .report-link:hover {
            background-color: #b32d6a; /* slightly darker pink */
        }
        a.back {
            margin-top: 20px;
            color: #cc3399; /* pink link */
            text-decoration: none;
            font-weight: 600;
        }
        a.back:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Employee Reports</h2>

    <div class="card">
        <a class="report-link" href="report_form.jsp">Salary Greater Than Report</a>
        <!-- You can add more report links below as needed -->
        <!-- <a class="report-link" href="another_report.jsp">Another Report</a> -->
    </div>

    <a class="back" href="index.jsp">← Back to Home</a>
</body>
</html>
