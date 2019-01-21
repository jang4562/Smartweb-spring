package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UnauthInterceptor extends HandlerInterceptorAdapter{ 
	//UnauthInterceptor >> 로그인정보가 없는 것 user관리위해
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			Object user = session.getAttribute("user");
			//Object user = request.getSession().getAttribute("user");
			
			if(user != null ) {  //회원정보가 있다면
				response.sendRedirect(request.getContextPath()+"/bbs/list");   
				//로그인정보가 있으면 게시판 페이지로 보내기
			}
			return true;
			}
	}
