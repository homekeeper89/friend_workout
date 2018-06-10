package jake.friend.interceptor;

import javax.servlet.http.Cookie;
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
		ModelMap modelMap = modelAndView.getModelMap(); // �̰��� ������ �����ΰ�
		Object userVO = modelMap.get("userVO");
		logger.info("uservo : " + userVO);
		if(userVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			// cookie 
			if (request.getParameter("userCookie") != null) {
				logger.info("remember me.....");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*60*24*7);
				response.addCookie(loginCookie);				
			}
			// cookie
			
			//response.sendRedirect("/");
			// dest : �ܺ� �Խù����� �α����� �ȉ��� ��� �α����� �ϰ� �ٽ� ���� �ִ� �ڸ��� ���������� ����dest�� �߰���
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null? (String)dest:"/");
			// dest : �������
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
