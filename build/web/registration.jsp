<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  </head>
  <body>
       <div class="center-block col-md-8 col-xs-12" style="float: none">
        <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
                </button>
            <a class="navbar-brand" href="logout.jsp">Logout</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="registration.jsp">Registration</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="jumbotron" style="text-align: center">
        <h1> Welcome to Smart Home </h1>
    </div>


    
        <div class="row">
            <div class="center-block col-xs-12 col-md-8" style="float:none">
                <h1 class="text-center login-title"> Enter information here </h1>
                  <div class="account-wall">
                      <form class="form-signin" method="post" action="register_gebruiker.jsp">
                        
                        <label for="fnameInput" > Voornaam </label>
                        <input type="text" class="form-control" name="fname" value="" placeholder="Name" required autofocus>
                        <br>
                        
                        <label for="lnameInput" > Achternaam </label>
                        <input type="text" class="form-control" name="lname" value="" placeholder="Last Name" required>
                        <br>
                        
                        <label for="emailInput" > E-mail </label>
                        <input type="text" class="form-control" name="email" value="" placeholder="E-mail" required>
                        <br>
                        
                        <label for="unameInput" > Gebruikersnaam </label>
                        <input type="text" class="form-control" name="uname" value="" placeholder="User Name" required>
                        <br>
                        
                        <label for="passInput" > Wachtwoord </label>
                        <input type="password" class="form-control" name="pass" value="" placeholder="Password" required>
                        <br>
                        
                          <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login"> Sign in </button>
                          <a href="#" class="pull-right need-help"></a>
                          <a href="index.jsp" class="pull-left new-account"> Already have an account </a>
                          <span class="clearfix"></span>
                      </form>
                  </div>
            </div>
        </div>
       </div>
  </body>
</html>