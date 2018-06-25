package jake.friend.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jake.friend.controller.userCON;
import jake.friend.domain.bbsVO;

@Repository
public class bbsDAOImpl implements bbsDAO {

	private static final Logger logger = LoggerFactory.getLogger(bbsDAOImpl.class);	
	@Inject // inject는 자바것
	private SqlSession session;
	private static String namespace = "jake.friend.mapper.BoardMapper";
	
	
	@Override
	public void addAttach(String fullName) throws Exception {
		session.insert(namespace + ".addAttach", fullName);
		
	}
	 	
	@Override
	public void create(bbsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}
	@Override
	public bbsVO read(int b_seq) throws Exception {
		return session.selectOne(namespace + ".read", b_seq);
		
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
