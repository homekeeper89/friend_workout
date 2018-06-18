package jake.friend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jake.friend.domain.bbsVO;

@Service
public class bbsService {
	
	@Autowired
	private bbsDAOImpl dao;
	
	@Transactional(value = "transactionManager") 
	public void regist(bbsVO vo) throws Exception{
		dao.create(vo);
		String files = vo.getFiles();
		if(files == null) {
			return ;
		}
		dao.addAttach(files);
	}

}
