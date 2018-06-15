package jake.friend.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import jake.friend.domain.fileVO;

@Repository
public class fileDAOimpl implements fileDAO {

	private static String namespace = "jake.friend.mapper.fileMapper";
	private static Logger logger = Logger.getLogger(fileDAOimpl.class);
	
	@Inject // inject는 자바것
	private SqlSession session;
	
	@Override
	public List<fileVO> getFiles() {
		return session.selectList(namespace + ".getFiles");
	}

	
}
