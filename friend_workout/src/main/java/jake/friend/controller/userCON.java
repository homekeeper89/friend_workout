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
	public String register() { // ȸ���������� �̵��ϴ� �޼���
		return "register";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String register(userVO vo) throws Exception{ // ȸ�������ϴ� �޼���
		int num = dao.create(vo);
		logger.info("res " + num);
		return "home";
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String sessionGet() throws Exception{ // loginâ���� �̵��ϴ� �޼���
		return "login";
	}
	
	@RequestMapping(value = "/sessions", method = RequestMethod.POST) // login�ϴ� �޼���
	public void sessionGet(userVO vo, HttpSession session, Model model) throws Exception{
		userVO res = dao.login(vo);
		if (res == null || res.getU_name() == null) {
			System.out.println("res2 " + res);
			return ; // return �� ����ҰŰ�����..
		}
		model.addAttribute("userVO", res);
		
	}
}
