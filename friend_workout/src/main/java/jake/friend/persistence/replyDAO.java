package jake.friend.persistence;

import java.util.List;

import jake.friend.cri.Criteira;
import jake.friend.domain.replyVO;

public interface replyDAO {
	
	public List<replyVO> list(int bno) throws Exception;
	public void create(replyVO vo) throws Exception;
	public void update(replyVO vo) throws Exception;
	public void delete(int rno) throws Exception;
	// ����¡ ó���� ���� �޼��� �߰�
	public List<replyVO> listPage(int b_seq, Criteira cri) throws Exception;
	public int count(int b_seq) throws Exception; // �ش� �Խù��� ��� ��
}
