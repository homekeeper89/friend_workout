package jake.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jake.friend.cri.Criteira;
import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAOImpl;

@Service
public class bbsServiceImpl implements bbsService{

	@Autowired
	private bbsDAOImpl dao;
	
	@Override
	@Transactional(value = "transactionManager") 
	public void regist(bbsVO vo) throws Exception{
		dao.filecreate(vo);
		String files = vo.getFiles();
		if(files == null) {
			return ;
		}
		dao.addAttach(files);
	}
	
	@Override
	public List<bbsVO> listall() throws Exception {
		List<bbsVO> vo = dao.listAll(3);
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
	
	@Override
	public List<bbsVO> listCriteria(Criteira cri) throws Exception {
		return dao.listCriteria(cri);
	}
	@Override
	public int listCountCriteria(Criteira cri) throws Exception {
		return dao.countPaging(cri);
	}
	public void register(bbsVO vo) throws Exception {
		dao.create(vo);
		
	}
	
	
	
	
}
