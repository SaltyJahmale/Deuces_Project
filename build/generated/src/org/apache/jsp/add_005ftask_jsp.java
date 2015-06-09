package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class add_005ftask_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

    String username = (String) session.getAttribute("userid");
    String invoer_taak = request.getParameter("taak");    
    String invoer_omsch = request.getParameter("omschrijving");
    String invoer_datum = request.getParameter("datum");
    String invoer_categorie = request.getParameter("categorie");
    
    String urlDatabase = "jdbc:mysql://localhost:3306/jspdb";
    String usrDatabase = "root";
    String pswDatabase = "0000";
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection( urlDatabase, usrDatabase, pswDatabase);
    
    String sql = "SELECT gebruiker_id FROM gebruiker WHERE voornaam = '" + username + "'";
    PreparedStatement ps = con.prepareStatement(sql);     
    ps.execute();
    
    ResultSet rs = ps.executeQuery();
    int getUserKey = 0;
    if (rs.next()) {
        getUserKey = rs.getInt(1);
    }
    int i = ps.executeUpdate("insert into nieuwe_taak(gebruiker_id, taak_naam, omschrijving, datum, categorie) values ('" + getUserKey + "', '" + invoer_omsch + "','" + invoer_datum + "','" + invoer_categorie + "','" + invoer_taak + "')");
    if (i > 0) {
        response.sendRedirect("show_task.jsp");
    } else {
        response.sendRedirect("create_task.jsp");
    }

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
