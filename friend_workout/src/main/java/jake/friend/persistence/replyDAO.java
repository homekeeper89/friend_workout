package jake.friend.persistence;

import java.util.List;

import jake.friend.cri.Criteira;
import jake.friend.domain.replyVO;

public interface replyDAO {
	
	public List<replyVO> list(int bno) throws Exception;
	public void create(replyVO vo) throws Exception;
	public void update(replyVO vo) throws Exception;
	public void delete(int rno) throws Exception;
	// 페이징 처리를 위한 메서드 추가
	public List<replyVO> listPage(int b_seq, Criteira cri) throws Exception;
	public int count(int b_seq) throws Exception; // 해당 게시물의 댓글 수
}
