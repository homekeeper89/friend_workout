package jake.friend.service;

import java.sql.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jake.friend.controller.userCON;
import jake.friend.domain.userVO;
import jake.friend.persistence.userDAO;

/* User�� ���񽺸� ����ϴ� Ŭ����
 * ������ ���� ���� �� ��ȣȭ�� ����ϰ� ����
 * 
 */
@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userDAO dao;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	private static final Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
	
	@Override
	public void keepLogin(int u_seq, String sessionId, Date next) throws Exception {
		dao.keepLogin(u_seq, sessionId, next);
	}

	@Override
	public userVO checkLoginBefore(String value) {
		return dao.checkUserWithSessionKey(value);
	}

	public userVO login(userVO vo) throws Exception {
		userVO uv = dao.login(vo);
		logger.info("uv Ȯ��" + uv.toString());
		if (uv != null) {
			logger.info("uv Ȯ��" + uv.toString());
			if(pwdEncoder.matches(vo.getPwd(), uv.getPwd())) {
				return uv;
			}
		}
		return uv;
	}
	
	

}
