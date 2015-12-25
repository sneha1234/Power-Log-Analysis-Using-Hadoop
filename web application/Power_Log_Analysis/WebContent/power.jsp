<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@page import="MainPackage.*"%>
<html>
    <head>
        <title>POWER INFORMATION</title>
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
<h1 ><font color="#660024">Select a component to view Power Information.</font></h1><div>
    <br/>
    <a href="GPU.html"><button class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Information"  onClick="gpu();">GPU POWER</button></a>
    
        <a href="comp.html"><button class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Information"  onClick="cpu();">COMPONENT POWER</button> </a>
    
    
        <a href="node.html"><button class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Information"  onClick="node();">NODE POWER</button> </a>
    
    
</div>
<script>

function gpu(){
   <% String j_id=(String)request.getSession().getAttribute("job_id"); 
  GPU_PWR_Driver jpd =new GPU_PWR_Driver(j_id);
   jpd.populate();%>  
 }
function comp(){
   
}
function node(){
   <% String sj_id=(String)request.getSession().getAttribute("job_id"); 
   NODE_PWR_Driver spf=new NODE_PWR_Driver(sj_id);
   spf.populate();%>
}
</script>
</body>
</html>