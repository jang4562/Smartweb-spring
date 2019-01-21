package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;


@Controller
//controller : 정보를 보내주는 역할
public class HomeController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		/*컨트롤러에서 jsp로 데이터를 전달하기 위해서
		 * 1. 매개변수에 Model 객체를 추가 :Model model 
		 * 2. model.addAttribute()를 통해 데이터 전달
		 *    model.addAttribute("jsp에서 받는 이름",전달할 데이터);*/
		//model.addAttribute("serverTime", "서버시간" );   //서버시간이라는 문자열을 전달함
		//System.out.println(accountService.getAccount("eunseon"));
		
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id, String pw, Model model) {    //home.jsp 에서 넘어온 name과 동일해야 함
		/*jsp에서 넘겨준 데이터를 받기 위해서는 태그의속성 name과 일치하는 이름을 매개변수의 이름으로 설정한다. 
		System.out.println("jsp에서 넘어온 값: " +name);*/
	
		//1.로그인 버튼을 눌렀을때 이동하는 컨트롤러에서 아이디와 비밀번호가 제대로 넘어가는지 확인(콘솔에 입력된 값이 출력)
		//System.out.println(id);
		//System.out.println(pw);
		AccountVo user =accountService.signin(id,pw);
		if(user != null){
			model.addAttribute("user", user);
			return "redirect:/bbs/list";   //회원이면 게시판으로 넘어감
		}
		else {
			return "redirect:/";   //해당 URI을 바로 들어가지 않고 다시 한번 찾아서 추가 브라우저 통해서 열어줌
		}
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {
		
		/*
		if(fail == null ) {  //http://localhost:8080/spring/signup?fail이라는 값이 없으면 null값이자동으로 들어감
			fail = false;   //false면 아무것도 안나타남. 중복일 경우 >>true >> 중복메세지 알람창 띄워줌
		}  */
		model.addAttribute("fail", fail);
		return "account/signup";
				
	}
	//int -> integer, double -> Double , boolean -> Boolean  (일반 자료형을 클래스 타입으로 만들어 놓음, null값 허용가능하게 함)
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPOST(AccountVo accountVo,Model model) {
		if(accountService.signup(accountVo))     //중복된 아이디로 제출 했을경우 다시 회원가입 페이지로 되돌아감,  Vo: 여러개의 객체정보를 가져올때 
			return "redirect:/";
		else {
			model.addAttribute("fail", true);
			return "redirect:/signup";
		}
	}
}
