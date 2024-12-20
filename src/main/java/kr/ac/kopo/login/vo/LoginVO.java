package kr.ac.kopo.login.vo;

public class LoginVO {
	String log_id;
	String log_pw;
	
	
	public LoginVO() {
	}
	public LoginVO(String log_id, String log_pw) {
		this.log_id = log_id;
		this.log_pw = log_pw;
	}
	public String getLog_id() {
		return log_id;
	}
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}
	public String getLog_pw() {
		return log_pw;
	}
	public void setLog_pw(String log_pw) {
		this.log_pw = log_pw;
	}
	@Override
	public String toString() {
		return "LoginVO [log_id=" + log_id + ", log_pw=" + log_pw + "]";
	}
}
