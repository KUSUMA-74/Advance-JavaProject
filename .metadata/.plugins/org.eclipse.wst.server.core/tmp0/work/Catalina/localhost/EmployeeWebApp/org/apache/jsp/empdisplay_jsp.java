/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.105
 * Generated at: 2025-05-30 15:18:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class empdisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(7);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Employee List</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: #fff0f5;\r\n");
      out.write("            color: #4a004a;\r\n");
      out.write("            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\r\n");
      out.write("            padding: 40px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("            color: #d63384;\r\n");
      out.write("            font-size: 28px;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            border-bottom: 2px dashed #ff99cc;\r\n");
      out.write("            padding-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table {\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            width: 90%;\r\n");
      out.write("            background-color: #ffe6f0;\r\n");
      out.write("            box-shadow: 0 4px 12px rgba(200, 100, 150, 0.2);\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        th, td {\r\n");
      out.write("            padding: 12px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border-bottom: 1px solid #ffcce6;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #ff66b2;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        td {\r\n");
      out.write("            color: #660033;\r\n");
      out.write("            background-color: #fff5fa;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        a {\r\n");
      out.write("            margin: 20px 10px;\r\n");
      out.write("            color: #cc0066;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        a:hover {\r\n");
      out.write("            text-decoration: underline;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .message {\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            color: #008000;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .error {\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            color: #cc0000;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        div {\r\n");
      out.write("            margin-top: 25px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h2>Employee List</h2>\r\n");
      out.write("\r\n");
      out.write("    ");

        String message = request.getParameter("message");
        String error = request.getParameter("error");
        if (message != null) {
    
      out.write("\r\n");
      out.write("        <p class=\"message\">");
      out.print( message );
      out.write("</p>\r\n");
      out.write("    ");

        } else if (error != null) {
    
      out.write("\r\n");
      out.write("        <p class=\"error\">");
      out.print( error );
      out.write("</p>\r\n");
      out.write("    ");

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
    
      out.write("\r\n");
      out.write("    <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Emp No</th>\r\n");
      out.write("            <th>Name</th>\r\n");
      out.write("            <th>Date of Joining</th>\r\n");
      out.write("            <th>Gender</th>\r\n");
      out.write("            <th>Basic Salary</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("    ");

                while (rs.next()) {
    
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print( rs.getInt("empno") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getString("empname") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getString("doj") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getString("gender") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getDouble("bsalary") );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    ");

                }
    
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("    ");

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
        }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("        <a href=\"empadd.jsp\">Add Employee</a> |\r\n");
      out.write("        <a href=\"empupdate.jsp\">Update Employee</a> |\r\n");
      out.write("        <a href=\"empdelete.jsp\">Delete Employee</a> |\r\n");
      out.write("        <a href=\"report_form.jsp\">Reports</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
