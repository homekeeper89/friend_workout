package jake.friend.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jake.friend.cri.Criteira;
import jake.friend.domain.replyVO;
import jake.friend.persistence.replyDAO;

@Service
public class replyServiceImpl implements replyService {
	@Inject
	private replyDAO dao;

	@Override
	public void addReply(replyVO vo) throws Exception {
		System.out.println(vo.toString());
		dao.create(vo);

	}

	@Override
	public List<replyVO> listReply(int b_seq) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(b_seq);
	}

	@Override
	public void modifyReply(replyVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void removeReply(int r_seq) throws Exception {
		dao.delete(r_seq);

	}

	@Override
	public List<replyVO> listReplyPage(int b_seq, Criteira cri) throws Exception {
		return dao.listPage(b_seq, cri);
	}

	@Override
	public int count(int b_seq) throws Exception {
		return dao.count(b_seq);
	}
	

}
