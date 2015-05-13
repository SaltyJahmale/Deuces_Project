<%@ page import="java.sql.*" %>
<HTML>
    <HEAD>
        <TITLE>The tableName Database Table </TITLE>
    </HEAD>

    <BODY>
        <H1>The tableName Database Table </H1>

        <% 
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb",
            "root", "0000");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from nieuwe_taak") ; 
        %>

        <TABLE BORDER="1">
            <TR>
                <TH>ID</TH>
                <TH>Name</TH>
                <TH>City</TH>
                <TH>State</TH>
                <TH>Country</TH>
            </TR>
            <%
            
            while(resultset.next()){
            
            %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(3) %></TD>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
            </TR>
            <% }
            
            %>
        </TABLE>
    </BODY>
</HTML>