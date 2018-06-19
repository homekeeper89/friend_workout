package jake.friend.persistence;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jake.friend.domain.userVO;

@Repository
public class userDAOImpl implements userDAO {

	@Inject // inject는 자바것
	private SqlSession session;
	private static String namespace = "jake.friend.mapper.userMapper";
	
	
	@Override
	public void keepLogin(int u_seq, String sessionId, Date next) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("u_seq",u_seq);
		paramMap.put("sessionId",  sessionId);
		paramMap.put("next",next);
		System.out.println("dao 확인" + u_seq + ":" + sessionId + ":" + next);
		try {
		session.update(namespace + ".keepLogin", paramMap);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public userVO checkUserWithSessionKey(String value) {
		return session.selectOne(namespace+".checkUserWithSessionKey", value);
	}

	@Override
	public int create(userVO vo) throws Exception {
		int num = session.insert(namespace + ".create", vo);
		int res = num!= 0? 1:0;
		return res;
	}
		 
	@Override
	public userVO login(userVO vo) throws Exception {
		return session.selectOne(namespace + ".login", vo);
	}

	@Override
	public userVO read(int b_seq) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(userVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int b_seq) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<userVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
