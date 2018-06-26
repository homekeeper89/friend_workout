package jake.friend.domain;

import java.util.Date;

public class bbsVO {
	
	private int b_seq;
	private String b_title;
	private String u_name;
	private String b_content;
	private Date b_regdate;
	private int b_status;
	private String files; // file 저장을 위해 만든 변수
	private int category; // 게시판 구분을 위한 카테고리, 0 이미지, 1은 게시판 2는 댓글, 3은 마이페이지
	private int viewcnt; // 조회수를 위한 
	private int rownum; // 게시글 넘버링을 위해 따로 만듬
	
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_status() {
		return b_status;
	}
	public void setB_status(int b_status) {
		this.b_status = b_status;
	}
	@Override
	public String toString() {
		return "bbsVO [b_seq=" + b_seq + ", b_title=" + b_title + ", u_name=" + u_name + ", b_content=" + b_content
				+ ", b_regdate=" + b_regdate + ", b_status=" + b_status + ", files=" + files + ", category=" + category
				+ ", viewcnt=" + viewcnt + ", rownum=" + rownum + "]";
	}
  
}
