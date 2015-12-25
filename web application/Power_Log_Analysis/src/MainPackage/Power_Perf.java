package MainPackage;

public class Power_Perf {
	String job_id;
	String perf;
	String time_per_iteration;
	String total_time;
public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

public String getperf() {
	return perf;
}
public Power_Perf(String id,String perf, String time_per_iteration, String total_time) {
	super();
	this.job_id=id;
	this.perf = perf;
	this.time_per_iteration = time_per_iteration;
	this.total_time = total_time;
}
@Override
public String toString() {
	return "Power_Perf [perf=" + perf + ", time_per_iteration=" + time_per_iteration + ", total_time="
			+ total_time + "]";
}
public void setperf(String perf) {
	this.perf = perf;
}
public String getTime_per_iteration() {
	return time_per_iteration;
}
public void setTime_per_iteration(String time_per_iteration) {
	this.time_per_iteration = time_per_iteration;
}
public String getTotal_time() {
	return total_time;
}
public void setTotal_time(String total_time) {
	this.total_time = total_time;
}
}
