<%@ page import="java.sql.*" %>
<%@ page import="java.sql.DriverManager.*" %>

<%
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
%>   