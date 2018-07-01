package jake.friend.cri;

/* 페이징 처리를 유연하게 하기 위하여 
 * 
 */
/**
 * @author Jake
 *
 */
public class Criteira {
	private int page;
	private int perPageNum; // 페이징 처리시 갯수 정하는
	
	public Criteira() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return this.page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPageStart() { // 시작되는 페이지 수에 따라서 몇개씩 가져올지 결정해주는 함수
		return (this.page -1) * perPageNum;
	}

	public int getPerPageNum() {
		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<= 0 || perPageNum > 100) { // 오버되거나 부족한 경우 기본값 10으로 줌
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	
}
