<%@ page import ="java.sql.*" %>
<%
  String urlDatabase = "jdbc:mysql://localhost:3306/jspdb";
  String usrDatabase = "root";
  String pswDatabase = "0000";
    
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection( urlDatabase, usrDatabase, pswDatabase);
   
  String userid = request.getParameter("uname");    
  String pwd = request.getParameter("pass");
    
  Statement st = con.createStatement();
  ResultSet rs;
  rs = st.executeQuery("SELECT * FROM gebruiker WHERE gebruiker_naam='" + userid + "' AND wachtwoord='" + pwd + "'");
  if (rs.next()) {
    session.setAttribute("userid", userid);
    response.sendRedirect("create_task.jsp");
  } else {
    out.println("Invalid password <a href='index.jsp'>try again</a>");
  }
%>