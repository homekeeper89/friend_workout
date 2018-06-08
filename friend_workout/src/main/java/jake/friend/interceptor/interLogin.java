package jake.friend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class interLogin extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	private static final Logger logger = 
			LoggerFactory.getLogger(interLogin.class);
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap(); // 이거의 역할은 무엇인가
		Object userVO = modelMap.get("userVO");
		if(userVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			response.sendRedirect("/");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN) != null) {
			logger.info("clear login data");
			session.removeAttribute(LOGIN);
		}
		return true;
	}
	
	
}
