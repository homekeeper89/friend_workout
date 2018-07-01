package jake.friend.cri;

/* ����¡ ó���� �����ϰ� �ϱ� ���Ͽ� 
 * 
 */
/**
 * @author Jake
 *
 */
public class Criteira {
	private int page;
	private int perPageNum; // ����¡ ó���� ���� ���ϴ�
	
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

	public int getPageStart() { // ���۵Ǵ� ������ ���� ���� ��� �������� �������ִ� �Լ�
		return (this.page -1) * perPageNum;
	}

	public int getPerPageNum() {
		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<= 0 || perPageNum > 100) { // �����ǰų� ������ ��� �⺻�� 10���� ��
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	
}
