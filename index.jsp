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
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="logout.jsp"> Logout </a>
        </div>
        <div>
          <ul class="nav navbar-nav">
            <li><a href="#"></a></li>
            <li><a href="index.jsp"> Home </a></li>
            <li><a href="registration.jsp"> Registration  </a></li>
            <li><a href="#"></a></li>
          </ul>
        </div>
      </div>
    </nav>
        
    <div class="container">
      <div class="jumbotron">
        <h1>Welcome to Smart Home</h1>
      </div>
    </div>
    
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Sign in to continue</h1>
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