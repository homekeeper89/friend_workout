package jake.friend.service;

import java.sql.Date;

import jake.friend.domain.userVO;

public interface userService {
	
	public void keepLogin(int u_seq, String sessionId, Date next) throws Exception; // 자동 로그인 위한 서비스
	public userVO checkLoginBefore(String value); // 자동 로그인 위한 서비스

}
