<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title> Bootstrap Testing </title> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    
    
  <script>
      function deleteRecord(id) {
      var f = document.form;
      f.method = "post";
      f.action = 'delete.jsp?id=' + id;
      f.submit();
    }
  </script>
    
    
  </head>
  <body>
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="logout.jsp"> Logout </a>
        </div>
        <div>
          <ul class="nav navbar-nav">
            <li><a href="#"></a></li>
            <li><a href="create_task.jsp"> Taak aanmaken </a></li>
            <li><a href="show_task.jsp"> Taak weergeven </a></li>
            <li><a href="#"></a></li>
          </ul>
        </div>
      </div>
    </nav>
        
    <div class="container">
      <div class="jumbotron">
        <h1> Welcome to Smart Home </h1>
      </div>
      
      <h1> Taken </h1>

        <%    
            String urlDatabase = "jdbc:mysql://localhost:3306/jspdb";
            String usrDatabase = "root";
            String pswDatabase = "0000";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( urlDatabase, usrDatabase, pswDatabase);
            
            String userId = (String) session.getAttribute("userid");
            
            String sql = "SELECT gebruiker_id FROM gebruiker WHERE voornaam = '" + userId + "'";
            PreparedStatement ps = con.prepareStatement(sql);     
            ps.execute();
            
            ResultSet rs = ps.executeQuery();
            int getUserKey = 0;
            if (rs.next()) {
                getUserKey = rs.getInt(1);
            }
            
            ResultSet resultset = ps.executeQuery("SELECT * FROM nieuwe_taak WHERE gebruiker_id = '" + getUserKey +"' ");
            
          
        %>
      <form method="post" name="form">
        <table class="table table-bordered">
            <tr>
                <th>Taak</th>
                <th>Datum</th>
                <th>Omschrijving</th>
                <th>Categorie</th>
                
            </tr>
            
            <%           
                while(resultset.next()) { 
                    %>
                        <tr>
                            <td>
                                <%= resultset.getString(6) %>  
                            </td>
                            <td>
                                <%= resultset.getString(4) %> 
                            </td>
                            <td>
                                <%= resultset.getString(5) %> 
                            </td>
                            <td>
                                <%= resultset.getString(3) %> 
                            </td>
                            <td>
                                <input type="button" name="delete" value="Delete" onclick="deleteRecord(<%=resultset.getString(1)%>);" >
                            </td>
                        </tr>
                    <%
                }
            %>
        </table>
      </form>
    </div>
    
  </body>
</html>