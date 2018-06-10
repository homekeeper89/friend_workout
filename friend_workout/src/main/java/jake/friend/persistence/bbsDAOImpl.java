package jake.friend.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jake.friend.domain.bbsVO;

@Repository
public class bbsDAOImpl implements bbsDAO {

	@Inject // inject는 자바것
	private SqlSession session;
	
	@Override
	public void addAttach(String fullName) throws Exception {
		session.insert("addAttach", fullName);
		
	}
	@Override
	public void create(bbsVO vo) throws Exception {
		session.insert("create", vo);
		
	}
	@Override
	public bbsVO read(int b_seq) throws Exception {
		return session.selectOne("read", b_seq);
		
	}

	@Override
	public void update(bbsVO vo) throws Exception {
		session.update("update", vo);
		
	}

	@Override
	public void delete(int b_seq) throws Exception {
		session.update("delete", b_seq);
		
	}

	@Override
	public List<bbsVO> listAll() throws Exception {
		return session.selectList("listAll");
	}


}
