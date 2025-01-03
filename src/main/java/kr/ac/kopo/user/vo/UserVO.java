package kr.ac.kopo.user.vo;

public class UserVO {
	private int user_no;
	private String user_id;
	private String password;
	private String user_name;
	private String email;
	private String phone;
	private String type;
	private String created;
	private String updated;

	public UserVO() {
	}

	
	public UserVO(String user_id, String password, String user_name, String email, String phone) {
		this.user_id = user_id;
		this.password = password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
	}
	
	public UserVO(int user_no,String user_id, String password, String user_name, String email, String phone) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.password = password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
	}


	public UserVO(int user_no, String user_id, String user_name, String email, String password, String phone, String type) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.type = type;
	}

	public UserVO(int user_no, String user_id, String user_name, String email, String password, String phone,
			 String type, String created, String updated) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.type = type;
		this.created = created;
		this.updated = updated;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "UserVO [user_no=" + user_no + ", user_id=" + user_id + ", password=" + password + ", user_name="
				+ user_name + ", email=" + email + ", phone=" + phone + ", type=" + type
				+ ", created=" + created + ", updated=" + updated + "]";
	}
}
