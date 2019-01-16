package kr.green.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AccountService accountService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		/* 컨트롤러에서 jsp로 데이터를 전달하기 위해서 
		 * 1. 매개변수에 model 객체를 추가 : Model model
		 * 2. model.addAttribute()를 통해 데이터 전달
		 *    model.addattribute("jsp에서 받는 이름", 전달할 데이터);*/
//		model.addAttribute("serverTime", "서버시간" );
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String name) {
		/* jsp에서 넘겨준데이터를 받기 위해서는 태그의 속성 name과 일치하는
		 * 이름을 매개변수의 이름으로 설정한다. */
		System.out.println("jsp에서 넘어온 값 : "+name);
		return "redirect:/";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {
		if(fail == null) {
			fail = false;
		}
		model.addAttribute("fail", fail);
		return "account/signup";
	}
	//int -> Interget , double -> Double, boolean -> Boolean
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo,Model model) {
		if(accountService.signup(accountVo))
			return "redirect:/";
		else {
			model.addAttribute("fail",true);
			return "redirect:/signup";
		}
	}
}