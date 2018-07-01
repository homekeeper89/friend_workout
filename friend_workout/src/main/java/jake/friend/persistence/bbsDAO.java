package jake.friend.persistence;

import jake.friend.cri.Criteira;
import jake.friend.domain.bbsVO;
import java.util.*;

public interface bbsDAO {
	
	public void create(bbsVO vo) throws Exception;
	public bbsVO read(int b_seq) throws Exception;
	public void modify(bbsVO vo) throws Exception;
	public void remove(int b_seq) throws Exception;
	public List<bbsVO> listAll(int page) throws Exception; // ����¡ ó���� ���� �߰�
	public void addAttach(String fullNmae) throws Exception; // file ������ ����
	public List<bbsVO> listCriteria(Criteira cri) throws Exception; // ����¡ ó�� ����, ������ �ѹ����� ��Ÿ��
	public int countPaging(Criteira cri) throws Exception; // tot������ ���� ����
}
