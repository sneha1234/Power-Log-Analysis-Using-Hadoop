<!DOCTYPE html>
<html>
    <head>
        <title>Power Log Analysis</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- Bootstrap -->
            <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
            <link href="bootstrap/css/new.css" rel="stylesheet">
    </head>
    <body>
     
         <nav  class="navbar navbar-default">
        <div  class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
           
          </div>
          <div align="center" class="navbar-collapse collapse navbar-custom">
            <ul  class="nav navbar-nav" >
              <li class="active"><a href="#"><font color="#660024" size="5">Home</font></a></li>
              <li><a href="#about"><font color="#660024" size="5">About</font></a></li>
              <li><a href="#contact"><font color="#660024" size="5">Contact</font></a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><font color="#660024" size="5">Components</font><span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#"><font color="#660024" size="5">Job Info</font></a></li>
                  <li><a href="#"><font color="#660024" size="5">Performance Info</font></a></li>
                  <li><a href="#"><font color="#660024" size="5">Activity Info</font></a></li>
                  <li><a href="#"><font color="#660024" size="5">Power Info</font></a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </nav>
         
         <div align="center" class="container">
            <div class="jumbotron">
              <h1 align="center"><font color="white">Power Log Analysis</font></h1>
              <p class="lead"><font color="white">This application provides users with decomposed power data collected from log files.</font></p>
              <form method="get" action="job.jsp">
            <input class="btn btn-primary btn-custom btn-lg" type="submit" value="Start Analysis"/> 
             </form>
            </div>

        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>