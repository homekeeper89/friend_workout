package jake.friend.cri;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/* �Խ��� ����¡ ó���� ���� ���� Ŭ����
 * 
 */

/**
 * @author Jake
 *
 */
public class PageMaker {
	private int totalCount; // �Խñ� �� ����
	private int startPage;
	private int endPage; // �ϴܿ� �� ������ �ѹ�
	private boolean prev; // �ϴܿ� ���� ������, ���� �������� �����ִ� ��
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
		// ���������� ��� : ���� ������ ��ȣ - ������ ��ȣ�� ��(10��) * ������ ������ ��
		// ���� �������� 3�̸� (3 / 10) * 10 = 10 
		startPage = (endPage - displayPageNum) + 1;
		// ���� ������ = ���������� - ������ ��ȣ�� ��(10��) + 1
		// ������������ 20�̸� ������ 20 - 10 + 1 �� 11�� ��.
		int tempEndPage = (int)(Math.ceil(totalCount / (double) cri.getPerPageNum()));
		// �� ������ ���� ���������� ����. 100���� �����͸� 20���� �����شٸ� ������������ 5�� �Ǿ���
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false:true;
		// ���� �������� 1�̸� prev�� �����ָ� �ȵ�
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;
		// endPage * cri�� ��ü �������� �۾ƾ�
		
		// end�� 10, perPage�� 10�ε� tot�� 101�̸� next�� �־����
		
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uriComponents.toString();
		// uri�� ���� ����� ���ؼ�
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
