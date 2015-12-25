package MainPackage;

public class COMP_PWR {
	String job_info;
	String time;
	String P_PKG;
	String P_PP0;
	String P_DRAM;
	String 	P_PKG_8;
	
	public COMP_PWR(String job_info, String time, String p_PKG, String p_PP0, String p_DRAM, String p_PKG_8) {
		super();
		this.job_info = job_info;
		this.time = time;
		P_PKG = p_PKG;
		P_PP0 = p_PP0;
		P_DRAM = p_DRAM;
		P_PKG_8 = p_PKG_8;
	}
	public String getJob_info() {
		return job_info;
	}
	public void setJob_info(String job_info) {
		this.job_info = job_info;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getP_PKG() {
		return P_PKG;
	}
	public void setP_PKG(String p_PKG) {
		P_PKG = p_PKG;
	}
	public String getP_PP0() {
		return P_PP0;
	}
	public void setP_PP0(String p_PP0) {
		P_PP0 = p_PP0;
	}
	public String getP_DRAM() {
		return P_DRAM;
	}
	public void setP_DRAM(String p_DRAM) {
		P_DRAM = p_DRAM;
	}
	public String getP_PKG_8() {
		return P_PKG_8;
	}
	public void setP_PKG_8(String p_PKG_8) {
		P_PKG_8 = p_PKG_8;
	}
	
}
