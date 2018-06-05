package jake.friend.persistence;

import jake.friend.domain.bbsVO;
import java.util.*;

public interface bbsDAO {
	
	public void create(bbsVO vo) throws Exception;
	public bbsVO read(int b_seq) throws Exception;
	public void update(bbsVO vo) throws Exception;
	public void delete(int b_seq) throws Exception;
	public List<bbsVO> listAll() throws Exception;

}
