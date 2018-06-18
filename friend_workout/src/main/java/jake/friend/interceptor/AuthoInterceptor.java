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
/* 특정 경로에 접근하는 경우 로그인 여부를 확인하기 위함.
 *    /files 경로에서 작동한다
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
			response.sendRedirect("/users/session");  // 로그인 안했을 경우 로그인 창으로 넘어감
			return false;
		}
		return true;	
	}
	
	// 로그인 시 이전에 있떤 경로로 다시 되돌리기 위해서 사용하는 메서드
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
		if(req.getMethod().equals("GET")) { // get방식일땐 뒤에 파라미터들도 같이 보내야하기 대문
			logger.info("dest :" + (uri + query));
			req.getSession().setAttribute("dest",uri + query); // "dest"에 정보를 담는다. 따라서 로그인한 후에 dest의 정보를 가져오면된다
		}
	}
	

}
