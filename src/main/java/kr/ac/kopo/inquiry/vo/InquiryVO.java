package kr.ac.kopo.inquiry.vo;

public class InquiryVO {
	private int inquiry_no;
	private int user_no;
	private String content;
	private String inquiry_date;

	public InquiryVO() {
	}

	public InquiryVO(int inquiry_no, int user_no, String content, String inquiry_date) {
		this.inquiry_no = inquiry_no;
		this.user_no = user_no;
		this.content = content;
	}

	public int getInquiry_no() {
		return inquiry_no;
	}

	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInquiry_date() {
		return inquiry_date;
	}

	public void setInquiry_date(String inquiry_date) {
		this.inquiry_date = inquiry_date;
	}
}
