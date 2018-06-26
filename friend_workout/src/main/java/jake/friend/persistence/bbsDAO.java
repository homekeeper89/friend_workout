package jake.friend.persistence;

import jake.friend.domain.bbsVO;
import java.util.*;

public interface bbsDAO {
	
	public void create(bbsVO vo) throws Exception;
	public bbsVO read(int b_seq) throws Exception;
	public void modify(bbsVO vo) throws Exception;
	public void remove(int b_seq) throws Exception;
	public List<bbsVO> listAll() throws Exception;
	public void addAttach(String fullNmae) throws Exception; // file 저장을 위해

}
