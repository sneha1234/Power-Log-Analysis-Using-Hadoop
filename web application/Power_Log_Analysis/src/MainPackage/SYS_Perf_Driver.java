package MainPackage;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
 
public class SYS_Perf_Driver {
	private String job_id;
  public SYS_Perf_Driver(String job_id) {
		super();
		this.job_id = job_id;
	}
private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	static List<Power_Perf> item_List = new ArrayList<Power_Perf>();

	public List<Power_Perf> getList(){
		
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
   
    String tableName = "sys_perf";
   
String sql = "use Power";
System.out.println("Running: " + sql);
 ResultSet res = stmt.executeQuery(sql);
    while (res.next()) {
      System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
    }
    sql = "select * from "+tableName;
    System.out.println("Running: " + sql);
  res = stmt.executeQuery(sql);
    while (res.next()) {
    	System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
    	if(String.valueOf(res.getString(1)).equals(job_id))
    	if(!checkIfPresent(String.valueOf(String.valueOf(res.getString(1))))){
      
      item_List.add(new Power_Perf(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),String.valueOf(res.getString(4))));
      }
    }
 
   
  }
  public boolean checkIfPresent(String id){
	  System.out.println("in check ");
	  for (Power_Perf j : item_List) {
	 System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_id().equals(id)){
			  
			 return true;
		  }
			  
	  }
	  return false;
  }
  public Power_Perf getPerf(String id){
	  for (Power_Perf j : item_List) {
		 // System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_id().equals(id)){
			  
			 return j;
		  } 
		 
  }
	  return null;  	  
}
}