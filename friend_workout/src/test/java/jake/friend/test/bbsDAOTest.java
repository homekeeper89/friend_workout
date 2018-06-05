package jake.friend.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class bbsDAOTest {
	
	@Inject
	private bbsDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		bbsVO bbs  = new bbsVO();
		bbs.setB_title("new title");
		bbs.setB_content("new COn");
		bbs.setU_name("user00");
		dao.create(bbs);
	}

}
