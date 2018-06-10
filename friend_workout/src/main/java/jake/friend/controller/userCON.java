package jake.friend.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jake.friend.domain.userVO;
import jake.friend.persistence.userDAOImpl;
import jake.friend.test.userCONtest;

/**
 * Copyright : homekeeper89@gmail.com
 * 
 */
@Controller
@RequestMapping(value = "/users")
public class userCON {
	
	private static final Logger logger = LoggerFactory.getLogger(userCON.class);
	
	@Autowired
	private userDAOImpl dao;
	
	@RequestMapping(value = "", method= RequestMethod.GET)
	public String register() { // 회원가입으로 이동하는 메서드
		return "register";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String register(userVO vo) throws Exception{ // 회원가입하는 메서드
		int num = dao.create(vo);
		logger.info("res " + num);
		return "home";
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String sessionGet() throws Exception{ // login창으로 이동하는 메서드
		return "login";
	}
	
	@RequestMapping(value = "/sessions", method = RequestMethod.POST) // login하는 메서드
	public void sessionGet(userVO vo, HttpSession session, Model model) throws Exception{
		userVO res = dao.login(vo);
		if (res == null || res.getU_name() == null) {
			System.out.println("res2 " + res);
			return ; // return 값 줘야할거같은데..
		}
		model.addAttribute("userVO", res);
		
	}
}
