<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@page import="MainPackage.*"%>
<html>
    <head>
        <title>PERFORMANCE INFORMATION</title>
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
<h1 ><font color="#660024">Select a component to view performance Information.</font></h1>

<div>
          <label id="lblSelect">
            <select id="selectPointOfInterest" title="Select Job">
               <option value="1" selected="selected">GPU Performance</option>
        <option value="2">CPU Performance</option>
        <option value="3">SYSTEM Performance</option>
    </select>
            
            
            </label>
            <br/>
           
<button class="btn btn-primary btn-custom btn-lg" type="submit" value="Get Information" onClick="GetSelectedItem('selectPointOfInterest');">Get Information</button> 
<div id="m"></div>

</div>

<script>

var option;
function GetSelectedItem(el)
{
    var e = document.getElementById(el);
    var strSel = "The Value is: " + e.options[e.selectedIndex].value + " and text is: " + e.options[e.selectedIndex].text+"";    	
    if(e.selectedIndex==0)
    	gpu();
    		 
    	if(e.selectedIndex==1)
        	cpu();
        	
        
        if(e.selectedIndex==2)
        	sys();
        	
        	
}

function delet(){
	var div = document.getElementById('m');
	div.innerHTML = '';
}
function gpu(){
	delet();
	var div = document.getElementById('m');
   <% String j_id=(String)request.getSession().getAttribute("job_id"); 
   Power_Perf_Driver pf=new Power_Perf_Driver(j_id);
   pf.populate();
   Power_Perf pfl=pf.getPerf(j_id);
   System.out.println(pfl.getTime_per_iteration());%>
   var f1=<%=(String)pfl.getJob_id()%>;
   var f2=<%=(String)pfl.getperf()%>;
   var f3=<%=(String)pfl.getTime_per_iteration()%>;
   var f4=<%=(String)pfl.getTotal_time()%>;
   div.innerHTML = div.innerHTML +'<h1>GPU PERFORMANCE</h1>'
   div.innerHTML = div.innerHTML +'<table border="1" cellpadding="5"><tr><th>Job ID</th><th>Performance(GFlops/s)</th><th>Time Per Iteration(msec)</th><th>Total Time(msec)</th></tr><tr><td>'+f1+'</td><td>'+f2+'</td><td>'+f3+'</td><td>'+f4+'</td></tr></table>';

}
function cpu(){
	delet();
	var div = document.getElementById('m');
   <% String cj_id=(String)request.getSession().getAttribute("job_id"); 
   CPU_Perf_Driver cpf=new CPU_Perf_Driver(cj_id);
   cpf.populate();
   Power_Perf cpfl=cpf.getPerf(cj_id);
   System.out.println(cpfl.getTime_per_iteration());%>
   var f1=<%=(String)cpfl.getJob_id()%>;
   var f2=<%=(String)cpfl.getperf()%>;
   var f3=<%=(String)cpfl.getTime_per_iteration()%>;
   var f4=<%=(String)cpfl.getTotal_time()%>;
   div.innerHTML = div.innerHTML +'<h1>CPU PERFORMANCE</h1>';
   div.innerHTML = div.innerHTML +'<table border="1" cellpadding="5"><tr><th>Job ID</th><th>Performance(GFlops/s)</th><th>Time Per Iteration(msec)</th><th>Total Time(msec)</th></tr><tr><td>'+f1+'</td><td>'+f2+'</td><td>'+f3+'</td><td>'+f4+'</td></tr></table>';

}
function sys(){
	delet();
	var div = document.getElementById('m');
	div.innerHTML = div.innerHTML +'<h1>SYSTEM PERFORMANCE</h1>';
   <% String sj_id=(String)request.getSession().getAttribute("job_id"); 
   SYS_Perf_Driver spf=new SYS_Perf_Driver(sj_id);
   spf.populate();
   Power_Perf spfl=spf.getPerf(sj_id);
   System.out.println(spfl.getTime_per_iteration());%>
   var f1=<%=(String)spfl.getJob_id()%>;
   var f2=<%=(String)spfl.getperf()%>;
   var f3=<%=(String)spfl.getTime_per_iteration()%>;
   var f4=<%=(String)spfl.getTotal_time()%>;
   
   div.innerHTML = div.innerHTML +'<table border="1" cellpadding="5"><tr><th>Job ID</th><th>Performance(GFlops/s)</th><th>Time Per Iteration(msec)</th><th>Total Time(msec)</th></tr><tr><td>'+f1+'</td><td>'+f2+'</td><td>'+f3+'</td><td>'+f4+'</td></tr></table>';

}
</script>
</body>
</html>