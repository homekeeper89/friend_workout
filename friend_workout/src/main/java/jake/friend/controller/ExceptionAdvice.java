package jake.friend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/* 모든 종류의 예외 처리를 담당하는 클래스
 * 
 */

@ControllerAdvice
public class ExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorModel(Exception e) {
		logger.info(e.toString());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error_common");
		mv.addObject("exception",  e);
		return mv;
	}

}
