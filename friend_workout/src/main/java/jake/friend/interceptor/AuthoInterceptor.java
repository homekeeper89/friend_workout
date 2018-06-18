package jake.friend.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import jake.friend.domain.userVO;
import jake.friend.service.userServiceImpl;
/* Ư�� ��ο� �����ϴ� ��� �α��� ���θ� Ȯ���ϱ� ����.
 *    /files ��ο��� �۵��Ѵ�
 */
public class AuthoInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthoInterceptor.class);
	
	@Autowired
	private userServiceImpl service;

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
			saveDest(request);
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				userVO vo = service.checkLoginBefore(loginCookie.getValue());
				logger.info("uservo :" + vo);
				if(vo != null) {
					session.setAttribute("login",  vo);
				}
			}
			response.sendRedirect("/users/session");  // �α��� ������ ��� �α��� â���� �Ѿ
			return false;
		}
		return true;	
	}
	
	// �α��� �� ������ �ֶ� ��η� �ٽ� �ǵ����� ���ؼ� ����ϴ� �޼���
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
		if(req.getMethod().equals("GET")) { // get����϶� �ڿ� �Ķ���͵鵵 ���� �������ϱ� �빮
			logger.info("dest :" + (uri + query));
			req.getSession().setAttribute("dest",uri + query); // "dest"�� ������ ��´�. ���� �α����� �Ŀ� dest�� ������ ��������ȴ�
		}
	}
	

}
