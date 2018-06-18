package jake.friend.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jake.friend.domain.userVO;
import jake.friend.persistence.userDAO;

@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userDAO dao;
	
	
	@Override
	public void keepLogin(int u_seq, String sessionId, Date next) throws Exception {
		dao.keepLogin(u_seq, sessionId, next);
		
	}

	@Override
	public userVO checkLoginBefore(String value) {
		return dao.checkUserWithSessionKey(value);
	}
	
	

}
