package jake.friend.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class bbsCON {
	private static Logger logger = Logger.getLogger(bbsCON.class);
	@RequestMapping(value = "/bbs", method =  RequestMethod.GET) // �Խ������� ���� ��Ʈ�ѷ� 
	public String bbsRegister() {
		logger.info("bbs");
		return "bbslist";
	}

}
