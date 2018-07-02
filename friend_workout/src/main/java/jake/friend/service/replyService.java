package jake.friend.service;

import java.util.List;

import jake.friend.cri.Criteira;
import jake.friend.domain.replyVO;

public interface replyService {
	
	public void addReply(replyVO vo) throws Exception;
	public List<replyVO> listReply(int b_seq) throws Exception;
	public void modifyReply(replyVO vo) throws Exception;
	public void removeReply(int r_seq) throws Exception;
	// ����¡ ó��
	public List<replyVO> listReplyPage(int b_seq, Criteira cri) throws Exception;
	public int count(int b_seq) throws Exception; // �ش� �Խù��� ��� ��

}
