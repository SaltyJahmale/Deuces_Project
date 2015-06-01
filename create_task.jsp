<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title> Bootstrap Testing </title> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="ccs/datepicker.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    
    <script type="text/javascript">
      $(document).ready(function() {
        $('#datumInput').datepicker({
          format: "dd/mm/yyyy"
        }); 
      });                 
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
    </div>
    
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title"></h1>
                  <div class="account-wall">
                      <!-- <img class="profile-img" src="deuces.png" alt="" width="300" height="230"> -->
                      <form class="form-signin" method="post" action="add_task.jsp">
                        
                        <label for="taakInput"> Taak </label>
                        <input type="text" class="form-control" name="taak" id="taakInput" value="" required autofocus>
                        <br>
                        
                        <label for="omschrijvingInput"> Omschrijving </label>
                        <input type="text" class="form-control" name="omschrijving" id="omschrijvingInput" value="" required>
                        <br>
                        
                        <label for="datumInput" > Datum </label>
                        <input type="text" class="form-control" name="datum" id="datumInput" value="" required> 
                        <br>
                        
                        <label for="omschrijvingInput"> Categorie </label>
                        <select class="form-control" data-style="btn-primary" name="categorie">
                          <option class="categorie"> Apparaat </option>
                          <option class="categorie"> Werk </option>
                          <option class="categorie"> Belangrijk </option>
                          <option class="categorie"> Prive </option>
                          <option class="categorie"> Sociaal </option>
                        </select>
                        
                          <br>
                          <button class="btn btn-lg btn-primary btn-block" type="submit" value=""> Toevoegen </button>
                          <a href="#" class="pull-right need-help"></a>
                          <a href="show_task.jsp" class="pull-light new-account"> Naar taken </a>
                          <span class="clearfix"></span>
                      </form>
                  </div>
            </div>
        </div>
    </div>
    
    
  </body>
</html>