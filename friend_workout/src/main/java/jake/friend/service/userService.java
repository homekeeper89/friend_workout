package jake.friend.service;

import java.sql.Date;

import jake.friend.domain.userVO;

public interface userService {
	
	public void keepLogin(int u_seq, String sessionId, Date next) throws Exception; // �ڵ� �α��� ���� ����
	public userVO checkLoginBefore(String value); // �ڵ� �α��� ���� ����

}
