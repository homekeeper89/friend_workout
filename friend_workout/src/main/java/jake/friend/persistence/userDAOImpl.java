package jake.friend.persistence;

import java.util.List;

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
	public int create(userVO vo) throws Exception {
		int num = session.insert(namespace + ".create", vo);
		int res = num!= 0? 1:0;
		return res;
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
