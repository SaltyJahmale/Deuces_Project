<%-- 
    Document   : newjsp
    Created on : 10-mrt-2015, 20:39:29
    Author     : Yusuf
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Log in</title>
        <link href="styles/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@ page import="MyPackage.*" %> 
        <% 
            String firstName = request.getParameter("firstName"); 
            String lastName = request.getParameter("lastName"); 
            String email = request.getParameter("email"); 

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);        
        %>
        <div class="row">
            <div class="center-block col-md-8 col-xs-12" style="float: none">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>                        
                            </button>
                            <a class="navbar-brand" href="CreateUser.html">Home</a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li><a href="ShowTask.jsp">Dashboard</a></li>
                                <li><a href="CreateTask.jsp">Nieuwe taak</a></li>

                            </ul>
                        </div>
                    </div>
                </nav>
                <h2>Welkom <%= firstName %> </h2>
                <table class="table table-condensed table-bordered table-hover table-striped no-margin">
                    <thead>
                    <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= user.getFirstName() %></td>
                            <td><%= user.getLastName() %></td>
                            <td><%= user.getEmail() %></td>
                        </tr>
                        <tr>
                            <td><span class="label label-info">Werk</span></td>
                            <td><span class="label label-default">Apparaat</span></td>
                            <td><span class="label label-danger">Belangrijk</span></td>
                        </tr>
                        <tr>
                            <td><span class="label label-primary">Privé</span></td>
                            <td><span class="label label-success">Sociaal</span></td>
                        </tr>
                    </tbody>

                </table>
                <p></p>
                <table class="table table-condensed table-bordered table-hover table-striped no-margin">
                    <thead>
                        <tr>
                            <th style="width: 10%">Gereed</th>
                            <th style="width: 30%">Taak</th>
                            <th style="width: 25%">Omschrijving</th>
                            <th style="width: 20%">Datum</th>
                            <th style="width: 10%">Categorie</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input class="no-margin" type="checkbox">
                            </td>  
                            <td class="hidden-print">Haal kinderen op</td>
                            <td class="hidden-print">School sluit om 14.00</td>
                            <td class="hidden-print"><%= new Date() %> </td>
                                    <td class="hidden-print"><span class="label label-danger">
                                Belangrijk
                                </span></td>
                        </tr>
                        <tr>
                            <td class="hidden-print">
                                <input class="no-margin" type="checkbox">
                            </td>
                            <td class="hidden-print">Zet televisie aan</td>
                            <td class="hidden-print">Sony Brava KDL-40WD</td>
                            <td class="hidden-print"><%= new Date() %> </td>
                                    <td class="hidden-print"><span class="label label-default">
                                Apparaat
                                </span></td>
                        </tr>
                        <tr>
                            <td class="hidden-print">
                                <input class="no-margin" type="checkbox">
                            </td>
                            <td class="hidden-print">Vind feesten voor het weekend</td>
                            <td class="hidden-print">Genre House of Salsa in regio Rotterdam</td>
                            <td class="hidden-print"><%= new Date() %> </td>
                                    <td class="hidden-print"><span class="label label-success">
                                Sociaal
                                </span></td>
                        </tr>
                    </tbody>
                </table>
                <div class="pull-right">
                    <button type="submit" class="btn btn-default" 
                            onclick="location.href='CreateTask.jsp'">Maak nieuwe taak</button>
                    
                </div>
             </div>
        </div>
    </body>
</html>
