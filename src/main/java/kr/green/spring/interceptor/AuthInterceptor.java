package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//회원정보 있을 경우에만 게시판 페이지로 보내짐
public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			Object user = session.getAttribute("user");
			if(user == null ) { //회원정보가 없다면   
				response.sendRedirect(request.getContextPath()+"/");  
			}
			return true;     //return이 false면 해당 controller로 안보내짐
			}
	 	}
