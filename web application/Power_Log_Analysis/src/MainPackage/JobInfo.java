package MainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JobInfo
 */
@WebServlet(description = "Gets Information related to selected job", urlPatterns = { "/JobInfo" })
public class JobInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public JobInfo() throws IOException {
        super();
        // TODO Auto-generated constructor stub
        createTSVFile("/home/sneha-ubuntu/workspace/Power_Log_Analysis/src/MainPackage/sample.tsv");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//RequestDispatcher dispatcher=request.getRequestDispatcher("/JobInfo.jsp");
        //Set the customer instance into request.Then only the customer object 
        //will be available in the Welcome.jsp page
		
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private static void createTSVFile(String filename) throws IOException {
		File file = new File(filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String s="abc";
		bw.write(s);
		bw.write("\t");
		s="defghijkl";
		bw.write(s);
		bw.write("\t");
		bw.write("\n");
		bw.write(s);
		bw.write("\t");
		bw.write(s);
		bw.write("\t");
		bw.close();
		}
}
