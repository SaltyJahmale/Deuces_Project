<%@page import="java.sql.*"%>
<%

String id = request.getParameter("id");
int no = Integer.parseInt(id);
int sumcount = 0;
try {

    String urlDatabase = "jdbc:mysql://localhost:3306/jspdb";
    String usrDatabase = "root";
    String pswDatabase = "0000";
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection( urlDatabase, usrDatabase, pswDatabase);

    Statement st = con.createStatement();
    st.executeUpdate("DELETE FROM nieuwe_taak WHERE nieuwe_taak_id = '"+no+"'");
    response.sendRedirect("show_task.jsp");
}
catch(Exception e){}
%>