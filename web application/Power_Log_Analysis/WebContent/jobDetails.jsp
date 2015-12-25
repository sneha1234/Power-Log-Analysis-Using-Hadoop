<!DOCTYPE html>
 <%@page import="MainPackage.*"%>
<html>
    <head>
        <title>JOB DETAILS</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- Bootstrap -->
            <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
            <link href="bootstrap/css/new3.css" rel="stylesheet">
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
              <li class="active"><a href="#"><font color="#FFFFFF" size="5">Home</font></a></li>
              <li><a href="#about"><font color="#FFFFFF" size="5">About</font></a></li>
              <li><a href="#contact"><font color="#FFFFFF" size="5">Contact</font></a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><font color="#FFFFFF" size="5">Components</font><span class="caret"></span></a>
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
        
</head>
<body>
<% String job_id=(String)request.getSession().getAttribute("job_id");
request.getSession().setAttribute("job_id",job_id);
%>
<div align="center">
<br>
<br>
<form method="get" action="perf.jsp">
<input class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Performance Information"/> 

</form>
<br>
<br>
<form method="get" action="actv.jsp">
<input class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Activity Information"/> 

</form>
<br>
<br>
<form method="get" action="power.jsp">
<input class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Power Information"/> 

</form>
</div>
</body>
</html>