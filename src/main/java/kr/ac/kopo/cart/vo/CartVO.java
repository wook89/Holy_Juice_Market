package kr.ac.kopo.cart.vo;

public class CartVO {
	int user_no;
	int item_cd;
	int qty;
	int price;
	int delivery_no;
	int line_no;
	
	String item_name;
	String img_url;
	
	public CartVO() {
	}
	public CartVO(int user_no, int item_cd, int qty) {
		this.user_no = user_no;
		this.item_cd = item_cd;
		this.qty = qty;
	}
	
	public CartVO(int user_no, int item_cd, int qty, int price, String item_name, String img_url) {
		this.user_no = user_no;
		this.item_cd = item_cd;
		this.qty = qty;
		this.price = price;
		this.item_name = item_name;
		this.img_url = img_url;
	}
	public CartVO(int user_no, int item_cd) {
		this.user_no = user_no;
		this.item_cd = item_cd;
	}
	public int getDelivery_no() {
		return delivery_no;
	}
	public void setDelivery_no(int delivery_no) {
		this.delivery_no = delivery_no;
	}
	public CartVO(int user_no, int item_cd, int qty, int price, int addr_no, String item_name, String img_url) {
		this.user_no = user_no;
		this.item_cd = item_cd;
		this.qty = qty;
		this.price = price;
		this.item_name = item_name;
		this.img_url = img_url;
	}
	public int getLine_no() {
		return line_no;
	}
	public void setLine_no(int line_no) {
		this.line_no = line_no;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Override
	public String toString() {
		return "CartVO [user_no=" + user_no + ", item_cd=" + item_cd + ", qty=" + qty + ", price=" + price
				+ ", delivery_no=" + delivery_no + ", line_no=" + line_no + ", item_name=" + item_name + ", img_url="
				+ img_url + "]";
	}
}
