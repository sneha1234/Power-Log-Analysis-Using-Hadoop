package MainPackage;

public class Job {
String job_name;
String job_id;
String job_start;
String job_end;
String job_resources;
public Job(){}
public Job(String job_name, String job_id, String job_start, String job_end, String job_resources) {
	this.job_name = job_name;
	this.job_id = job_id;
	this.job_start = job_start;
	this.job_end = job_end;
	this.job_resources = job_resources;
}

public String getJob_name() {
	return job_name;
}
public void setJob_name(String job_name) {
	this.job_name = job_name;
}
@Override
public String toString() {
	return "Job [job_name=" + job_name + ", job_id=" + job_id + ", job_start=" + job_start + ", job_end=" + job_end
			+ ", job_resources=" + job_resources + "]";
}
public String getJob_id() {
	return job_id;
}
public void setJob_id(String job_id) {
	this.job_id = job_id;
}
public String getJob_start() {
	return job_start;
}
public void setJob_start(String job_start) {
	this.job_start = job_start;
}
public String getJob_end() {
	return job_end;
}
public void setJob_end(String job_end) {
	this.job_end = job_end;
}
public String getJob_resources() {
	return job_resources;
}
public void setJob_resources(String job_resources) {
	this.job_resources = job_resources;
}


}
