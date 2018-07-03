package jake.friend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jake.friend.domain.bbsVO;

@Service
public class bbsService {
	
	@Autowired
	private bbsDAOImpl dao;
	

}
