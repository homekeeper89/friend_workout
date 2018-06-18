package jake.friend.persistence;

import java.sql.Date;
import java.util.List;

import jake.friend.domain.userVO;

public interface userDAO {
	
	public int create(userVO vo) throws Exception;
	public userVO read(int b_seq) throws Exception;
	public void update(userVO vo) throws Exception;
	public void delete(int b_seq) throws Exception;
	public List<userVO> listAll() throws Exception;
	public userVO login(userVO vo) throws Exception;
	public void keepLogin(int u_seq, String sessionId, Date next); // 자동 로그인 관련 추가
	public userVO checkUserWithSessionKey(String value); // 자동 로그인 관련 추가
	}
