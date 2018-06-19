package jake.friend.controller;

import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jake.friend.domain.userVO;
import jake.friend.persistence.userDAOImpl;
import jake.friend.service.userServiceImpl;
import jake.friend.test.userCONtest;

/**
 * Copyright : homekeeper89@gmail.com
 * 유저 관련된 컨트롤러, 회원등록(이동), 가입 등
 * 
 */
@Controller
@RequestMapping(value = "/users")
public class userCON {
	
	private static final Logger logger = LoggerFactory.getLogger(userCON.class);
	
	@Autowired
	private userDAOImpl dao;
	@Autowired
	private userServiceImpl service;
	@Resource(name = "pwdEncoder") // 복호화를 위함
	private BCryptPasswordEncoder pwdEncoder;
	
	
	@RequestMapping(value = "", method= RequestMethod.GET)
	public String register() { // 회원가입으로 이동하는 메서드
		return "register";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String register(userVO vo) throws Exception{ // 회원가입하는 메서드
		vo.setPwd(pwdEncoder.encode(vo.getPwd()));
		int num = dao.create(vo);
		logger.info("res " + num);
		return "redirect:" +"/";
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String sessionGet() throws Exception{ // login창으로 이동하는 메서드
		return "login";
	}
	
	@RequestMapping(value = "/sessions", method = RequestMethod.POST) // login하는 메서드
	public void sessionGet(userVO vo, HttpSession session, Model model) throws Exception{
		userVO res = service.login(vo);
		if (res == null) {
			logger.info("login fail");
			return;
		}
		model.addAttribute("userVO", res);
		if(vo.isUseCookie()) {
			logger.info("여기 들어옴? " + vo.isUseCookie());
			int amount = 60*60*24*7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
			service.keepLogin(res.getU_seq(), session.getId(), sessionLimit);
		}
	}
	
/*	@RequestMapping(value = "/sessions", method = RequestMethod.POST) // login하는 메서드
	public void sessionGet(userVO vo, HttpSession session, Model model) throws Exception{
		userVO res = dao.login(vo);
		if (res == null || res.getU_name() == null) {
			//logger.info("controller " + res);
			model.addAttribute("userVO", null); // 이렇게 해야 막아지네 ㅡ,.ㅡ
			return ;
		}
		model.addAttribute("userVO", res);
	}*/
}
