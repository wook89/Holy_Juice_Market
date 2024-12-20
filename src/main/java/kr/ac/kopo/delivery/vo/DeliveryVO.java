package kr.ac.kopo.delivery.vo;

public class DeliveryVO {
	int delivery_no;
	int user_no;
	String addr;
	String detail_addr;
	String postal_code;
	String alias;
	String is_default;
	
	public DeliveryVO() {
	}
	
	public DeliveryVO(int user_no, String addr, String detail_addr, String postal_code, String alias) {
		this.user_no = user_no;
		this.addr = addr;
		this.detail_addr = detail_addr;
		this.postal_code = postal_code;
		this.alias = alias;
	}

	public DeliveryVO(int delivery_addr_no, int user_no, String addr, String detail_addr, String postal_code,
			String alias) {
		this.delivery_no = delivery_addr_no;
		this.user_no = user_no;
		this.addr = addr;
		this.detail_addr = detail_addr;
		this.postal_code = postal_code;
		this.alias = alias;
	}

	public int getDelivery_no() {
		return delivery_no;
	}

	public void setDelivery_no(int delivery_addr_no) {
		this.delivery_no = delivery_addr_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDetail_addr() {
		return detail_addr;
	}

	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getIs_default() {
		return is_default;
	}

	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}
	@Override
	public String toString() {
		return "DeliveryVO [delivery_addr_no=" + delivery_no + ", user_no=" + user_no + ", addr=" + addr
				+ ", detail_addr=" + detail_addr + ", postal_code=" + postal_code + ", alias=" + alias + ", is_default="
				+ is_default + "]";
	}
}
