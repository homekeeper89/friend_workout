package jake.friend.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jake.friend.cri.Criteira;
import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class bbsDAOTest {
	
	private static Logger logger = Logger.getLogger(bbsDAOTest.class);
	
	@Inject
	private bbsDAO dao;
	
	//@Test
	public void testCreate() throws Exception{
		bbsVO bbs  = new bbsVO();
		bbs.setB_title("new title");
		bbs.setB_content("new COn");
		bbs.setU_name("user00");
		dao.create(bbs);
	}
	
	//@Test
	public void testPage() throws Exception{
		int page = 3;
		List<bbsVO> lst = dao.listAll(page);
		for (bbsVO vo : lst) {
			logger.info(vo.getB_seq() + ":" + vo.getB_title());
		}
	}
	
	@Test
	public void testListC() throws Exception{
		Criteira cri = new Criteira();
		cri.setPage(2);
		cri.setPerPageNum(20);
		List<bbsVO> list = dao.listCriteria(cri);
		logger.info("cnt" + ":" +list.size());
		for (bbsVO vo : list) {
			logger.info(vo.getB_seq() + ":" + vo.getB_title());
		}
	}

}
