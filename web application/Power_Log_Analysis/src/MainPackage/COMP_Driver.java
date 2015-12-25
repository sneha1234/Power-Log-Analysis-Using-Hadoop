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
 
public class COMP_Driver {
	String job_id;
  public COMP_Driver(String job_id) {
		super();
		this.job_id = job_id;
	}



private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	static List<COMP_PWR> item_List = new ArrayList<COMP_PWR>();

	public List<COMP_PWR> getList(){
		
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
   
    String tableName = "cmp_pwr";
   
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
    	if(!checkIfPresent(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),String.valueOf(res.getString(4)),String.valueOf(res.getString(5)),String.valueOf(res.getString(6)))){
      
      item_List.add(new COMP_PWR(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),String.valueOf(res.getString(4)),String.valueOf(res.getString(5)),String.valueOf(res.getString(6))));
      
    	}
    	
    }
 
    createTSVFile("/home/sneha-ubuntu/workspace/Power_Log_Analysis/WebContent/sample3.tsv"); 
  }
  public boolean checkIfPresent(String id,String time,String ppkg,String pp0,String pdram,String pkg8){
	  System.out.println("in check ");
	  for (COMP_PWR j : item_List) {
	// System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if ((j.getJob_info().equals(id))&&(j.getTime().equals(time)&&(j.getP_PKG().equals(ppkg)))&&((j.getP_PP0()).equals(pp0))&&((j.getP_DRAM()).equals(pdram))&&((j.getP_PKG_8()).equals(pkg8)))
				  {
			  
			 return true;
		  }
			  
	  }
	  return false;
  }
  public COMP_PWR getJob(String id){
	  for (COMP_PWR j : item_List) {
		 // System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_info().equals(id)){
			  
			 return j;
		  } 
		 
  }
	  return null;  	  
}


	
	private static void createTSVFile(String filename) throws IOException {
		File file = new File(filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String s="Time\tCore\tP_PKG\tP_PP0\tP_DRAM\tCore\tP_PKG_8\n";
		bw.write(s);
		for (COMP_PWR j:item_List){
			
		s=j.getTime();
		bw.write(s);
		bw.write("\t");
		s="0";
		bw.write(s);
		bw.write("\t");
		s=j.getP_PKG();
		bw.write(s);
		bw.write("\t");
		s=j.getP_PP0();
		bw.write(s);
		bw.write("\t");
		s=j.getP_DRAM();
		bw.write(s);
		bw.write("\t");
		s="8";
		bw.write(s);
		bw.write("\t");
		s=j.getP_PKG_8();
		bw.write(s);
		bw.write("\t");
		bw.write("\n");
		}
		bw.close();
	}
	
}
