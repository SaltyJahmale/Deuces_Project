package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.DriverManager.*;

public final class register_005fgebruiker_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

try {
     String voornaam = request.getParameter("fname");
     String achternaam = request.getParameter("lname");
     String email = request.getParameter("email");
     String gebruiker = request.getParameter("uname");
     String wachtwoord = request.getParameter("pass");
     
     PreparedStatement ps;
     ResultSet rs = null;
     String urlDatabase = "jdbc:mysql://localhost:3306/jspdb";
     String usrDatabase = "root";
     String pswDatabase = "0000";
    
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection( urlDatabase, usrDatabase, pswDatabase);
     
     Statement st = con.createStatement();
     
     ps = con.prepareStatement("INSERT INTO gebruiker (voornaam, achternaam, email, gebruiker_naam, wachtwoord) VALUES (?, ?, ?, ?, ?)");
          ps.setString(1, voornaam);
          ps.setString(2, achternaam);
          ps.setString(3, email);
          ps.setString(4, gebruiker);
          ps.setString(5, wachtwoord);
          
     int insertResult = ps.executeUpdate();
          if (insertResult != 0) {
                 response.sendRedirect("index.jsp"); 
            } else {
               response.sendRedirect("index.jsp");
          }
     } catch(Exception e) {
          
     }

      out.write("   ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
