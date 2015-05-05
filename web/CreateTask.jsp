

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "j4kdemo.simpleexample.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maak nieuwe taak</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="styles/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <style>
            .Prio1 {
                background: #5BC0DE;
                color: #FFF
            }
            .Prio2 {
                background: #777;
                color: #FFF
            }
            .Prio3 {
                background: #d9534f;
                color: #FFF
            }
            .Prio4 {
                background: #337ab7;
                color: #FFF
            }
            .Prio5 {
                background: #5cb85c;
                color: #FFF
            }
            
        </style>
    </head>
    <body>        
        <div class="container">
            <div class="center-block col-md-8 col-xs-12" style="float: none">
                <nav class="navbar navbar-inverse">
                    <div class="container">
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
                <h2>Maak nieuwe taak</h2>

                <form action="ShowTask.jsp" method="GET">
                    <div class="form-group">
                        <label for="inputTName">Taak</label>
                        <input type="text" class="form-control" id="inputTName" 
                               placeholder="Voor naam van taak in" name="inputTName">
                    </div>
                    <div class="form-group">
                        <label for="inputTDesc">Omschrijving</label>
                        <input type="text" class="form-control" id="inputTDesc" 
                               placeholder="Voor omschrijving van taak in" name="inputTDesc">
                    </div>
                    <div class="form-group">
                        <label for="inputTDate">Datum</label>
                        <input type="text" class="form-control" id="inputTDate" 
                               placeholder="DD/MM/JJJJ" name="inputTDate">
                    </div>
                    <div class="form-group" style="font-weight: bold ">
                        <label for="inputCat">Categorie</label>
                        <select class="form-control" name="inputCat">
                            <option class="Prio1">Apparaat</option>
                            <option class="Prio2">Werk</option>
                            <option class="Prio3">Belangrijk</option>
                            <option class="Prio4">Privé</option>
                            <option class="Prio5">Sociaal</option>

                        </select>
                    </div>
                    <p>     
                        <div class="pull-right">
                            <button type="submit" class="btn btn-default">Verzend</button>
                        </div>
                </form>
<% %>
            </div>
        </div>
    </body>
</html>
