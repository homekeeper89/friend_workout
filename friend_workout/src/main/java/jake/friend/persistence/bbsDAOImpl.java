package jake.friend.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jake.friend.controller.userCON;
import jake.friend.cri.Criteira;
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
	public void modify(bbsVO vo) throws Exception {
		session.update("update", vo);
		
	}

	@Override
	public void remove(int b_seq) throws Exception {
		session.update("delete", b_seq);
		
	}

	@Override
	public List<bbsVO> listAll(int page) throws Exception { // 페이징 처리를 위해 파라미터가 추가됨
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10; // 게시물 아래 페이지 
		return session.selectList(namespace + ".listAll", page);
	}

	@Override
	public List<bbsVO> listCriteria(Criteira cri) throws Exception {		
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteira cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}
	
	


}
