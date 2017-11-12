package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import entities.User;

public class DataSecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// check for a "user" in session. If one exists, return true, otherwise return
		// false
//		System.out.println(request.getSession().getAttribute("user"));
		Object objUser = request.getSession().getAttribute("user");
		if (objUser != null) {
			User user = (User) objUser;

			// compare id in url to id from User obj
			int id = Integer.parseInt(request.getRequestURI().split("/")[4]);
//			System.out.println("id" + id + ", url: " + request.getRequestURI());

			if (id == user.getId()) {
				return true;
			}
		}
		response.sendRedirect("/JobAppTrackerREST/rest/auth/unauthorized");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
