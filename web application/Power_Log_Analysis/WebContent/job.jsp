<!DOCTYPE html>
 <%@page import="MainPackage.*"%>
<html>
    <head>
        <title>JOB LIST</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- Bootstrap -->
            <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
            <link href="bootstrap/css/new1.css" rel="stylesheet">
    </head>
    <body>
     <% JobDriver jd = new JobDriver();
jd.populate();
System.out.println("calling jobdriver");%>


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
        
               <form action="JobInfo.jsp" method="get">
          <label id="lblSelect">
            <select id="selectPointOfInterest" title="Select Job">
                <% for(Job item : jd.getList()) {%>
<option value='<%=item.getJob_id()%>'><%=item.getJob_id() %></option>
		<%request.getSession().setAttribute("job_id",item.getJob_id());}%>
            
            </select>
            
            </label>
           
<input class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Job Information"/> 
</form>
       

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>