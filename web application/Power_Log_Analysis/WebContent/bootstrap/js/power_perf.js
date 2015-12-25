/**
 * 
 */
var option;
function GetSelectedItem(el)
{
    var e = document.getElementById(el);
    var strSel = "The Value is: " + e.options[e.selectedIndex].value + " and text is: " + e.options[e.selectedIndex].text;
    option = e.options[e.selectedIndex].text;
   alert("hello");
   var tabletag = 
	   '<h1>Job Information</h1><table border="1" cellpadding="5"><tr><th>Job ID</th><th>Power Draw(GFlops/s)</th><th>Time Per Iteration(msec)</th><th>Total Time(msec)</th></tr>'
	   <% String job_id=(String)request.getSession().getAttribute("job_id");
   request.getSession().setAttribute("job_id",job_id);
   %>
   var id='</table><h1>'+job_id+'</h1>';
   $('#m').append(tabletag);
   $('#m').append(id); 
   
   //document.getElementById('#mainDiv').append(tabletag);
}