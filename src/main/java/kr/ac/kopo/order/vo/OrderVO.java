package kr.ac.kopo.order.vo;

import kr.ac.kopo.cart.vo.CartVO;

public class OrderVO {
	int user_no;
	int item_cd;
	int qty;
	int price;
	int delivery_no;
	int line_no;//시퀀스 증가(order_id + line_no)복합키
	
	int order_id;
	String delivery_date;
	String delivery_type;
	String img_url;
	String item_name;
	

	
	public OrderVO(int user_no, int item_cd, int qty, String delivery_date, String delivery_type) {
		this.user_no = user_no;
		this.item_cd = item_cd;
		this.qty = qty;
		this.delivery_date = delivery_date;
		this.delivery_type = delivery_type;
	}
	public OrderVO(int user_no, int item_cd, int qty) {
		this.user_no = user_no;
		this.item_cd = item_cd;
		this.qty = qty;
	}
	
	public OrderVO(int user_no, int item_cd, int qty, String img_url, String item_name, int price) {
		this.user_no = user_no;
		this.item_cd = item_cd;
		this.qty = qty;
		this.img_url = img_url;
		this.item_name = item_name;
		this.price = price;
	}
	public int getDelivery_no() {
		return delivery_no;
	}
	public void setDelivery_no(int delivery_no) {
		this.delivery_no = delivery_no;
	}
	public int getLine_no() {
		return line_no;
	}
	public void setLine_no(int line_no) {
		this.line_no = line_no;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public OrderVO() {
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getItem_cd() {
		return item_cd;
	}
	public void setItem_cd(int item_cd) {
		this.item_cd = item_cd;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}

	
	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", line_no=" + line_no + ", user_no=" + user_no + ", item_cd="
				+ item_cd + ", qty=" + qty + ", delivery_no=" + delivery_no + ", delivery_date=" + delivery_date
				+ ", delivery_type=" + delivery_type + ", img_url=" + img_url + ", item_name=" + item_name + ", price="
				+ price + "]";
	}
	public static OrderVO from(CartVO cartVO) {
		return new OrderVO(cartVO.getUser_no(),cartVO.getItem_cd(),cartVO.getQty(),cartVO.getImg_url(),cartVO.getItem_name(),cartVO.getPrice());
	}
}


