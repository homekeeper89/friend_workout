package jake.friend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class interAll extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(interAll.class);
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("======================END========================");
		if (logger.isDebugEnabled()) {
			logger.debug("======================================           END          ======================================\n");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("====================PRE=====================");
		logger.info("Request URI \t : " + request.getRequestURI());
		// 차후에 vo 가져오는 거 해보자
		return super.preHandle(request, response, handler);
	}
	
	

}
