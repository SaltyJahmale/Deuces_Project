<%@ page import ="java.sql.*" %>
<@ include file="login.jsp" %>
<%
    String username = (String)session.getAttribute("userid");
    String user = request.getParameter("taak");    
    String fname = request.getParameter("omschrijving");
    String lname = request.getParameter("datum");
    String email = request.getParameter("categorie");
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb",
            "root", "0000");
    
    
    String selectId = "SELECT * FROM gebruiker WHERE voornaam = 'username'";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(selectId);
    
    int idNummer = rs.getInt("gebruiker_id");
    
    int i = st.executeUpdate("insert into nieuwe_taak(gebruiker_id, taak_naam, omschrijving, datum, categorie) values ('" + idNummer + "', '" + fname + "','" + lname + "','" + email + "','" + user + "')");
    if (i > 0) {
        response.sendRedirect("success.jsp");
    } else {
        response.sendRedirect("index.jsp");
    }
%>