package kr.ac.kopo.answer.vo;

public class AnswerVO {
	private int answer_no;
	private int inquiry_no;
	private String content;
	private String answer_date;

	public AnswerVO() {
	}
	public AnswerVO(int answer_no, int inquiry_no, String content, String answer_date) {
		this.answer_no = answer_no;
		this.inquiry_no = inquiry_no;
		this.content = content;
		this.answer_date = answer_date;
	}
	public int getAnswer_no() {
		return answer_no;
	}
	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}
	public int getInquiry_no() {
		return inquiry_no;
	}
	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
}
