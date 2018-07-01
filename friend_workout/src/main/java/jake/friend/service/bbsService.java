package jake.friend.service;

import java.util.List;

import jake.friend.domain.bbsVO;

public interface bbsService {
	public List<bbsVO> listall() throws Exception;
	public bbsVO read(int b_seq) throws Exception;
	public void remove(int b_seq) throws Exception;
	public void modify(bbsVO vo) throws Exception;
}