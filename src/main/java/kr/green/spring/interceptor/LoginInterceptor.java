package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;


public class LoginInterceptor 
	extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    //ModelMap modelMap = modelAndView.getModelMap();
	    //AccountVo user = (AccountVo)modelMap.get("user");
		//위의 2줄을 아래 한줄로도 가능
	    AccountVo user = (AccountVo)modelAndView.getModelMap().get("user");

	    if(user != null) {  //null이 아닌경우에만 세션에 user정보를 저장
	        //HttpSession session = request.getSession();
	        //session.setAttribute("user", user);
	    	//위의 2줄을 아래 한줄로도 가능
	    	request.getSession().setAttribute("user",user);
	    }
	}

}

