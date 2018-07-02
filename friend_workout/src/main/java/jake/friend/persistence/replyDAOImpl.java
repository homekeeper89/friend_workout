package jake.friend.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jake.friend.cri.Criteira;
import jake.friend.domain.replyVO;

@Repository
public class replyDAOImpl implements replyDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "jake.friend.mapper.ReplyMapper";

	@Override
	public List<replyVO> list(int b_seq) throws Exception {
		return session.selectList(namespace + ".list", b_seq);
	}

	@Override
	public void create(replyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public void update(replyVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int r_seq) throws Exception {
		session.update(namespace + ".delete", r_seq);

	}

	@Override
	public List<replyVO> listPage(int b_seq, Criteira cri) throws Exception {
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("b_seq", b_seq);
		pmap.put("cri", cri);
		return session.selectList(namespace + ".listPage", pmap);
	}

	@Override
	public int count(int b_seq) throws Exception {
		return session.selectOne(namespace + ".count", b_seq);
	}
	
	

}
