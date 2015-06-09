<%@ page import ="java.sql.*" %>
<%
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
%>