package jake.friend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jake.friend.domain.userVO;
import jake.friend.test.userCONtest;

@Controller
public class userCON {
	
	private static final Logger logger = LoggerFactory.getLogger(userCON.class);
	
	@RequestMapping(value = "/user", method= RequestMethod.GET)
	public String register() {
		logger.info("userGet");
		return "register";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String register(userVO vo) {
		
		return "home";
	}

}
