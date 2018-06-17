package jake.friend.domain;

import java.sql.Date;

public class fileVO {
	
	private int f_seq;
	private int b_seq;
	private String f_path;
	private Date f_regdate;
	private String b_title;
	private String b_content;
	private String u_name;
	
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getF_seq() {
		return f_seq;
	}
	public void setF_seq(int f_seq) {
		this.f_seq = f_seq;
	}
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public String getF_path() {
		return f_path;
	}
	public void setF_path(String f_path) {
		this.f_path = f_path;
	}
	public Date getF_regdate() {
		return f_regdate;
	}
	public void setF_regdate(Date f_regdate) {
		this.f_regdate = f_regdate;
	}
	
	

}
