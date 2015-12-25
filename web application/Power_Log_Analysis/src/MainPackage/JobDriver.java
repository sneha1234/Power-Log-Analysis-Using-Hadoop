package MainPackage;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
 
public class JobDriver {
  private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	static List<Job> item_List = new ArrayList<Job>();

	public List<Job> getList(){
		
		return item_List;
	}
  public void populate() throws SQLException {
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
     
      e.printStackTrace();
      System.exit(1);
    }
    
    Connection con = DriverManager.getConnection("jdbc:hive://192.168.100.101:10000/Power", "", "");
    Statement stmt = con.createStatement();
   
    String tableName = "job_info";
   
String sql = "use Power";
System.out.println("Running: " + sql);
 ResultSet res = stmt.executeQuery(sql);
    while (res.next()) {
      System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
    }
    sql = "select * from job_info";
    System.out.println("Running: " + sql);
  res = stmt.executeQuery(sql);
    while (res.next()) {
    	System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
    	if(!checkIfPresent(String.valueOf(String.valueOf(res.getString(2))))){
      
      item_List.add(new Job(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),String.valueOf(res.getString(4)),String.valueOf(res.getString(5))));
    	}
    }
 
   
  }
  public boolean checkIfPresent(String id){
	  System.out.println("in check ");
	  for (Job j : item_List) {
	 System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_id().equals(id)){
			  
			 return true;
		  }
			  
	  }
	  return false;
  }
  public Job getJob(String id){
	  for (Job j : item_List) {
		 // System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_id().equals(id)){
			  
			 return j;
		  } 
		 
  }
	  return null;  	  
}
}