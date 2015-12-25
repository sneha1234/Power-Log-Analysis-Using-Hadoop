package MainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
 
public class GPU_PWR_Driver {
	String job_id;
  public GPU_PWR_Driver(String job_id) {
		super();
		this.job_id = job_id;
	}



private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	static List<GPU_PWR> item_List = new ArrayList<GPU_PWR>();

	public List<GPU_PWR> getList(){
		
		return item_List;
	}
  public void populate() throws SQLException, IOException {
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
     
      e.printStackTrace();
      System.exit(1);
    }
    
    Connection con = DriverManager.getConnection("jdbc:hive://192.168.100.101:10000/Power", "", "");
    Statement stmt = con.createStatement();
   
    String tableName = "gpu_pwr";
   
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
    	if(!checkIfPresent(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)))){
      
      item_List.add(new GPU_PWR(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3))));
      
    	}
    	
    }
 
    createTSVFile("/home/sneha-ubuntu/workspace/Power_Log_Analysis/WebContent/GPU_graph_1.tsv"); 
  }
  public boolean checkIfPresent(String id,String timestamp,String power_draw){
	  System.out.println("in check ");
	  for (GPU_PWR j : item_List) {
	// System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if ((j.getJob_id().equals(id))&&(j.getSystimestamp().equals(timestamp)&&(j.getPower_draw().equals(power_draw))))
				  {
			  
			 return true;
		  }
			  
	  }
	  return false;
  }
  public GPU_PWR getJob(String id){
	  for (GPU_PWR j : item_List) {
		 // System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_id().equals(id)){
			  
			 return j;
		  } 
		 
  }
	  return null;  	  
}


	
	private static void createTSVFile(String filename) throws IOException {
		File file = new File(filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (GPU_PWR j:item_List){
			
		String s=j.getSystimestamp();
		bw.write(s);
		bw.write("\t");
		s=j.getPower_draw();
		bw.write(s);
		bw.write("\n");
		}
		bw.close();
	}
	
}
