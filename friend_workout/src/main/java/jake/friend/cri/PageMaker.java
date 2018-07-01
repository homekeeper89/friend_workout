package jake.friend.cri;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/* 게시판 페이징 처리를 위해 만든 클래스
 * 
 */

/**
 * @author Jake
 *
 */
public class PageMaker {
	private int totalCount; // 게시글 총 갯수
	private int startPage;
	private int endPage; // 하단에 끝 페이지 넘버
	private boolean prev; // 하단에 이전 페이지, 다음 페이지를 보여주는 애
	private boolean next; 
	private int displayPageNum = 10;
	private Criteira cri;
	
	
	public void setCri(Criteira cri) {
		this.cri = cri;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	private void calcData() {
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		// 엔드페이지 계산 : 현재 페이지 번호 - 페이지 번호의 수(10개) * 보여줄 페이지 수
		// 현재 페이지가 3이면 (3 / 10) * 10 = 10 
		startPage = (endPage - displayPageNum) + 1;
		// 시작 페이지 = 엔드페이지 - 페이지 번호의 수(10개) + 1
		// 엔드페이지가 20이면 시작은 20 - 10 + 1 로 11이 됨.
		int tempEndPage = (int)(Math.ceil(totalCount / (double) cri.getPerPageNum()));
		// 총 갯수에 따른 엔드페이지 조절. 100개의 데이터를 20개씩 보여준다면 엔드페이지는 5가 되야함
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false:true;
		// 현재 페이지가 1이면 prev를 보여주면 안됨
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;
		// endPage * cri가 전체 갯수보다 작아야
		
		// end가 10, perPage가 10인데 tot가 101이면 next는 있어야함
		
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uriComponents.toString();
		// uri를 쉽게 만들기 위해서
	}

	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteira getCri() {
		return cri;
	}
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}


}
