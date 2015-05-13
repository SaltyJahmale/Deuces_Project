<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb",
            "root", "0000");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from gebruiker where gebruiker_naam='" + userid + "' and wachtwoord='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        response.sendRedirect("CreateTask.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>