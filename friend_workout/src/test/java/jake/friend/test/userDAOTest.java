package jake.friend.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jake.friend.domain.userVO;
import jake.friend.persistence.userDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class userDAOTest {
	
	@Inject
	private userDAO udao;
	
	@Test
	public void testCreate() throws Exception{
		userVO vo = new userVO();
		vo.setAge(30);
		vo.setEmail("wkdgndldi");
		vo.setHeight(65);
		vo.setWeight(180);
		vo.setPwd("wkdgns");
		vo.setU_name("jake");
		vo.setSex(1);
		System.out.println(vo.toString());
		udao.create(vo);
		
	}

}
