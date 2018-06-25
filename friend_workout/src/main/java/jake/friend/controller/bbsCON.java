package jake.friend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jake.friend.service.bbsServiceImpl;

@Controller
public class bbsCON {
	private static Logger logger = Logger.getLogger(bbsCON.class);
	@Autowired
	private bbsServiceImpl service;
	
	@RequestMapping(value = "/bbs", method =  RequestMethod.GET) // 게시판으로 가는 컨트롤러 
	public ModelAndView bbsRegister(Model model) throws Exception {
		logger.info("show all list");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbslist");
		mv.addObject("list", service.listall());
		return mv;
	}
	@RequestMapping(value = "/pages", method = RequestMethod.GET)
	public ModelAndView read(@RequestParam("b_seq") int b_seq, Model model) throws Exception {
		logger.info("b_no " + b_seq);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbspage");
		mv.addObject("boardVO", service.read(b_seq));
		return mv;
	}

}
