package jake.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAOImpl;

public class bbsServiceImpl implements bbsService{

	@Autowired
	private bbsDAOImpl dao;
	
	@Override
	public List<bbsVO> listall() throws Exception {
		return dao.listAll();
	}
	
}
