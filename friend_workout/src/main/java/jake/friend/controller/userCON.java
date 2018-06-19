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
 * ���� ���õ� ��Ʈ�ѷ�, ȸ�����(�̵�), ���� ��
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
	@Resource(name = "pwdEncoder") // ��ȣȭ�� ����
	private BCryptPasswordEncoder pwdEncoder;
	
	
	@RequestMapping(value = "", method= RequestMethod.GET)
	public String register() { // ȸ���������� �̵��ϴ� �޼���
		return "register";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String register(userVO vo) throws Exception{ // ȸ�������ϴ� �޼���
		vo.setPwd(pwdEncoder.encode(vo.getPwd()));
		int num = dao.create(vo);
		logger.info("res " + num);
		return "redirect:" +"/";
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String sessionGet() throws Exception{ // loginâ���� �̵��ϴ� �޼���
		return "login";
	}
	
	@RequestMapping(value = "/sessions", method = RequestMethod.POST) // login�ϴ� �޼���
	public void sessionGet(userVO vo, HttpSession session, Model model) throws Exception{
		userVO res = service.login(vo);
		if (res == null) {
			logger.info("login fail");
			return;
		}
		model.addAttribute("userVO", res);
		if(vo.isUseCookie()) {
			logger.info("���� ����? " + vo.isUseCookie());
			int amount = 60*60*24*7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
			service.keepLogin(res.getU_seq(), session.getId(), sessionLimit);
		}
	}
	
/*	@RequestMapping(value = "/sessions", method = RequestMethod.POST) // login�ϴ� �޼���
	public void sessionGet(userVO vo, HttpSession session, Model model) throws Exception{
		userVO res = dao.login(vo);
		if (res == null || res.getU_name() == null) {
			//logger.info("controller " + res);
			model.addAttribute("userVO", null); // �̷��� �ؾ� �������� ��,.��
			return ;
		}
		model.addAttribute("userVO", res);
	}*/
}
