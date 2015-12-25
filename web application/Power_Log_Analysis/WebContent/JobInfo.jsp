<!DOCTYPE html>
 <%@page import="MainPackage.*"%>
<html>
    <head>
        <title>JOB INFORMATION</title>
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
        
<body>
<form method="get" action="jobDetails.jsp">
<% //String s_item="123";//(String)request.getAttribute("job_id");
//System.out.println(s_item+"hhhh");
JobDriver jd=new JobDriver();
jd.populate();

String s_item="";
 for(Job item: jd.getList()) {
 s_item=item.getJob_id();
 }
request.getSession().setAttribute("job_id",s_item);
System.out.println("s_item"+s_item);
Job j=jd.getJob(s_item);
//response.getWriter().append(""+j); 
%>

		<h1>Job Information</h1>
		<table >
		<tr>
		<th>Job Name</th>
		<th>Job Id</th>
		<th>Job Start Time</th>
		<th>Job End Time</th>
		<th>Job Resources</th>
	    </tr>
		<tr>
	    <td><%=j.getJob_name()%></td>
		<td><%=j.getJob_id()%></td>
		<td><%=j.getJob_start()%></td>
		<td><%=j.getJob_end()%></td>
		<td><%=j.getJob_resources()%></td>
	   </tr>
        </table>

		<br/>
		<br/>
		<input class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Component Details"/> 
		</form>
</body>
</html>