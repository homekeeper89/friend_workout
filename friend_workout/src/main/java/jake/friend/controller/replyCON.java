package jake.friend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jake.friend.cri.Criteira;
import jake.friend.cri.PageMaker;
import jake.friend.domain.replyVO;
import jake.friend.service.replyService;

@RestController
@RequestMapping("/rep")
public class replyCON {
	
	@Autowired
	private replyService service;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody replyVO vo){
		ResponseEntity<String> entity = null;
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	} // 댓글을 기록하는 메서드
	@RequestMapping(value ="/{b_seq}", method = RequestMethod.GET)
	public ResponseEntity<List<replyVO>> list(@PathVariable("b_seq") int b_seq){
		ResponseEntity<List<replyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<replyVO>>(service.listReply(b_seq), HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	} // 댓글 전체를 가져오는 메서드
	
	@RequestMapping(value = "/{r_seq}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("r_seq") int r_seq, @RequestBody replyVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setR_seq(r_seq);
			service.modifyReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}// 댓글을 수정하는 메서드
	
	@RequestMapping(value = "/{r_seq}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("r_seq") int r_seq){
		ResponseEntity<String> entity = null;
		try {
			service.removeReply(r_seq);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{b_seq}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("b_seq") int b_seq,
			@PathVariable("page") int page){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Criteira cri = new Criteira();
			cri.setPage(page);
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			Map<String, Object> map = new HashMap<String, Object>();
			List<replyVO> list = service.listReplyPage(b_seq, cri);
			map.put("list", list);
			
			int replyCnt = service.count(b_seq);
			pm.setTotalCount(replyCnt);
			map.put("pageMaker",  pm);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
