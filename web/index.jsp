<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title> INFPRJ0178 - HOME </title> 
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
            <a class="navbar-brand" href="index.jsp">Deuces</a>
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
 <div class="center-block col-md-8 col-xs-12" style="float: none">
                <h1 class="login-title">Sign in to continue</h1>
                  <div class="account-wall">
                      <img class="profile-img" src="deuces.png" alt="" width="300" height="230">
                      <form class="form-signin" method="post" action="login.jsp">
                        
                        <label for="unameInput" > Gebruikersnaam </label>
                        <input type="text" class="form-control" name="uname" value="" placeholder="User Name" required autofocus>
                        <br>
                        
                        <label for="passInput" > Wachtwoord </label>
                        <input type="password" class="form-control" name="pass" value="" placeholder="Password" required>
                        <br>
                          <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login"> Sign in </button>
                          <a href="#" class="pull-right need-help"></a>
                          <a href="registration.jsp" class="pull-left new-account">Create an account </a>
                          <span class="clearfix"></span>
                      </form>
                  </div>
            </div>
        </div>
    </div>
  </body>
</html>