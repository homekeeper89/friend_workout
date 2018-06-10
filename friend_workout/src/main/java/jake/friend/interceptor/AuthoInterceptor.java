package jake.friend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthoInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthoInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			logger.info("current user is not logined");
			response.sendRedirect("/users/session");
			return false;
		}
		return true;	
	}
	
	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		logger.info("uri :" + uri);
		logger.info("query :" + query);
		if(query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}
		if(req.getMethod().equals("GET")) {
			logger.info("dest :" + (uri + query));
			req.getSession().setAttribute("dest",uri + query);
		}
	}
	

}
