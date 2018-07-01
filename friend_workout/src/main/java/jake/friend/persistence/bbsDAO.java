package jake.friend.persistence;

import jake.friend.cri.Criteira;
import jake.friend.domain.bbsVO;
import java.util.*;

public interface bbsDAO {
	
	public void create(bbsVO vo) throws Exception;
	public bbsVO read(int b_seq) throws Exception;
	public void modify(bbsVO vo) throws Exception;
	public void remove(int b_seq) throws Exception;
	public List<bbsVO> listAll(int page) throws Exception; // 페이징 처리를 위해 추가
	public void addAttach(String fullNmae) throws Exception; // file 저장을 위해
	public List<bbsVO> listCriteria(Criteira cri) throws Exception; // 페이징 처리 도구, 페이지 넘버링을 나타냄
	public int countPaging(Criteira cri) throws Exception; // tot갯수를 세기 위함
}
