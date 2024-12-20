package kr.ac.kopo.item.vo;

public class ItemVO {
	int item_cd;
	String item_name;
	String description;
	int price;
	int stock;
	int category_id;
	String create_at;
	String update_at;
	String img_url;
	
	String category_name;
	
	public ItemVO() {
	}
	public ItemVO(String item_name, String description, int price) {
		this.item_name = item_name;
		this.description = description;
		this.price = price;
	}
	public ItemVO(int item_cd, String item_name, String description, int price, int stock, int category_id,
			String img_url) {
		super();
		this.item_cd = item_cd;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.category_id = category_id;
		this.img_url = img_url;
	}
	public ItemVO(String item_name, String description, int price, int stock, int category_id) {
		super();
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.category_id = category_id;
	}
	public ItemVO(int item_cd, String item_name, String description, int price, int stock, int category_id,
			String create_at, String update_at, String img_url) {
		this.item_cd = item_cd;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.category_id = category_id;
		this.create_at = create_at;
		this.update_at = update_at;
		this.img_url = img_url;
	}
	public ItemVO(int item_cd, String item_name, String description, int price, int stock, String category_name,
			String create_at, String update_at) {
		this.item_cd = item_cd;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.category_name = category_name;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	
	public ItemVO(String item_name, String description, int price, int stock, int category_id, String img_url) {
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.category_id = category_id;
		this.img_url = img_url;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getItem_cd() {
		return item_cd;
	}
	public void setItem_cd(int item_cd) {
		this.item_cd = item_cd;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
