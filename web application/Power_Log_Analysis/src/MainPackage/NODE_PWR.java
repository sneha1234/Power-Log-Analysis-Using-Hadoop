package MainPackage;

public class NODE_PWR {
	String job_id;
	String node_id;
	String systimestamp;
	String power_draw;
	
	public NODE_PWR(String job_id, String node_id, String systimestamp, String power_draw) {
		super();
		this.job_id = job_id;
		this.node_id = node_id;
		this.systimestamp = systimestamp;
		this.power_draw = power_draw;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getSystimestamp() {
		return systimestamp;
	}
	public void setSystimestamp(String systimestamp) {
		this.systimestamp = systimestamp;
	}
	public String getPower_draw() {
		return power_draw;
	}
	public void setPower_draw(String power_draw) {
		this.power_draw = power_draw;
	}
}
