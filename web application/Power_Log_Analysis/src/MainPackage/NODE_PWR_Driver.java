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
 
public class NODE_PWR_Driver {
	String job_id;
	
  public NODE_PWR_Driver(String job_id) {
		super();
		this.job_id = job_id;
	}



private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	static List<NODE_PWR> item_List = new ArrayList<NODE_PWR>();

	public List<NODE_PWR> getList(){
		
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
   
    String tableName = "node_pwr";
   
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
    	//System.out.println(""+String.valueOf(res.getString(1))+","+String.valueOf(res.getString(2))+","+String.valueOf(res.getString(3))+","+String.valueOf(res.getString(4)));
    	if(!checkIfPresent(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),String.valueOf(res.getString(4))))
        {
    		NODE_PWR n=new NODE_PWR(String.valueOf(res.getString(1)),String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),String.valueOf(res.getString(4)));
    	      
      item_List.add(n);
       	}
    	
    }
    createTSVFile();
   
  }
  public boolean checkIfPresent(String id,String node_id,String timestamp,String power_draw){
	  System.out.println("in check ");
	  for (NODE_PWR j : item_List) {
	// System.out.println("j.getNode():"+j.getJob_id()+"id:"+id);
		  if ((j.getJob_id().equals(id))&&(j.getNode_id().equals(node_id))&&(j.getSystimestamp().equals(timestamp)&&(j.getPower_draw().equals(power_draw))))
				  {
			  
			 return true;
		  }
			  
	  }
	  return false;
  }
  public NODE_PWR getJob(String id){
	  for (NODE_PWR j : item_List) {
		 // System.out.println("j.getJob_id():"+j.getJob_id()+"id:"+id);
		  if (j.getJob_id().equals(id)){
			  
			 return j;
		  } 
		 
  }
	  return null;  	  
}


	
	private static void createTSVFile() throws IOException {
		File file = new File("/home/sneha-ubuntu/workspace/Power_Log_Analysis/WebContent/node1.tsv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		File file2 = new File("/home/sneha-ubuntu/workspace/Power_Log_Analysis/WebContent/node2.tsv");
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
		String s="Node\tTime\tPower\n";
		bw.write(s);
		bw2.write(s);
		for (NODE_PWR j:item_List){
		System.out.println((""+j.getJob_id()+","+j.getNode_id()+","+j.getSystimestamp()+","+j.getPower_draw()));
		if(j.getNode_id().equals("n01"))	{  
		s=j.getNode_id();
		bw.write(s);
		bw.write("\t");
		s=j.getSystimestamp();
		bw.write(s);
		bw.write("\t");
		s=j.getPower_draw();
		bw.write(s);
		bw.write("\n");
		}
		else
		{
			s=j.getNode_id();
			bw2.write(s);
			bw2.write("\t");
			s=j.getSystimestamp();
			bw2.write(s);
			bw2.write("\t");
			s=j.getPower_draw();
			bw2.write(s);
			bw2.write("\n");	
		}
		
	}
		bw.close();
		bw2.close();
}
}
