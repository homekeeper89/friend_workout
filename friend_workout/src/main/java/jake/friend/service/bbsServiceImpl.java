package jake.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAOImpl;

@Service
public class bbsServiceImpl implements bbsService{

	@Autowired
	private bbsDAOImpl dao;
	
	@Override
	public List<bbsVO> listall() throws Exception {
		List<bbsVO> vo = dao.listAll();
		return vo;
	}

	@Override
	public bbsVO read(int b_seq) throws Exception {
			
		return dao.read(b_seq);
	}

	public void remove(int b_seq) throws Exception {
		dao.remove(b_seq);
		
	}

	public void modify(bbsVO board) throws Exception{
		dao.modify(board);
		
	}
	
	
}
