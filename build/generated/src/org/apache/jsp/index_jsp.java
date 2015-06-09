package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <title> Bootstrap Testing </title> \n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    \n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write("  <body>\n");
      out.write(" <div class=\"center-block col-md-8 col-xs-12\" style=\"float: none\">\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>                        \n");
      out.write("                </button>\n");
      out.write("            <a class=\"navbar-brand\" href=\"logout.jsp\">Logout</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"registration.jsp\">Registration</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <div class=\"jumbotron\" style=\"text-align: center\">\n");
      out.write("        <h1> Welcome to Smart Home </h1>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"row\">\n");
      out.write(" <div class=\"center-block col-md-8 col-xs-12\" style=\"float: none\">\n");
      out.write("                <h1 class=\"login-title\">Sign in to continue</h1>\n");
      out.write("                  <div class=\"account-wall\">\n");
      out.write("                      <img class=\"profile-img\" src=\"deuces.png\" alt=\"\" width=\"300\" height=\"230\">\n");
      out.write("                      <form class=\"form-signin\" method=\"post\" action=\"login.jsp\">\n");
      out.write("                        \n");
      out.write("                        <label for=\"unameInput\" > Gebruikersnaam </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"uname\" value=\"\" placeholder=\"User Name\" required autofocus>\n");
      out.write("                        <br>\n");
      out.write("                        \n");
      out.write("                        <label for=\"passInput\" > Wachtwoord </label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"pass\" value=\"\" placeholder=\"Password\" required>\n");
      out.write("                        <br>\n");
      out.write("                          <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" value=\"Login\"> Sign in </button>\n");
      out.write("                          <a href=\"#\" class=\"pull-right need-help\"></a>\n");
      out.write("                          <a href=\"registration.jsp\" class=\"pull-left new-account\">Create an account </a>\n");
      out.write("                          <span class=\"clearfix\"></span>\n");
      out.write("                      </form>\n");
      out.write("                  </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>");
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
