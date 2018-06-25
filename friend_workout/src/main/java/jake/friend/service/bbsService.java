package jake.friend.service;

import java.util.List;

import jake.friend.domain.bbsVO;

public interface bbsService {
	public List<bbsVO> listall() throws Exception;
	public bbsVO read(int b_seq) throws Exception;
}
